package library.service;
import library.model.LibraryResource;
import library.util.InputValidator;
public class ResourceService {
    public static void displayResources(LibraryResource[] resources) {
        for (LibraryResource resource : resources) {
            if (resource !=null) {
                if (InputValidator.validateResourceId(resource.getResourceId())) {

                    System.out.println("------------------------------");
                    System.out.println("Resource ID : " +resource.getResourceId());
                    System.out.println("Title       : " +resource.getTitle());
                    System.out.println("Author      : " +resource.getAuthor());
                }
            }
        }
    }
    public static double calculateTotalFine(
            LibraryResource[] resources, int[] overdueDays) {

        double totalFine=0;
        for (int i=0; i<resources.length; i++) {
            if (resources[i] !=null &&
                    InputValidator.validateFineDays(overdueDays[i])) {
                totalFine +=resources[i].calculateFine(overdueDays[i]);
            }
        }
        return totalFine;
    }
}