package vistor;

import lombok.Data;

import java.util.Random;

/**
 * @author huql
 **/
@Data
public abstract class Employee {

    private String name;

    private Integer kpi;

    public Employee(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    protected abstract void accept(IVistor vistor);
}
