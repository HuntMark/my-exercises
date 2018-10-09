package my.rinat.enums;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class PointsAboutEnums {

    /*
     Enum constants are created only once for the whole execution.
     All enum constants are created when you initially refer any
     enum constant in your code. While creating each enum constant,
     the corresponding constructor is called.
     */

    @Test
    public void test1EnumInit() {
        System.out.println("BEGIN Enum Init");
        System.out.println(TestEnum.CONST1);
        System.out.println(TestEnum.CONST2);
    }

    @Test
    public void test2EnumUsing() {
        System.out.println("BEGIN Enum Using");
        System.out.println(TestEnum.CONST1);
        System.out.println(TestEnum.CONST2);
    }
}
