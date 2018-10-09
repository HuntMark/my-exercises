package my.rinat.enums;

public enum TestEnum {

    CONST1("Const 1"),
    CONST2("Const 2");

    private String value;

    TestEnum(String value) {
        System.out.println(this.name() + " enum initialization started...");
        this.value = value;
        System.out.println(this.name() + " enum initialization ended...");
    }

    public String getValue() {
        return value;
    }
}
