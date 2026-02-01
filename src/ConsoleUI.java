import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private TaskManager manager;


    public ConsoleUI() {
        manager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            int n = 0;
            System.out.println(showMenu());
            n = readInt();
            switch (n) {
                case 0:
                    return;
                case 1:
                    List<Task> tasks;
                    tasks = manager.getAllTasks();
                    if(tasks.isEmpty()){
                        System.out.println("Список задач пуст.");
                    }
                    else {
                        for (Task task : tasks) {
                            System.out.println(task.toDisplayString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите описание задачи: ");
                    String description;
                    description = scanner.nextLine();
                    if(!description.isEmpty()){
                        manager.addTask(description);
                    }
                    else{
                        System.out.println("Добавьте описание задачи.");
                    }
                    break;
                case 3:
                    System.out.println("Введите id задачи: ");
                    int id = readInt();
                    if(id>0){
                        manager.completeTask(id);
                    }
                    else{
                        System.out.println("Введите корректное id задачи.");
                    }
                    break;
                default:
                    System.out.println("Ошибка ввода. Введите повторно.");
            }
        }
    }

    private String showMenu() {
        return """
        Добро пожаловать в Менеджер задач.
        1. Показать все задачи
        2. Добавить задачу
        3. Отметить задачу как выполненную
        0. Выход
        Ваш выбор: """;
    }

    private int readInt(){
        while(true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }
    }

}
