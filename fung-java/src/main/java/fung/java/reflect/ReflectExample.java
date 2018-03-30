package fung.java.reflect;

public class ReflectExample {

    public ReflectExample() {

    }

    public ReflectExample(String str) {
        this.str = str;
    }

    private String str;

    private int i;

    public void helloReflect() {
        System.out.println("Hello Reflect");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
