package fung.jxls.c_3;

import java.util.ArrayList;
import java.util.List;

public class School {

    private String name;

    private List<Clazz> clazzes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public School setName(String name) {
        this.name = name;
        return this;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public School setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
        return this;
    }

    public School addClazz(Clazz clazz) {
        clazzes.add(clazz);
        return this;
    }
}
