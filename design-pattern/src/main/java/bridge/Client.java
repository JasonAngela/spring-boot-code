package bridge;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class Client {
    public static void main(String[] args) {
        SmsMessage message = new SmsMessage();
        NormalSmsMessage normalSmsMessage = new NormalSmsMessage(message);
        normalSmsMessage.sendMessage("短信","王总");

        QuickSmsMessage quickSmsMessage = new QuickSmsMessage(message);
        quickSmsMessage.sendMessage("短信", "李总");

    }
}
