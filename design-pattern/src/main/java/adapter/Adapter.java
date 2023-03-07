package adapter;

/**
 * @author hql
 */
public class Adapter  implements ITarget {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void v220() {
        System.out.println(this.adaptee.v5() * 44); ;
    }
}
