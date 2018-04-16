package fung.java.enumtest;

public enum Type {

    STRING("String"),
    INTEGER("Integer"),
    FLOAT("Float");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
