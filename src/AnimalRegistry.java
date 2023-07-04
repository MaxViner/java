import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.printCommands();
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void teachCommand(String name, String newCommand) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.setCommand(newCommand);
                System.out.println("Животное " + name + " успешно обучено новой команде: " + newCommand);
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void navigateMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=== Реестр домашних животных ===");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Определить животное в правильный класс");
            System.out.println("3. Увидеть список команд, которое выполняет животное");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    determineAnimalClass();
                    break;
                case 3:
                    showAnimalCommands();
                    break;
                case 4:
                    teachAnimalCommand();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 0);
    }

    private void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя нового животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите команду нового животного: ");
        String command = scanner.nextLine(


);

        Animal animal = new Animal(name, command);
        addAnimal(animal);

        try (Counter counter = new Counter()) {
            System.out.println("Животное успешно добавлено в реестр.");
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении животного в реестр: " + e.getMessage());
        }
    }

    private void determineAnimalClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        // Определение класса животного на основе его имени
        Animal animal;
        if (name.equalsIgnoreCase("собака")) {
            animal = new Dog(name, "вуф");
        } else if (name.equalsIgnoreCase("Том")) {
            animal = new Cat(name, "мяф");
        } else if (name.equalsIgnoreCase("хомяк")) {
            animal = new Hamster(name, "втф");
        } else {
            System.out.println("Не удалось определить класс животного.");
            return;
        }

        addAnimal(animal);
        System.out.println("Животное " + name + " успешно определено в правильный класс.");
    }

    private void showAnimalCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        showCommands(name);
    }

    private void teachAnimalCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новую команду для животного: ");
        String newCommand = scanner.nextLine();

        teachCommand(name, newCommand);
    }

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.navigateMenu();
    }
}