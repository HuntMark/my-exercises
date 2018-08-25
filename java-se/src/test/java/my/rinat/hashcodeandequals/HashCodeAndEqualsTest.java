package my.rinat.hashcodeandequals;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rinat_Zalyaletdinov
 */
public class HashCodeAndEqualsTest {

    @Test
    public void theSameStudentsWithoutOverrodeEqualsShouldNotBeEqual() {
        StudentByDefault student1 = new StudentByDefault(1, "John Doe");
        StudentByDefault student2 = new StudentByDefault(1, "John Doe");

        Assert.assertEquals(student1, student1);
        Assert.assertNotEquals(student1, student2);
    }

    @Test
    public void theSameStudentsWithoutOverrodeEqualsShouldNotBeFoundWithinList() {
        StudentByDefault student1 = new StudentByDefault(1, "John Doe");
        StudentByDefault student2 = new StudentByDefault(1, "John Doe");

        List<StudentByDefault> students = new ArrayList<>();
        students.add(student1);

        Assert.assertFalse(students.contains(student2));
    }

    @Test
    public void theSameStudentsWithOverrodeEqualsShouldBeEqual() {
        StudentWithEquals student1 = new StudentWithEquals(1, "John Doe");
        StudentWithEquals student2 = new StudentWithEquals(1, "John Doe");

        Assert.assertEquals(student1, student2);
    }

    @Test
    public void theSameStudentsWithOverrodeEqualsShouldBeFoundWithinList() {
        StudentWithEquals student1 = new StudentWithEquals(1, "John Doe");
        StudentWithEquals student2 = new StudentWithEquals(1, "John Doe");

        List<StudentWithEquals> students = new ArrayList<>();
        students.add(student1);

        Assert.assertTrue(students.contains(student2));
    }

    @Test
    public void theSameStudentsWithoutOverrodeHashCodeShouldNotBeFoundWithinHashSet() {
        StudentWithEquals student1 = new StudentWithEquals(1, "John Doe");
        StudentWithEquals student2 = new StudentWithEquals(1, "John Doe");

        Set<StudentWithEquals> students = new HashSet<>();
        students.add(student1);

        Assert.assertFalse(students.contains(student2));
    }

    @Test
    public void theSameStudentsWithOverrodeHashCodeShouldBeFoundWithinHashSet() {
        StudentWithHashCodeAndEquals student1 = new StudentWithHashCodeAndEquals(1, "John Doe");
        StudentWithHashCodeAndEquals student2 = new StudentWithHashCodeAndEquals(1, "John Doe");

        Set<StudentWithHashCodeAndEquals> students = new HashSet<>();
        students.add(student1);

        Assert.assertTrue(students.contains(student2));
    }

    public static class StudentByDefault {

        private int id;
        private String name;

        public StudentByDefault(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class StudentWithEquals {

        private int id;
        private String name;

        public StudentWithEquals(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof StudentWithEquals)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.getId() == ((StudentWithEquals) obj).getId();
        }
    }

    public static class StudentWithHashCodeAndEquals {

        private int id;
        private String name;

        public StudentWithHashCodeAndEquals(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof StudentWithHashCodeAndEquals)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.getId() == ((StudentWithHashCodeAndEquals) obj).getId();
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }
}
