import java.util.ArrayList;
import java.util.List;

class HorseRidingCompetition {
    private String competitionName;
    private List<Horse> participants;

    public HorseRidingCompetition(String competitionName) {
        this.competitionName = competitionName;
        participants = new ArrayList<>();
    }

    public void addParticipant(Horse horse) {
        participants.add(horse);
    }

    public void conductCompetition() {
        System.out.println("Проводятся соревнования по верховой езде по " + competitionName);
        for (Horse participant : participants) {
            participant.ride();
        }
    }
}