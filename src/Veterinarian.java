import java.util.ArrayList;
import java.util.List;

class Veterinarian extends Employee {
    public Veterinarian(String name, int employeeID) {
        super(name, employeeID);
    }

    public void performHealthCheck(Animal animal) {
        System.out.println(super.getName() + " осматривает " + animal.getName() + ".");

    }
    public void performHealthCheck1(Animal animal) {
        System.out.println("Все здоровы");
    }

    public void healAHorse(Animal animal) {
        System.out.println(super.getName() + " лечит " + animal.getName() + ".");
    }
}



