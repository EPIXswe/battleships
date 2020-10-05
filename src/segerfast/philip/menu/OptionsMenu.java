package segerfast.philip.menu;

public final class OptionsMenu extends AbstractMenu {

    private static OptionsMenu instance = new OptionsMenu();

    private OptionsMenu() {
        super("Options");

        MenuItem options1 = new MenuItem("Option 1", () -> System.out.println("Executing option 1..."));
        MenuItem options2 = new MenuItem("Option 2", () -> System.out.println("Executing option 2..."));
        MenuItem options3 = new MenuItem("Option 3", () -> System.out.println("Executing option 3..."));
        MenuItem options4 = new MenuItem("Option 4", () -> System.out.println("Executing option 4..."));
        MenuItem options5 = new MenuItem("Option 5", () -> System.out.println("Executing option 5..."));
        MenuItem options6 = new MenuItem("Option 6", () -> System.out.println("Executing option 6..."));

        menuItems.add(options1);
        menuItems.add(options2);
        menuItems.add(options3);
        menuItems.add(options4);
        menuItems.add(options5);
        menuItems.add(options6);
        menuItems.add(backMenuItem);
    }

    public static OptionsMenu getInstance() {
        return instance;
    }

}
