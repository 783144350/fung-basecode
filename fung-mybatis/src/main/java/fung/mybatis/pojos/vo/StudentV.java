package fung.mybatis.pojos.vo;

import java.util.List;

public class StudentV {

    private String name;

    private List<CourseV> courseVList;

    public String getName() {
        return name;
    }

    public StudentV setName(String name) {
        this.name = name;
        return this;
    }

    public List<CourseV> getCourseVList() {
        return courseVList;
    }

    public StudentV setCourseVList(List<CourseV> courseVList) {
        this.courseVList = courseVList;
        return this;
    }
}
