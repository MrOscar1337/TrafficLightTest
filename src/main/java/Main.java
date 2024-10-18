public class Main {
    public static void main(String[] args) throws InterruptedException {
        CrossroadController controller = new CrossroadController();

        // Добавляем автомобильные светофоры
        for (int i = 1; i <= 4; i++) {
            VehicleLight vehicleLight = new VehicleLight(i, controller);
            controller.addTrafficLight(vehicleLight);
        }

        // Добавляем пешеходные светофоры
        for (int i = 5; i <= 12; i++) {
            PedestrianLight pedestrianLight = new PedestrianLight(i, controller);
            controller.addTrafficLight(pedestrianLight);
        }

        // Симулируем работу перекрестка
        while (true) {
            controller.simulateCrossroad();
            Thread.sleep(5000); // каждые 5 секунд обновляем ситуацию
        }
    }
}
