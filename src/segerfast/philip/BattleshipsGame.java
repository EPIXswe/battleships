package segerfast.philip;

import segerfast.philip.grid.BattleGrid;
import segerfast.philip.utils.SelectionPrompt;
import segerfast.philip.utils.Utils;


public class BattleshipsGame {

    // Mer info
    // https://en.wikipedia.org/wiki/Battleship_(game)

    private final BattleGrid playerKnownGrid = new BattleGrid("Player known grid");
//    private BattleGrid enemyUnknownGrid = new BattleGrid("Enemy unknown grid");
//
    private BattleGrid enemyKnownGrid = new BattleGrid("Enemy known grid");
//    private BattleGrid playerUnknownGrid = new BattleGrid("Player unknown grid");

    public BattleshipsGame() {
    }

    public void start() {
        initNewGame();



    }

    /**
     * Places ships on the fields.
     */
    private void initNewGame() {

        String promptText = "Would you like to place the ships at random or manually?";
        SelectionPrompt<Integer> placeShipsRandomOrManually = new SelectionPrompt<>(promptText);
        placeShipsRandomOrManually.add(1, "At random");
        placeShipsRandomOrManually.add(2, "Manually");
        int result = placeShipsRandomOrManually.prompt();

        if(result == 1) {
            System.out.println("At random");
        } else if(result == 2) {
            System.out.println("Manually");
        }

        playerKnownGrid.placeShipsRandom();
        enemyKnownGrid.placeShipsRandom();

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














