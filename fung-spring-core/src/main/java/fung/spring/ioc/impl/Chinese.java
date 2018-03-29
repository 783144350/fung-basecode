package fung.spring.ioc.impl;

import fung.spring.ioc.Axe;
import fung.spring.ioc.Person;

public class Chinese implements Person {

    private Axe axe;

    private String name;

    public Chinese() {

    }

    public Chinese(String name, Axe axe) {
        this.name = name;
        this.axe = axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    @Override
    public void useAxe() {
        System.out.println("Chines ues axe");
        System.out.println("My name is: " + name);
        axe.ues();
    }
}
