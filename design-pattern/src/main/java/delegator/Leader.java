package delegator;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    
    private Map<String, IEmployee> map = new HashMap<>();

    public Leader() {
        map.put("aaaa", new ConEmployeeA());
        map.put("bbbb", new ConEmployeeB());
    }

    @Override
    public void doSomething(String task) {

    }
}
