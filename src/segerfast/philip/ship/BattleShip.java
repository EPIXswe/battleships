package segerfast.philip.ship;

import java.util.function.Supplier;

public class BattleShip extends AbstractShip {

    public BattleShip() {
        super(ShipType.BATTLESHIP);
    }

    @Override
    Supplier<ShipFragment> getFragmentSupplier() {
        return () -> new ShipFragment(this);
    }
}
