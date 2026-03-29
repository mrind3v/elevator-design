import java.util.*;

public class ElevatorCar {
    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private Status status = Status.ACTIVE;
    private double currentWeight = 0;
    private final double maxWeight;
    private List<FloorObserver> observers = new ArrayList<>();
    private Queue<Integer> destinationQueue = new LinkedList<>();

    public ElevatorCar(int id, double maxWeight) {
        this.id = id;
        this.maxWeight = maxWeight;
    }

    public void addObserver(FloorObserver obs) { observers.add(obs); }

    public void addDestination(int floor) {
        if (status == Status.MAINTENANCE) return;
        destinationQueue.add(floor);
    }

    public void move() {
        if (currentWeight > maxWeight || status == Status.MAINTENANCE || destinationQueue.isEmpty()) {
            return;
        }

        // Logic to move one floor at a time toward the next destination
        int nextFloor = destinationQueue.peek();
        if (nextFloor > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (nextFloor < currentFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        }

        if (currentFloor == nextFloor) {
            destinationQueue.poll();
            if (destinationQueue.isEmpty()) direction = Direction.IDLE;
        }

        notifyObservers();
    }

    private void notifyObservers() {
        for (FloorObserver obs : observers) {
            obs.onFloorChange(currentFloor, id);
        }
    }

    public void setWeight(double weight) { this.currentWeight = weight; }
    public void setStatus(Status status) { this.status = status; }
    public int getCurrentFloor() { return currentFloor; }
    public Status getStatus() { return status; }
}