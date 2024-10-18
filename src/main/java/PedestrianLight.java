public class PedestrianLight extends TrafficLight{
    public PedestrianLight(int id, CrossroadController controller) {
        super(id, controller);
    }

    @Override
    public void processEvent(Event event) {
        if (event.getType().equals("QUEUE_UPDATE")) {
            // Обновляем информацию о количестве пешеходов
            setQueueSize(event.getQueueSize());
            // Логика изменения состояния
            if (queueSize > 3 && state.equals("RED")) {
                setState("GREEN");
            } else if (queueSize == 0 && state.equals("GREEN")) {
                setState("RED");
            }
        }
    }
}
