//package uz.pdp.spring_boot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import uz.pdp.spring_boot.entity.organization.Organization;
//import uz.pdp.spring_boot.entity.user.AuthUser;
//import uz.pdp.spring_boot.entity.user.Role;
//import uz.pdp.spring_boot.reposiroty.AuthUserRepository;
//import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
//import uz.pdp.spring_boot.reposiroty.PermissionRepository;
//
//@SpringBootApplication
//public class SpringApp  {
//    AuthUserRepository repository;
//    PermissionRepository permissionRepository;
//    OrganizationRepository organizationRepository;
//    AuthUserRepository authUserRepository;
//
//    @Autowired
//    public SpringApp(AuthUserRepository repository, PermissionRepository permissionRepository, OrganizationRepository organizationRepository) {
//        this.repository = repository;
//        this.permissionRepository = permissionRepository;
//        this.organizationRepository = organizationRepository;
//    }
//
//    public void run(String... args) throws Exception {
////        Organization organization = new Organization();
////        organization.setCode("1230");
////        organization.setEmail("pdp@gmail.com");
////        organization.setLogo("PDP");
////        organization.setName("PDP");
////
////        Organization org2 = new Organization();
////        org2.setCode("1236466");
////        org2.setEmail("ecma@gmail.com");
////        org2.setLogo("ECMA");
////        org2.setName("ECMA");
////        organizationRepository.save(organization);
////        organizationRepository.save(org2);
////        Role role=new Role();
////        role.setName("Admin");
////        role.setCode("ADMIN");
////
////         Role role1=new Role();
////        role.setName("User");
////        role.setCode("USER");
////        roleRepository.save(role);
////        roleRepository.save(role1);
////        Permission permission=new Permission();
////          permission.setCode("CREATE_USER");
////          permission.setName("create user");
////        Permission permission1=new Permission();
////        permission.setCode("CREATE_PROJECT");
////        permission.setName("create project");
////        Permission permission2=new Permission();
////        permission.setCode("CREATE_TASK");
////        permission.setName("create task");
////        Permission permission3=new Permission();
////        permission.setCode("CREATE_COLUM");
////        permission.setName("create colum");
////        permissionRepository.save(permission);
////        permissionRepository.save(permission1);
////        permissionRepository.save(permission2);
////        permissionRepository.save(permission3);
//
//        AuthUser user = new AuthUser();
//        user.setPassword("123");
//        user.setRole(Role.ADMIN);
//        user.setUsername("super");
//        user.setActive(true);
//        user.setDeleted(false);
//        authUserRepository.save(user);
//    }
//}
