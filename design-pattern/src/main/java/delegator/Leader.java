package delegator;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {


    private Map<String, IEmployee> map = new HashMap<>();

    public Leader() {
        map.put("aaaa", new ConEmployeeA());
        map.put("bbbb", new ConEmployeeB());
    }

    //策略很像。但是委派更注重层级
    //策略更注重  平级之间的选择

    @Override
    public void doSomething(String task) {
        if (!map.containsKey(task)) {
            System.out.println("执行不了，leader无权限");
            return;
        }
        map.get(task).doSomething(task);
    }
}
