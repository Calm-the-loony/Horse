import java.util.ArrayList;
import java.util.List;

class CleaningStaff extends Employee {
    public CleaningStaff(String name, int employeeID) {
        super(name, employeeID);
    }

    public void cleanStables() {
        System.out.println(getName() + " чистит стойло Николая Сидина.");
        System.out.println("Стойло очищено.");
    }
}
