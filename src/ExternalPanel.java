public class ExternalPanel {
    // Both fields are final because once you make an ExternalPanel for a floor, you are not going to break and fit it into some other floor
    // For the ElevatorSystem, you only need one object of it that is common for the whole application - it's the brain
    private final int floor;
    private final ElevatorSystem elevatorSystem;
    ExternalPanel(int floor, ElevatorSystem elevatorSystem) {
        this.floor = floor;
        this.elevatorSystem = elevatorSystem;
    }
    public void pressButton(Direction direction) {
        elevatorSystem.handleExternalRequest(this.floor,direction);
    }
}
