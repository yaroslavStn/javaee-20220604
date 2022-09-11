package AppSpring.menu;

public abstract class Item {

    private final String name;
    private final boolean exit;

    public Item(String name) {
        this.name = name;
        this.exit = false;
    }

    public Item(String name, boolean exit) {
        this.name = name;
        this.exit = exit;
    }

    public String getName() {
        return name;
    }

    public boolean isExit() {
        return exit;
    }


    public abstract void exec();

}
