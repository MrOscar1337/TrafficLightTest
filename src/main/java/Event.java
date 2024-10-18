
public class Event {
    private int senderId;
    private String type;
    private int queueSize;

    public Event(int senderId, String type, int queueSize) {
        this.senderId = senderId;
        this.type = type;
        this.queueSize = queueSize;
    }

    public int getSenderId() {
        return senderId;
    }

    public String getType() {
        return type;
    }

    public int getQueueSize() {
        return queueSize;
    }
}

