package model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleName {
    ADMIN(0),
    USER(1),
    GUEST(2);

    private final int value;
    private static Map map = new HashMap<>();

    static {
        for (RoleName roleName : RoleName.values()) {
            map.put(roleName.value, roleName);
        }
    }

    public static RoleName valueOf(int roleName) {
        return (RoleName) map.get(roleName);
    }

    RoleName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
