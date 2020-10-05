package segerfast.philip.ship;

import segerfast.philip.grid.CellContent;

public class ShipFragment implements CellContent {

    public enum Status {
        UNTOUCHED,
        DESTROYED
    }

    private Status status;
    private final AbstractShip parentShip;
    private final String label;

    public ShipFragment(AbstractShip parentShip) {
        this.parentShip = parentShip;
        status = Status.UNTOUCHED;
        label = parentShip.getType().getName() + " fragment";
    }

    public Status getStatus() {
        return status;
    }

    public void destroy() {
        status = Status.DESTROYED;
    }

    public AbstractShip getParentShip() {
        return parentShip;
    }

    @Override
    public String getSymbol() {
        return label.substring(0, 1);
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
