package segerfast.philip.menu;

import segerfast.philip.BattleshipsGame;
import segerfast.philip.GameColor;
import segerfast.philip.SoundUtils;
import segerfast.philip.Utils;

public final class GameMenu extends AbstractMenu {

    private static GameMenu instance = new GameMenu();

    private GameMenu() {

        super("Game Menu");

        MenuItem startGame =    new MenuItem("Start game",      () -> {
            SoundUtils.stopGameMenuMusic();
            new BattleshipsGame().start();
            SoundUtils.playGameMenuMusic();
        });
        MenuItem options =      new MenuItem("Options",         () -> OptionsMenu.getInstance().open());
        MenuItem about =        new MenuItem("About this game", () -> {
            Utils.printColoredLine( "This game is written in Java by Philip Segerfast as a school project \n" +
                    "as a way to practice on his coding skills!", GameColor.INFO); });
        MenuItem exit =         new MenuItem("Exit game", () -> {
            System.out.println("Exiting game...");
            System.exit(0);
        });

        menuItems.add(startGame);
        menuItems.add(options);
        menuItems.add(about);
        menuItems.add(exit);

    }

    public static GameMenu getInstance() {
        return instance;
    }

}
























