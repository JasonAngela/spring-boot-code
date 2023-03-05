package vistor;

/**
 * @author huql
 **/
public class CTOVistor implements IVistor {


    @Override
    public void visit(Manager manager) {
        System.out.println("CTO:-----" + manager.getProducts());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("CTO:-----" + engineer.getCodeLines());
    }
}
