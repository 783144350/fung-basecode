package fung.designmode.proxy.exp1;

public class SubjectProxy implements Subject{

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomething() {
        System.out.println("Before real subject do something");
        subject.doSomething();
        System.out.println("After real subject do something");
    }
}
