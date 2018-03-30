package fung.java.annotation;

public class AnnotationExample {

    @MethodInfo(comments = "hello annotation", date = "2018-3-30")
    public void helloAnnotation() {
        System.out.println("hello annotation");
    }
}
