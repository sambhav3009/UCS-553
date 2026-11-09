import java.io.*;
import java.util.ArrayList;

class Employee implements Serializable {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t" + dept + "\t\t" + salary);
    }
}

public class q3 {

    static void saveEmployees(ArrayList<Employee> list, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeInt(list.size());
            for (Employee e : list) {
                oos.writeObject(e);
            }
            System.out.println("Saved " + list.size() + " employees to " + file);
        } catch (IOException e) {
            System.out.println("Error while saving: " + e.getMessage());
        }
    }

    static ArrayList<Employee> loadEmployees(String file) {
        ArrayList<Employee> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            int n = ois.readInt();
            for (int i = 0; i < n; i++) {
                list.add((Employee) ois.readObject());
            }
            System.out.println("Loaded " + n + " employees from " + file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading: " + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1, "Amit Kumar", "IT", 75000));
        emps.add(new Employee(2, "Neha Sharma", "HR", 55000));
        emps.add(new Employee(3, "Ravi Patel", "Finance", 68000));
        emps.add(new Employee(4, "Simran Kaur", "Marketing", 62000));

        saveEmployees(emps, "employees.ser");

        ArrayList<Employee> result = loadEmployees("employees.ser");

        System.out.println("\nID\tName\t\tDept\t\tSalary");
        for (Employee e : result) {
            e.display();
        }
    }
}
