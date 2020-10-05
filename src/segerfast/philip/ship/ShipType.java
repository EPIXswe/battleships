package segerfast.philip.ship;

public enum ShipType {
    CARRIER("Carrier", 5),
    BATTLESHIP("Battleship", 4),
    DESTROYER("Destroyer", 3),
    SUBMARINE("Submarine", 3),
    PATROL_BOAT("Patrol boat", 2);

    private String name;
    private int size;

    private ShipType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
}
