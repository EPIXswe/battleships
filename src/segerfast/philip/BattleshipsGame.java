package segerfast.philip;

import segerfast.philip.grid.BattleGrid;


public class BattleshipsGame {

    // Mer info
    // https://en.wikipedia.org/wiki/Battleship_(game)

    private final BattleGrid playerKnownGrid = new BattleGrid("Player known grid");
//    private BattleGrid enemyUnknownGrid = new BattleGrid("Enemy unknown grid");
//
//    private BattleGrid enemyKnownGrid = new BattleGrid("Enemy known grid");
//    private BattleGrid playerUnknownGrid = new BattleGrid("Player unknown grid");

    public BattleshipsGame() {
    }

    public void start() {
        Utils.printColoredLine("Starting game!", GameColor.BLUE);

        playerKnownGrid.placeShipsRandom();
        // enemyKnownGrid.generateShips();

        // playerKnownGrid.printGrid();

        // SPELARENS TUR
        // 1. Visa dolda fiendeplan
        // 2. Välj ruta att attackera
        // 3. Visa på fiendeplan om träff/miss

        // MOTSTÅNDARENS TUR
        // 1. Visa spelarens dolda plan
        // 2. Låt datorn skjuta
        // 3. Visa på spelarens dolda plan om det var en träff eller miss
    }



}














