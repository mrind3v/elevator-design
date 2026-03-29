import java.util.List;

// implementations of this interface will contain strategies/algorithms that will bring one of the elevator car
// when a user calls for a lift at a particular floor
public interface SelectionStrategy {
    // assign an elevatorCar out of all available ones at a particular floor (where user called it) in the direction dir
    ElevatorCar assignElevator(List<ElevatorCar> cars, int floor, Direction dir);
}
