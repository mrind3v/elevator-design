public class Floor {
    // each floor has a unique floor number - doesn't change
    private final int floor;
    // Each floor has only one external panel
    private final ExternalPanel externalPanel;

    Floor(int floor, ExternalPanel externalPanel) {
        this.floor = floor;
        this.externalPanel = externalPanel;
    }

    public int getFloor() {
        return floor;
    }

    public ExternalPanel getExternalPanel() {
        return externalPanel;
    }
}
