package fung.jxls.c_3;

import java.util.ArrayList;
import java.util.List;

public class Clazz {

    private String name;

    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Clazz setName(String name) {
        this.name = name;
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Clazz setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    public Clazz addStudent(Student student) {
        students.add(student);
        return this;
    }
}
