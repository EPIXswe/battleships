package segerfast.philip.ship;

import java.util.function.Supplier;

public class PatrolBoat extends AbstractShip {


    public PatrolBoat() {
        super(ShipType.PATROL_BOAT);
    }

    @Override
    Supplier<ShipFragment> getFragmentSupplier() {
        return () -> new ShipFragment(this);
    }

}
