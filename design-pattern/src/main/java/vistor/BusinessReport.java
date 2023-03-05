package vistor;

import cn.hutool.core.io.resource.MultiResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huql
 **/
public class BusinessReport {


    private static List<Employee> list = new ArrayList<>();


    static {
        list.add(new Engineer("工程师1-"));
        list.add(new Engineer("工程师2-"));
        list.add(new Engineer("工程师3-"));
        list.add(new Engineer("管理者1-"));
        list.add(new Engineer("管理者2-"));
        list.add(new Engineer("管理者3-"));
    }


    public void showReport(IVistor vistor) {
        list.forEach(m -> {
            m.accept(vistor);
        });
    }
}
