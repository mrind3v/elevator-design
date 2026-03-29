public class InternalPanel {
    // Internal Panel specific to a Lift is fixed - so final
    private final ElevatorCar car;

    InternalPanel(ElevatorCar car) {
        this.car = car;
    }

    void pressButton(int floor) {
        car.addDestination(floor);
    }
}
