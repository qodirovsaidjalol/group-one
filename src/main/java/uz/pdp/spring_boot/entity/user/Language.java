package uz.pdp.spring_boot.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    UZ("Uzbek"),
    RU("Russian"),
    EN("England");

    private final String name;

    public String getName() {
        return "";
    }

    public String getCode() {
        return "";
    }

}
