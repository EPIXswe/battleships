package segerfast.philip.grid;

import segerfast.philip.GameColor;

public interface CellContent {

    /**
     * A cell that doesn't contain a ship fragment.
     */
    public static final CellContent WATER = () -> String.format("%s~%s", GameColor.BRIGHT_BLUE, GameColor.RESET);
    /**
     * For debugging purposes.
     */
    public static final CellContent ROCK = () -> String.format("%so", GameColor.GRAY);

    String getSymbol();

}
