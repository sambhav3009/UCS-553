import java.io.*;

public class q1 {

    static void makeBinFile(String name) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name);
            for (int i = 0; i < 256; i++) {
                out.write(i);
            }
            System.out.println("Created binary file: " + name);
        } catch (IOException e) {
            System.out.println("Could not create file: " + e.getMessage());
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
    }

    static void copyFile(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);

            byte[] buf = new byte[1024];
            int n;
            int count = 0;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
                count += n;
            }
            System.out.println("Copied " + count + " bytes from " + src + " to " + dest);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while copying: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
    }

    static void saveStudents(String name) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(name);
            fw.write("RollNo,Name,Branch,CGPA\n");
            fw.write("101,Aman Sharma,CSE,8.7\n");
            fw.write("102,Priya Verma,ECE,9.1\n");
            fw.write("103,Rahul Singh,ME,7.8\n");
            fw.write("104,Sneha Gupta,CSE,8.9\n");
            System.out.println("Student data saved in " + name);
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
    }

    static void showStudents(String name) {
        FileReader fr = null;
        try {
            fr = new FileReader(name);
            System.out.println("\nData in " + name + ":");
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        makeBinFile("input.bin");
        copyFile("input.bin", "output.bin");

        saveStudents("students.txt");
        showStudents("students.txt");
    }
}
