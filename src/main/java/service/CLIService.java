package service;

import model.ResourceNode;
import model.enums.ActionType;
import model.enums.RoleName;

import java.util.Random;

public class CLIService {


    private static java.util.Scanner in = new java.util.Scanner(System.in);
    public static void printResourceAction(ResourceService resourceService){
        resourceService.printResources();
    }

    public static void addResourceAction(ResourceService resourceService){
        System.out.println("Select resource Id");
        resourceService.printResources();
        System.out.println("Enter parent resource Id");
        int parentResourceId = in.nextInt();
        ResourceNode resourceNode = new ResourceNode(new Random().nextInt(ApplicationConstants.MAX_RESOURCES));
        resourceService.addResource(parentResourceId,resourceNode);
    }

    public static void grantAccessAction(ResourceService resourceService){

        System.out.println("Enter the userId (1-100):");
        int userId = in.nextInt();
        resourceService.printResources();
        System.out.println("Enter the resourceId :");
        int resourceId = in.nextInt();
        System.out.println("Select a RoleName :");
        System.out.println("1. Admin (READ,WRITE,DELETE)");
        System.out.println("2. User (READ,WRITE)");
        System.out.println("3. Guest (READ)");
        int roleId = in.nextInt() -1;

        resourceService.grantAccess(userId,resourceId, RoleName.valueOf(roleId));
    }

    public static void checkAccessAction(ResourceService resourceService){
        System.out.println("Enter the userId (1-100):");
        int userId = in.nextInt();
        resourceService.printResources();
        System.out.println("Enter the resourceId :");
        int resourceId = in.nextInt();
        System.out.println("Select the Action type :");
        System.out.println("1. READ");
        System.out.println("2. WRITE");
        System.out.println("3. DELETE");
        int actionId = in.nextInt();

        if(resourceService.checkAccess(userId,resourceId, ActionType.valueOf(actionId))){
            System.out.println("The user has access");
        }else{
            System.out.println("The user doesnt have access");
        }
    }
}
