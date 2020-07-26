package service;



import model.enums.ActionType;
import model.enums.RoleName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService {

    Map<RoleName, List<ActionType>> roles = new HashMap<>();

    public Map<RoleName, List<ActionType>> getRoles() {
        if(roles.isEmpty()){
            roles.put(RoleName.ADMIN, Arrays.asList(ActionType.READ,ActionType.WRITE,ActionType.DELETE));
            roles.put(RoleName.USER, Arrays.asList(ActionType.READ,ActionType.WRITE));
            roles.put(RoleName.GUEST, Arrays.asList(ActionType.READ));
        }
        return roles;
    }


}
