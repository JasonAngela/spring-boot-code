package com.qilang.test.common;

import com.ql.util.express.ExpressRunner;

/**
 * 类描述: ql Express Runner Util
 *
 * @author huql
 **/
public class ExpressRunnerUtil {

    private static ExpressRunner expressRunner;

    static {
        expressRunner = new ExpressRunner();
    }

    public static ExpressRunner getExpressRunner() {
        return expressRunner;
    }
}
