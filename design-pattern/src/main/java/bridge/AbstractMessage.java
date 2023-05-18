package bridge;

/**
 * 类描述：抽象类 可以维护句柄
 *
 * 实现过程中 句柄会被实例化成具体类
 *
 * @author huql
 **/
public abstract class AbstractMessage {
    IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    public void sendMessage(String message, String user) {
        this.message.send(message, user);
    }
}
