package delegator;

/**
 * @author hql
 */
public class ConEmployeeA implements IEmployee {

    @Override
    public void doSomething(String task) {
        System.out.println("A----Task----");
    }
}
