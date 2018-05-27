package fung.jxls;

public class Employee {

    private String name;

    private int age;

    private double payment;

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public double getPayment() {
        return payment;
    }

    public Employee setPayment(double payment) {
        this.payment = payment;
        return this;
    }
}
