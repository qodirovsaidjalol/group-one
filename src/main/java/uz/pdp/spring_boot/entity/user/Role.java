package uz.pdp.spring_boot.entity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.entity.permission.Permission;

import java.util.List;

@AllArgsConstructor
public enum Role {
    ADMIN("Admin"), EMPLOYEE("Employee"), MANAGER("Manager");

    private final String name;

    public String getName() {
        return "";
    }

    public String getCode() {
        return null;
    }

    public List<Permission> getPermissions() {
        return null;
    }
}
