import java.util.*;
class Course {
    String courseCode;
    int capacity;
    HashSet<String> enrolledStudents;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;
    Course(String courseCode, int capacity, ArrayList<String> prerequisites) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
        this.enrolledStudents = new HashSet<>();
        this.waitlist = new LinkedList<>();
    }
    boolean registerStudent(String studentId, HashSet<String> completedCourses) {
        for (String prerequisite : prerequisites) {
            if (!completedCourses.contains(prerequisite)) {
                return false;
            }
        }
        if (enrolledStudents.contains(studentId) || waitlist.contains(studentId)) {
            return false;
        }
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentId);
            return true;
        } else {
            waitlist.addLast(studentId);
            return false;
        }
    }
    void promoteFromWaitlist() {
        while (enrolledStudents.size() < capacity && !waitlist.isEmpty()) {
            enrolledStudents.add(waitlist.removeFirst());
        }
    }
    void dropStudent(String studentId) {
        if (enrolledStudents.remove(studentId)) {
            promoteFromWaitlist();
        }
    }
}
class CourseRegistrationPortal {
    HashMap<String, Course> courses = new HashMap<>();
    void addCourse(String courseCode, int capacity, ArrayList<String> prerequisites) {
        courses.put(courseCode, new Course(courseCode, capacity, prerequisites));
    }
    boolean register(String courseCode, String studentId, HashSet<String> completedCourses) {
        Course course = courses.get(courseCode);
        if (course == null) {
            return false;
        }
        return course.registerStudent(studentId, completedCourses);
    }
    void drop(String courseCode, String studentId) {
        Course course = courses.get(courseCode);

        if (course != null) {
            course.dropStudent(studentId);
        }
    }
}
public class Q1 {
    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();
        ArrayList<String> prerequisites1 = new ArrayList<>();
        portal.addCourse("UCS553", 2, prerequisites1);
        ArrayList<String> prerequisites2 = new ArrayList<>();
        prerequisites2.add("UCS553");
        portal.addCourse("CS201", 2, prerequisites2);
        HashSet<String> completedCourses1 = new HashSet<>();
        completedCourses1.add("UCS553");
        HashSet<String> completedCourses2 = new HashSet<>();
        System.out.println(portal.register("UCS553", "101", completedCourses2));
        System.out.println(portal.register("UCS553", "102", completedCourses2));
        System.out.println(portal.register("UCS553", "103", completedCourses2));

        System.out.println(portal.register("CS201", "101", completedCourses1));
        portal.drop("UCS553", "101");
        Course course = portal.courses.get("UCS553");
        System.out.println("Enrolled Students: " + course.enrolledStudents);
        System.out.println("Waitlist: " + course.waitlist);
    }
}