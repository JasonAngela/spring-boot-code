package com.qilang.test.common;

import com.qilang.test.ql.OperatorNotIn;
import com.ql.util.express.ExpressRunner;

/**
 * 类描述: ql Express Runner Util
 *
 * @author huql
 **/
public class ExpressRunnerUtil {

    private ExpressRunnerUtil() {}

    private static ExpressRunner expressRunner;

    static {
        expressRunner = new ExpressRunner();
        try {
            //expressRunner.addOperator("not in", new OperatorNotIn("not in"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ExpressRunner getExpressRunner() {
        return expressRunner;
    }
}
