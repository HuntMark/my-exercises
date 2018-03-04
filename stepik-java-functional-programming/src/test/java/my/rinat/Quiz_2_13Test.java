package my.rinat;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Quiz_2_13Test {

    @Test
    public void test() {
        List<Student> students = Arrays.asList(
                new Student("A", 10),
                new Student("B", 15)
        );

        students.sort(
                comparing(Student::getCsGrade, reverseOrder())
                        .thenComparing(Student::getName));

        System.out.println(students);
    }

    private static class Student {
        private String name;
        private int csGrade;

        Student(String name, int csGrade) {
            this.name = name;
            this.csGrade = csGrade;
        }

        String getName() {
            return name;
        }

        int getCsGrade() {
            return csGrade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", csGrade=" + csGrade +
                    '}';
        }
    }
}
