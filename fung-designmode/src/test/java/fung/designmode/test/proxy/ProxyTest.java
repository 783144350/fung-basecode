package fung.designmode.test.proxy;

import org.junit.Test;

import fung.designmode.proxy.exp1.RealSubject;
import fung.designmode.proxy.exp1.Subject;
import fung.designmode.proxy.exp1.SubjectProxy;

public class ProxyTest {

    @Test
    public void testProxy() {
        Subject subject = new SubjectProxy(new RealSubject());
        subject.doSomething();
    }

}
