package template;

public abstract class AbstractTemplate {

    protected abstract boolean check();

    protected void check1() {
        System.out.println("check1");
    }

    protected void check2() {
        System.out.println("check2");
    }

    protected final void doSomething() {
        if(check()) {
            this.check1();
            return;
        }
        this.check2();
    }
}
