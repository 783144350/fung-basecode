package fung.java.test.concurrent;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest t1 = new ThreadJoinTest("t1");
        ThreadJoinTest t2 = new ThreadJoinTest("t2");
        t1.start();
        int a = 1 / 0;
        t1.join();
        System.out.println("t1 finish");
        t2.start();
    }

    static class ThreadJoinTest extends Thread{
        public ThreadJoinTest(String name){
            super(name);
        }
        @Override
        public void run(){
            System.out.println(this.getName() + " start");
            //throw new RuntimeException();

//            for(int i=0;i<10;i++){
//                System.out.println(this.getName() + ":" + i);
//            }
        }
    }

}
