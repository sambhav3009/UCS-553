package library.main;
import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.ResourceService;
public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = new LibraryResource[5];
        resources[0]=new Book(
                101, "Java Programming", "James Gosling");
        resources[1]=new DigitalResource(
                102, "Artificial Intelligence", "Stuart Russell");
        resources[2]=new Book(
                103, "Data Structures", "Mark Allen");
        resources[3]=new DigitalResource(
                104, "Machine Learning", "Tom Mitchell");
        resources[4]=new Book(
                105, "Operating Systems", "Abraham Silberschatz");
        int[] overdueDays = {5, 3, 0, 7, 4};

        System.out.println("===== SMART LIBRARY =====");
        System.out.println("Library Name: "
                + LibraryResource.getLibraryName());
        System.out.println();
        System.out.println("===== RESOURCE DETAILS =====");
        for (LibraryResource resource : resources) {
            if (resource instanceof library.model.Printable) {
                library.model.Printable printable =
                        (library.model.Printable) resource;
                printable.printDetails();
                System.out.println();
            }
        }
        System.out.println("===== TOTAL FINE =====");
        double totalFine =
                ResourceService.calculateTotalFine(resources, overdueDays);
        System.out.println("Total Fine: Rs. " + totalFine);
        System.out.println();
        LibraryResource.displayTotalResources();
    }
}