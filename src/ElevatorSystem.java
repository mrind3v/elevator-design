import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<ElevatorCar> cars;
    private SelectionStrategy strategy;

    public ElevatorSystem(int numCars, int numFloors, SelectionStrategy strategy) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numCars; i++) {
            cars.add(new ElevatorCar(i, 1000.0)); // 1000kg limit
        }
        this.strategy = strategy;
    }

    public void handleExternalRequest(int floor, Direction dir) {
        ElevatorCar selectedCar = strategy.assignElevator(cars, floor, dir);
        if (selectedCar != null) {
            selectedCar.addDestination(floor);
        }
    }
}