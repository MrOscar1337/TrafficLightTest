import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

abstract class TrafficLight {
    protected int id;
    protected String state;
    protected BlockingQueue<Event> eventQueue;
    protected CrossroadController controller;
    protected int queueSize;

    public TrafficLight(int id, CrossroadController controller) {
        this.id = id;
        this.state = "RED"; // изначально все светофоры красные
        this.eventQueue = new LinkedBlockingQueue<>();
        this.controller = controller;
        this.queueSize = 0;
    }

    public abstract void processEvent(Event event);

    public void sendEvent(Event event) {
        controller.dispatchEvent(event);
    }

    public void receiveEvent(Event event) {
        try {
            eventQueue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setQueueSize(int size) {
        this.queueSize = size;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("TrafficLight " + id + " changed to " + state);
    }
}
