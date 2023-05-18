package bridge;

/**
 * @author huql
 **/
public class NormalSmsMessage extends AbstractMessage {

    public NormalSmsMessage(IMessage message) {
        super(message);
    }


    @Override
    public void sendMessage(String message, String user) {
        message = "普通" + message;
        super.sendMessage(message, user);
    }
}
