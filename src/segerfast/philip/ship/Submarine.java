package segerfast.philip.ship;

import java.util.function.Supplier;

public class Submarine extends AbstractShip {


    public Submarine() {
        super(ShipType.SUBMARINE);
    }

    @Override
    Supplier<ShipFragment> getFragmentSupplier() {
        return () -> new ShipFragment(this);
    }

}
