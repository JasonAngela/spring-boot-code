package vistor;

import lombok.Data;

import java.util.Random;

/**
 * @author huql
 **/
@Data
public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    protected void accept(IVistor vistor) {
        vistor.visit(this);
    }

    /**
     * 访问产品，关注在 产品个数上
     * @return
     */
    public Integer getProducts() {
        return new Random().nextInt(10);
    }
}
