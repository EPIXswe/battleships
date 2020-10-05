package segerfast.philip.ship;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractShip {

    public final List<ShipFragment> shipFragments = new ArrayList<>();
    public boolean isDestroyed;
    private ShipType type;

    public AbstractShip(ShipType type) {
        this.type = type;
        isDestroyed = false;
        initShipFragments();
    }

    private void initShipFragments() {
        Supplier<ShipFragment> supplier = getFragmentSupplier();

        for(int i = 0; i < getType().getSize(); i++) {
            shipFragments.add(supplier.get());
        }
    }

    /**
     * This method is used to retrieve instances of ShipFragments that are
     * gonna populate
     * @return a supplier that returns a ship fragment.
     */
    abstract Supplier<ShipFragment> getFragmentSupplier();

    public ShipType getType() {
        return type;
    }
}
