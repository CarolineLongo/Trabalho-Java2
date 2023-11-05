// Mediator, exemplo segue com uma equipe de 7 pessoas sendo 3 duplas e um Mediator (Líder), é ele que gerencia toda a comunicação entre a equipe.

import java.util.ArrayList;
import java.util.List;

// Interface Mediator
interface TeamMediator {
    void sendMessage(String message, TeamMember member);
}

// Classe Colega (TeamMember)
class TeamMember {
    private String name;
    private TeamMediator mediator;

    public TeamMember(String name, TeamMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(name + " recebeu a mensagem: " + message);
    }
}

// Classe Mediador Concreto (TeamLeader)
class TeamLeader implements TeamMediator {
    private List<TeamMember> members = new ArrayList<>();

    public void addMember(TeamMember member) {
        members.add(member);
    }

    public void sendMessage(String message, TeamMember member) {
        for (TeamMember teamMember : members) {
            if (teamMember != member) {
                teamMember.receive(message);
            }
        }
    }
}

public class MediatorExample {
    public static void main(String[] args) {
        TeamLeader mediator = new TeamLeader();

        TeamMember member1 = new TeamMember("Alice", mediator);
        TeamMember member2 = new TeamMember("Bob", mediator);
        TeamMember member3 = new TeamMember("Charlie", mediator);
        TeamMember member4 = new TeamMember("David", mediator);
        TeamMember member5 = new TeamMember("Eve", mediator);
        TeamMember member6 = new TeamMember("Frank", mediator);
        TeamMember member7 = new TeamMember("Grace", mediator);

        mediator.addMember(member1);
        mediator.addMember(member2);
        mediator.addMember(member3);
        mediator.addMember(member4);
        mediator.addMember(member5);
        mediator.addMember(member6);
        mediator.addMember(member7);

        member1.send("Olá, colegas!");
        member4.send("Vamos trabalhar juntos!");

        // Apenas duas das mensagens serão impressas, pois o mediador encaminha as mensagens para outros colegas.
    }
}