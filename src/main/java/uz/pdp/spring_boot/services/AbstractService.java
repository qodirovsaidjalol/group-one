package uz.pdp.spring_boot.services;

import uz.pdp.spring_boot.mapper.Mapper;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.organization.Validator;

/**
 * @param <R> repository
 * @param <M>
 * @param <V>
 */
public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper,
        V extends Validator> {
    protected final R repository;
    protected final M mapper;
    protected final V validator;
    protected final BaseUtils baseUtils;

    protected AbstractService(R repository, M mapper, V validator, BaseUtils baseUtils) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.baseUtils = baseUtils;
    }
}
