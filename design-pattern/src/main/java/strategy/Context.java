package strategy;

import java.util.HashMap;
import java.util.Map;

public class Context {
    //上下文  聚合所有策略类
    private static final Map<String, IStrategy> map = new HashMap<>();

    static {
        map.put("a", new ConStrategyA());
        map.put("b", new ConStrategyB());
    }

    public static IStrategy get(String key) {
        return map.get(key);
    }
}
