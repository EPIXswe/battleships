package segerfast.philip;

import segerfast.philip.grid.BattleGrid;

public abstract class AbstractPlayer {

    protected String playerName;
    protected BattleGrid knownGrid;
    protected BattleGrid unknownGrid;

    protected AbstractPlayer(String playerName) {
        this.playerName = playerName;
        knownGrid = new BattleGrid(String.format("%s's Known Grid", playerName));
        unknownGrid = new BattleGrid(String.format("%s's Unknown Grid", playerName));
    }

}
