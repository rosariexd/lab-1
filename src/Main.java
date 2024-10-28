import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Sam Ray", "A", 1, List.of(3, 2, 2)));
        students.add(new Student("Kitty Ray", "A", 1, List.of(4, 4, 4)));
        students.add(new Student("Tim Charles", "B", 3, List.of(4, 4, 4)));
        students.add(new Student("Daniel Presland", "C", 3, List.of(5, 5, 5)));

        students = promoteStudents(students);

        for (int course = 1; course <= 4; course++) {
            printStudents(students, course);
        }
    }

    public static List<Student> promoteStudents(List<Student> students) {
        List<Student> updatedList = new ArrayList<>();
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.increaseCourse();
                updatedList.add(student);
            }
        }
        return updatedList;
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Students on course " + course + ":");
        boolean hasStudents = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                hasStudents = true;
            }
        }
        if (!hasStudents) {
            System.out.println("There are no students on course " + course + ".");
        }
        System.out.println();
    }
}