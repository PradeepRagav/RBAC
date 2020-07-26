package service;


import model.ResourceNode;
import model.enums.ActionType;
import model.enums.RoleName;

import java.util.*;

public class ResourceService {

    private ResourceNode root = new ResourceNode(new Random().nextInt(ApplicationConstants.MAX_RESOURCES));
    private RoleService roleService = new RoleService();

    public void printResources(){
        ResourceLookUpService.printResources(root);
    }

    public void addResource(Integer parentResourceId, ResourceNode newResourceNode){

        ResourceNode parentResourceNode = ResourceLookUpService.findResourceNode(root, parentResourceId);
        if(null == parentResourceNode){
            System.out.println("Parent resource NOT FOUND");
            return;
        }

        List<ResourceNode> childResorces = parentResourceNode.getChildResorces();
        if(childResorces == null || childResorces.isEmpty()){
            childResorces = new ArrayList<>();
        }
        childResorces.add(newResourceNode);
        parentResourceNode.setChildResorces(childResorces);
    }

    public boolean checkAccess(Integer userId, Integer resourceId, ActionType actionType){

        ResourceLookUpService.SearchRole searchRole = new ResourceLookUpService.SearchRole();
        searchRole.setRole(-1);
        ResourceLookUpService.getRole(userId, resourceId, root, searchRole);

        if(searchRole.getRole() == -1){
            System.out.println("User is not associated with the resource");
            return false;
        }
        Map<RoleName, List<ActionType>> roles =
            roleService.getRoles();
        List<ActionType> actionTypes = roles.get(RoleName.valueOf(searchRole.getRole()));
        return actionTypes.contains(actionType);
    }

    public void grantAccess(Integer userId, Integer resourceId, RoleName roleName){

        ResourceNode targetResourceNode = ResourceLookUpService.findResourceNode(root, resourceId);

        if(targetResourceNode == null){
            System.out.println("Resource NOT FOUND");
            return;
        }

        Map<Integer, Integer> userMap = targetResourceNode.getUserId();
        if(userMap == null || userMap.isEmpty()){
            userMap = new HashMap<>();
        }
        userMap.put(userId,roleName.getValue());
        targetResourceNode.setUserId(userMap);
    }
}
