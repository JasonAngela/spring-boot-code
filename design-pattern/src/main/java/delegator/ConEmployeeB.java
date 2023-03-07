package delegator;

public class ConEmployeeB implements IEmployee {

    @Override
    public void doSomething(String task) {
        System.out.println("---BBBBB------EMmployee");
    }
}
