package segerfast.philip.ship;

import java.util.function.Supplier;

public class Destroyer extends AbstractShip {

    public Destroyer() {
        super(ShipType.DESTROYER);
    }

    @Override
    Supplier<ShipFragment> getFragmentSupplier() {
        return () -> new ShipFragment(this);
    }
}
