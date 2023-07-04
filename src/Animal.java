
public class Animal {
    private String name;
    private String command;

    public Animal(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void printCommands() {
        System.out.println("Животное " + name + " выполняет команду: " + command);
    }
}










