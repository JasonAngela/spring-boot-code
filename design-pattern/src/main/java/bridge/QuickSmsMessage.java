package bridge;

/**
 * @author huql
 **/
public class QuickSmsMessage extends AbstractMessage {

    public QuickSmsMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String user) {
        message = "加快" + message;
        super.sendMessage(message, user);
    }
}
