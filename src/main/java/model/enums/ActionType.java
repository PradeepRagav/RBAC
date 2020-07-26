package model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {
    READ(0),
    WRITE(1),
    DELETE(2);

    private final int value;

    private static Map map = new HashMap<>();

    static {
        for (ActionType actionType : ActionType.values()) {
            map.put(actionType.value, actionType);
        }
    }

    public static ActionType valueOf(int actionType) {
        return (ActionType) map.get(actionType);
    }

    ActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
