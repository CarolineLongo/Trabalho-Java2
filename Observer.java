// Observer, exemplificado com uma turma de 5 alunos que fazem parte de um sistema que quando lançam algum tipo de informação todos são notificados.

import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(String message);
}

// Classe Aluno (Observer)
class Aluno implements Observer {
    private String name;

    public Aluno(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a seguinte mensagem: " + message);
    }
}

// Classe Disciplina (Subject)
class StudentClass {
    private List<Observer> alunos = new ArrayList<>();

    public void registerAluno(Observer aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Observer aluno) {
        alunos.remove(aluno);
    }

    public void notifyAlunos(String message) {
        for (Observer aluno : alunos) {
            aluno.update(message);
        }
    }

    public void newInformation(String message) {
        System.out.println("Nova informação: " + message);
        notifyAlunos(message);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StudentClass disciplina = new StudentClass();

        Aluno aluno1 = new Aluno("Alice");
        Aluno aluno2 = new Aluno("Bob");
        Aluno aluno3 = new Aluno("Charlie");
        Aluno aluno4 = new Aluno("David");
        Aluno aluno5 = new Aluno("Eve");

        disciplina.registerAluno(aluno1);
        disciplina.registerAluno(aluno2);
        disciplina.registerAluno(aluno3);
        disciplina.registerAluno(aluno4);
        disciplina.registerAluno(aluno5);

        disciplina.newInformation("A aula foi cancelada.");

        disciplina.removeAluno(aluno3);

        disciplina.newInformation("A prova foi adiada para a próxima semana.");
    }
}
