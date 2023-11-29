import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void cleanStalls() {
        System.out.println(name + " выполняет уборку стойл.");
    }

    public void feedHorses() {
        System.out.println(name + " занимается кормлением лошадей и их тренировкой.");
    }

    public void maintainEquipment() {
        System.out.println(name + " обслуживает и поддерживает оборудование в конюшне.");
    }
}