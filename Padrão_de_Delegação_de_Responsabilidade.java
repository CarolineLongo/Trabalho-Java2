//o Manager delega a tarefa "Projeto de desenvolvimento" aos Employee, que são os trabalhadores. 
//O Padrão de Delegação de Responsabilidade permite que o Manager distribua tarefas de forma flexível aos funcionários, que executam suas respectivas responsabilidades.

import java.util.ArrayList;
import java.util.List;

// Interface que define as tarefas que um funcionário pode realizar
interface Employee {
    void performTask(String task);
}

// Implementação concreta de um funcionário
class Worker implements Employee {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void performTask(String task) {
        System.out.println(name + " está realizando a tarefa: " + task);
    }
}

// Classe que atua como o gerente e delega tarefas aos funcionários
class Manager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void delegateTask(String task) {
        for (Employee employee : employees) {
            employee.performTask(task);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando funcionários
        Employee employee1 = new Worker("João");
        Employee employee2 = new Worker("Maria");
        Employee employee3 = new Worker("Pedro");

        // Criando um gerente
        Manager manager = new Manager();

        // Adicionando funcionários ao gerente
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        // O gerente delega uma tarefa aos funcionários
        manager.delegateTask("Projeto de desenvolvimento");

        // Resultado: Todos os funcionários executam a mesma tarefa
    }
}
