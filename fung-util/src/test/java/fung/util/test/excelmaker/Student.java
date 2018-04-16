package fung.util.test.excelmaker;

import java.util.Date;

import fung.util.excelhelper.ExcelHead;

public class Student {

    @ExcelHead(value = "姓名", index = 0)
    private String name;

    @ExcelHead(value = "年龄", index = 1)
    private Integer age;

    @ExcelHead(value = "出生日期", index = 2)
    private Date birthday;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Student setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
