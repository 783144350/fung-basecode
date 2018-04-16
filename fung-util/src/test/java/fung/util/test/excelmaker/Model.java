package fung.util.test.excelmaker;

import fung.util.excelhelper.ExcelHead;

public class Model {

    @ExcelHead(value = "姓名", index = 0)
    private String name;

    @ExcelHead(value = "年龄", index = 1)
    private Integer age;

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Model setAge(Integer age) {
        this.age = age;
        return this;
    }
}
