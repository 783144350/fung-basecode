package fung.mybatis.pojos;

public class User {

    private Long id;
    private String name;
    private Integer age;
    private Integer cid;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getCid() {
        return cid;
    }

    public User setCid(Integer cid) {
        this.cid = cid;
        return this;
    }
}
