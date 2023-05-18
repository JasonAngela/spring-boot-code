package decorator;

/**
 * @author huql
 **/
public class Client {

    public static void main(String[] args) {
        //AbstractPhone phone = new Phone2(new A);
        IPhone phone2 = new Phone2(new Phone1());
        phone2.picture();

    }
}
