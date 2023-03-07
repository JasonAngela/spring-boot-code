package delegator;

public class Boss {

    public void command(String task, Leader leader) {
        leader.doSomething(task);
    }
}
