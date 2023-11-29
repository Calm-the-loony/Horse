import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Жила-была одна конюшня, на ней обитали 3 лошадки и 5 людишек. Сейчас мы узнаем, чем же они там занимались.");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        // новая конюшея
        Stable stable = new Stable();

        Horse horse1 = new Horse("Коля", 18);
        Horse horse2 = new Horse("Звездочка", 6);
        Horse horse3 = new Horse("Мира", 8);
        stable.addHorse(horse1);
        stable.addHorse(horse2);
        stable.addHorse(horse3);

        Employee employee1 = new Employee("Уборщик", 1);
        Employee employee2 = new Employee("Жокей", 2);
        Employee employee3 = new Employee("Штатный сотрудник", 3);
        stable.addEmployee(employee1);
        stable.addEmployee(employee2);
        stable.addEmployee(employee3);

        Veterinarian veterinarian = new Veterinarian("Ветеринар Михаил", 4);

        // Выполнение медицинского осмотра
        veterinarian.performHealthCheck(horse1);
        veterinarian.performHealthCheck(horse2);
        veterinarian.performHealthCheck(horse3);
        veterinarian.performHealthCheck1(horse3);

        System.out.println("------------------------------------------------------------------------------------------------------------");
        // Создание соревнования по верховой езде
        HorseRidingCompetition competition = new HorseRidingCompetition("конкуру");

        // Регистрация лошадей на соревновании
        competition.addParticipant(horse1);
        competition.addParticipant(horse2);

        // сами соревнования
        competition.conductCompetition();
        System.out.println("------------------------------------------------------------------------------------------------------------");

        CleaningStaff cleaner = new CleaningStaff("Уборщик Диана Евгеньевна", 5);

        cleaner.cleanStables();
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println("Сотрудники в конюшне по мимо ветеринара:");
        for (Employee employee : stable.getEmployees()) {
            System.out.println("Имя: " + employee.getName() + ", ID: " + employee.getEmployeeID());
        }

        employee1.cleanStalls();
        employee2.feedHorses();
        employee3.maintainEquipment();

        System.out.println("\nЛошади в конюшне:");
        for (Animal horse : stable.getHorses()) {
            System.out.println("Имя: " + horse.getName() + ", Возраст: " + horse.getAge());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Еще на конюшне живет собачка, но она в отпуске и не может вывестись в консоль. Как приедет, так и добавлю ее))");
    }

}
