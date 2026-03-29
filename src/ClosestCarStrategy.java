import java.util.List;

// Example algorithm: Picks the closest active car
public class ClosestCarStrategy implements SelectionStrategy {
    @Override
    public ElevatorCar assignElevator(List<ElevatorCar> cars, int floor, Direction dir) {
        ElevatorCar bestCar = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar car : cars) {
            if (car.getStatus() == Status.ACTIVE) {
                int distance = Math.abs(car.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestCar = car;
                }
            }
        }
        return bestCar;
    }
}
