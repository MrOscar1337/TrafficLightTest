public class VehicleLight extends TrafficLight{
    public VehicleLight(int id, CrossroadController controller) {
        super(id, controller);
    }
    @Override
    public void processEvent(Event event) {
        if (event.getType().equals("QUEUE_UPDATE")) {
            // Обновляем информацию о количестве машин
            setQueueSize(event.getQueueSize());
            // Логика изменения состояния
            if (queueSize > 5 && state.equals("RED")) {
                setState("GREEN");
            } else if (queueSize == 0 && state.equals("GREEN")) {
                setState("RED");
            }
        }
    }
}
