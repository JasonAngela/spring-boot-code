package vistor;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class CEOVistor implements IVistor {


    @Override
    public void visit(Manager manager) {
        System.out.println("CEO:-----" + manager.getProducts());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println(engineer.getName() + ":" + engineer.getKpi());
    }
}
