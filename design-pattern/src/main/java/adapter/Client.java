package adapter;

public class Client {
    public static void main(String[] args) {
        //适配器一般都是后置的
        //系统存在某些设计 （类）后 需要用到相关数据 但并不完全满足
        //后置使用适配器功能去适配
        //总结就是 原始数据结构有用 但不完全有用 需要通过适配器模式 去做一个适配！

        Adapter adapter = new Adapter(new Adaptee());
        adapter.v220();
    }
}
