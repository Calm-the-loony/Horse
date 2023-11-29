import java.util.ArrayList;
import java.util.List;

class Stable {
    private List<Animal> horses;
    private List<Employee> employees;

    public Stable() {
        horses = new ArrayList<>();
        employees = new ArrayList<>();
    }
    //добавление лошади
    public void addHorse(Animal horse) {
        horses.add(horse);
    }
    //добавление сотрудника
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    //возвращает список лошадей
    public List<Animal> getHorses() {
        return horses;
    }
    //возвращает список людей
    public List<Employee> getEmployees() {
        return employees;
    }
}
