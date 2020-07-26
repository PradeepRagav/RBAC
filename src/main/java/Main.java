

import service.CLIService;
import service.ResourceService;

import java.util.Scanner;

public class Main {


    private ResourceService resourceService = new ResourceService();

    public static void main(String[] args) {
	// write your code here

        Main main = new Main();
        main.resourceService.printResources();
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("Select operation : ");
            System.out.println("1. Print Resources");
            System.out.println("2. Add Resource");
            System.out.println("3. Grant access to User");
            System.out.println("4. Check access of User");

            int option = in.nextInt();
            switch (option){
            case 1 :
                CLIService.printResourceAction(main.resourceService);
                break;
            case 2 :
                CLIService.addResourceAction(main.resourceService);
                break;
            case 3 :
                CLIService.grantAccessAction(main.resourceService);
                break;
            case 4 :
                CLIService.checkAccessAction(main.resourceService);
                break;
            default:
                System.out.println("Invalid option number");
            }
        }
    }
}
