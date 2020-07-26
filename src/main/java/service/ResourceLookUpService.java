package service;

import model.ResourceNode;

public class ResourceLookUpService {

    public static class SearchRole{
        Integer role;

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }
    }

    /*
    Get the role at the least depth if the user has access to muliple resources/ resource group
    * */
    public static void getRole(Integer userId, Integer resourceId, ResourceNode resourceNode, SearchRole role){

        if(resourceNode == null){
            return;
        }

        if(resourceNode.getId() == resourceId
            && resourceNode.getUserId().keySet().contains(userId)){
            role.role =resourceNode.getUserId().get(userId);
        }

        if(resourceNode.getChildResorces() == null || resourceNode.getChildResorces().isEmpty()) {
            return;
        }

        for(ResourceNode node : resourceNode.getChildResorces()){
            getRole(userId, resourceId, node, role);
        }
    }

    /*
    Find the resource by resource id in the multi node tree
    * */
    public static ResourceNode findResourceNode(ResourceNode resourceNode, Integer resourceId){

        if(resourceNode.getId().equals(resourceId)){
            return resourceNode;
        }

        if(resourceNode.getChildResorces() == null || resourceNode.getChildResorces().isEmpty()) {
            return null;
        }

        for(ResourceNode node : resourceNode.getChildResorces()){
            ResourceNode resourceNode1 = findResourceNode(node, resourceId);
            if(resourceNode1!=null) return resourceNode1;
        }

        return null;
    }

    /*
    Print all the resource nodes in DFS
    * */
    public static void printResources(ResourceNode root){

        if(root == null) {
            return;
        }
        System.out.println(root);

        if(root.getChildResorces() == null || root.getChildResorces().isEmpty()) {
            return;
        }

        for(ResourceNode node : root.getChildResorces()){
            printResources(node);
        }
    }
}
