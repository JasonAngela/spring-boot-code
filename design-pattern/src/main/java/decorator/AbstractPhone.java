package decorator;

/**
 * @author huql
 **/
public abstract class AbstractPhone implements IPhone {

    protected IPhone phone;

    public AbstractPhone(IPhone phone) {
        this.phone = phone;
    }
}