package uz.pdp.spring_boot.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.mapper.TaskMapper;
import uz.pdp.spring_boot.reposiroty.ColumRepository;
import uz.pdp.spring_boot.reposiroty.ProjectRepository;
import uz.pdp.spring_boot.reposiroty.TaskRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper> implements TaskService {

    private final ProjectRepository projectRepository;
    private final ColumRepository columnRepository;
    private final FileStorageService fileStorageService;

    @Autowired
    protected TaskServiceImpl(TaskRepository repository, @Qualifier("taskMapperImpl") TaskMapper mapper, BaseUtils baseUtils, ProjectRepository projectRepository, ColumRepository columnRepository, FileStorageService fileStorageService) {
        super(repository, mapper, baseUtils);
        this.projectRepository = projectRepository;
        this.columnRepository = columnRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(TaskCreateDto createDto) {
        Task task = mapper.fromCreateDto(createDto);
        task.setProject(projectRepository.findProjectById(createDto.getProjectId()));
        task.setColumn(columnRepository.findColumnById(createDto.getColumnId()));
        task.setTz_path(fileStorageService.store(createDto.getTz_path()));
        repository.save(task);
        return task.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(TaskUpdateDto updateDto) {
        System.out.println(updateDto.getId());
        repository.update(updateDto.getName(),updateDto.getDescription(),columnRepository.findColumnById(updateDto.getColumnId()),updateDto.getId());
        return null;
    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public TaskDto get(Long id) {
        return mapper.toDto(repository.findTaskById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<TaskDto> getAllByColumn(Long id) {
        List<TaskDto> taskDtos = mapper.toDto(repository.getAllByColumnId(columnRepository.findColumnById(id)));
        for (TaskDto taskDto : taskDtos) {
            taskDto.setTz_path(getTask(taskDto.getId()).getTz_path());
        }
        return taskDtos;
    }

    @Override
    public Task getTask(Long id) {
        return repository.getTask(id);
    }
}
