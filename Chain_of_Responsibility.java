//Neste Exemplo temos uma requisição de lançamento de nota onde apenas o manipulador Professor é capaz de executar, 
//os demais manipuladores alunos e funcionários não o podem executar.
import java.util.EnumSet; 
// Definição da interface do manipulador
public interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(Request request);
}

// Implementação concreta do manipulador de alunos
public class AlunoHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getPermissionLevel() == PermissionLevel.ALUNO) {
            System.out.println("Aluno não tem permissão para lançar notas.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Implementação concreta do manipulador de funcionários
public class FuncionarioHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getPermissionLevel() == PermissionLevel.FUNCIONARIO) {
            System.out.println("Funcionário não tem permissão para lançar notas.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Implementação concreta do manipulador de professores
public class ProfessorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getPermissionLevel() == PermissionLevel.PROFESSOR) {
            System.out.println("Nota lançada pelo professor.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Nenhum manipulador pode lidar com a solicitação.");
        }
    }
}

// Níveis de permissão
public enum PermissionLevel {
    ALUNO, FUNCIONARIO, PROFESSOR
}

// Classe para representar a solicitação
public class Request {
    private PermissionLevel permissionLevel;

    public Request(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }
}

public class Main {
    public static void main(String[] args) {
        // Cria os manipuladores
        Handler alunoHandler = new AlunoHandler();
        Handler funcionarioHandler = new FuncionarioHandler();
        Handler professorHandler = new ProfessorHandler();

        // Configura a cadeia de manipuladores
        alunoHandler.setNextHandler(funcionarioHandler);
        funcionarioHandler.setNextHandler(professorHandler);

        // Cria uma solicitação de lançamento de nota para um professor
        Request request = new Request(PermissionLevel.PROFESSOR);
        // Envia a solicitação pela cadeia
        alunoHandler.handleRequest(request);

        // Cria uma solicitação de lançamento de nota para um aluno
        Request request2 = new Request(PermissionLevel.ALUNO);
        // Envia a solicitação pela cadeia
        alunoHandler.handleRequest(request2);
    }
}