package decorator;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class Phone2 extends AbstractPhone {

    public Phone2(IPhone phone) {
        super(phone);
    }

    @Override
    public void picture() {
        phone.picture();
        System.out.println("滤镜");
    }
}
