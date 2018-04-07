package fung.spring.ioc.impl;

import fung.spring.ioc.Axe;
import fung.spring.ioc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {

    @Autowired
    @Qualifier("axe")
    private Axe axe22;

    private String name;

    public Chinese() {

    }

    public Chinese(String name, Axe axe) {
        this.name = name;
        this.axe22 = axe;
    }

    public void setAxe2(Axe axe) {
        this.axe22 = axe;
    }

    public void useAxe() {
        System.out.println("Chines ues axe");
        System.out.println("My name is: " + name);
        axe22.ues();
    }

}
