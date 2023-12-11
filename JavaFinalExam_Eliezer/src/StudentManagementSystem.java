import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Sample students
        Student student1 = new Student("001", "Eliezer", 36);
        student1.addCourse("Java");
        student1.addCourse("Cloud");

        Student student2 = new Student("002", "Gabriel", 30);
        student2.addCourse("HTML");
        student2.addCourse("CSS");

        Student student3 = new Student("003", "Aline", 32);
        student3.addCourse("JavaScript");
        student3.addCourse("Database");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Students enrolled in a specific course
        String course = "Java";
        System.out.println("Students enrolled in " + course + ":");
        students.stream()
                .filter(s -> s.getCourses().contains(course))
                .forEach(Student::displayDetails);

        // Updating the age of the chosen student
        String studentIdToUpdate = "001";
        students.stream()
                .filter(s -> s.getStudentId().equals(studentIdToUpdate))
                .forEach(s -> s.setAge(33));

         // Displaying all students
        students.forEach(Student::displayDetails);

        // Average age of all students
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of all students: " + averageAge);
    }
}
