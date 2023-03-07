package template;

public class Client {

    public static void main(String[] args) {
        AbstractTemplate template1 = new ConTemplate1();
        template1.doSomething();

        AbstractTemplate template2 = new ConTemplate2();
        template2.doSomething();
    }
}
