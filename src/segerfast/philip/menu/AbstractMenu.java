package segerfast.philip.menu;

import segerfast.philip.GameColor;
import segerfast.philip.utils.SoundUtils;
import segerfast.philip.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu {

    protected String menuLabel;
    protected List<MenuItem> menuItems = new ArrayList<>();
    protected static final MenuItem backMenuItem = new MenuItem("Go back", () -> {
        System.out.println("Going back...");
    });

    public AbstractMenu(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public void open() {

        SoundUtils.playGameMenuMusic();

        boolean shouldLoop = true;
        while(shouldLoop) {

            MenuItem selectedItem = getMenuInput();
            selectedItem.execute();

            if(selectedItem == backMenuItem)
                shouldLoop = false;
        }
    }

    private MenuItem getMenuInput() {
        Utils.printLineSeparator();

        // Printing menu
        for(int i = 1; i < menuItems.size()+1; i++) {
            System.out.printf("%s[%s%d%s]\t%s%s%s%n", GameColor.BLACK, GameColor.YELLOW, i, GameColor.BLACK, GameColor.BRIGHT_GREEN, menuItems.get(i-1).getLabel(), GameColor.RESET);
        }

        int input = Utils.getIntInput();

        return menuItems.get(input-1);
    }

}
