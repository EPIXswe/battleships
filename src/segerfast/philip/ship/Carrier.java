package segerfast.philip.ship;

import java.util.List;
import java.util.function.Supplier;

public class Carrier extends AbstractShip {

    public Carrier() {
        super(ShipType.CARRIER);
    }

    @Override
    Supplier<ShipFragment> getFragmentSupplier() {
        return () -> new ShipFragment(this);
    }
}
