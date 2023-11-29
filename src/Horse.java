import java.util.ArrayList;
import java.util.List;

class Horse extends Animal implements Riding {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Лошадь " + getName() + " издает звук иго-го-го.");
    }

    @Override
    public void ride() {
        System.out.println("Лошадь " + getName() + " идет на прогулку.");
    }

    @Override
    public void gallop() {
        System.out.println("Лошадь " + getName() + " галопирует.");
    }

    @Override
    public void performDressage() {
        System.out.println("Лошадь " + getName() + " выполняет дрессировку.");
    }

    @Override
    public void jumpOverObstacle() {
        System.out.println("Лошадь " + getName() + " прыгает через препятствие.");
    }

    @Override
    public void callVeterinarian(Veterinarian veterinarian) {
        veterinarian.performHealthCheck(this);
    }

    @Override
    public void participateInCompetition(HorseRidingCompetition competition) {
        competition.addParticipant(this);
    }

    public void goForAWalk() {
        System.out.println("Лошадь " + getName() + " выходит на прогулку.");
    }

    public void goOnTrail(Horse companion) {
        System.out.println("Лошади " + getName() + " и " + companion.getName() + " отправляются в поход.");
    }

}
