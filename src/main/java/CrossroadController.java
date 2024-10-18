import java.util.*;
import java.util.concurrent.*;

public class CrossroadController {
    private List<TrafficLight> trafficLights;
    private ExecutorService executor;

    public CrossroadController() {
        trafficLights = new ArrayList<>();
        executor = Executors.newCachedThreadPool();
    }

    public void addTrafficLight(TrafficLight trafficLight) {
        trafficLights.add(trafficLight);
        executor.submit(() -> {
            while (true) {
                // Обработка очереди событий
                try {
                    Event event = trafficLight.eventQueue.take();
                    trafficLight.processEvent(event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void dispatchEvent(Event event) {
        // Отправляем событие на обработку всем светофорам
        for (TrafficLight light : trafficLights) {
            if (light.id != event.getSenderId()) {
                light.receiveEvent(event);
            }
        }
    }

    public void simulateCrossroad() {
        // Пример симуляции изменения очередей
        Random random = new Random();
        for (TrafficLight light : trafficLights) {
            // Случайное обновление состояния очереди
            int queueSize = random.nextInt(10);
            light.sendEvent(new Event(light.id, "QUEUE_UPDATE", queueSize));
        }
    }
}
