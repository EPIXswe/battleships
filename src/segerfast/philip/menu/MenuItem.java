package segerfast.philip.menu;

public final class MenuItem {

    private final String label;
    private final Runnable codeToExecute;

    public MenuItem(String label, Runnable codeToExecute) {
        this.label = label;
        this.codeToExecute = codeToExecute;
    }

    public String getLabel() {
        return label;
    }

    public void execute() {
        codeToExecute.run();
    }

    @Override
    public String toString() {
        return label;
    }
}
