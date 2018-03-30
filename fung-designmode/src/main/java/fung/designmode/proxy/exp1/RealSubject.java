package fung.designmode.proxy.exp1;

public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("Real subject do something");
    }

}
