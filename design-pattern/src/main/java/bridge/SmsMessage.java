package bridge;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class SmsMessage implements IMessage {

    @Override
    public void send(String message, String user) {
        System.out.println("发送短信:" + message + " 给:" + user);
    }
}
