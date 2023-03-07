package template;

public abstract class AbstractTemplate {

    protected abstract boolean check();

    protected void check1() {
        System.out.println("check1");
    }

    protected void check2() {
        System.out.println("check2");
    }

    //就是一系列操作的聚合 一般定义为final check()为钩子 让子类去选择怎样执行

    protected final void doSomething() {
        if(check()) {
            this.check1();
            return;
        }
        this.check2();
    }
}
