package fung.mybatis.pojos.vo;

import java.util.List;

public class CourseV {

    private String name;
    private Integer score;

    private List<BookV> bookVList;

    public String getName() {
        return name;
    }

    public CourseV setName(String name) {
        this.name = name;
        return this;
    }

    public List<BookV> getBookVList() {
        return bookVList;
    }

    public CourseV setBookVList(List<BookV> bookVList) {
        this.bookVList = bookVList;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public CourseV setScore(Integer score) {
        this.score = score;
        return this;
    }
}
