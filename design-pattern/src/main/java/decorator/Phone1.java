package decorator;

/**
 * @author huql
 **/
public class Phone1 implements IPhone {


    @Override
    public void picture() {
        System.out.println("拍照功能");
    }
}
