package vistor;

import lombok.Data;
import java.util.Random;

/**
 * @author huql
 **/
@Data
public class Engineer extends Employee {


    public Engineer(String name) {
        super(name);
    }

    @Override
    protected void accept(IVistor vistor) {
        vistor.visit(this);
    }

    /**
     * 访问 工程师关注点在 代码行数
     * @return Integer
     */
    public Integer getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
