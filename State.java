// Interface State
// State, este exemplo remete a um caixa de loja que esta em atendimento, livre ou em manutenção.
interface State {
    void processPayment();
    void startMaintenance();
}

// State Concreto "Atendimento"
class ServiceState implements State {
    @Override
    public void processPayment() {
        System.out.println("Processando pagamento da compra.");
    }

    @Override
    public void startMaintenance() {
        System.out.println("Não é possível iniciar a manutenção enquanto o caixa está em atendimento.");
    }
}

// State Concreto "Livre"
class FreeState implements State {
    @Override
    public void processPayment() {
        System.out.println("Não há compras para processar no momento.");
    }

    @Override
    public void startMaintenance() {
        System.out.println("Iniciando manutenção do caixa.");
    }
}

// State Concreto "Em Manutenção"
class MaintenanceState implements State {
    @Override
    public void processPayment() {
        System.out.println("Não é possível processar pagamentos durante a manutenção.");
    }

    @Override
    public void startMaintenance() {
        System.out.println("O caixa já está em manutenção.");
    }
}

// Classe Context (Caixa da Loja)
class CashRegister {
    private State currentState;

    public CashRegister() {
        // Inicialmente, o caixa está "Livre"
        currentState = new FreeState();
    }

    public void setState(State state) {
        currentState = state;
    }

    public void processPayment() {
        currentState.processPayment();
    }

    public void startMaintenance() {
        currentState.startMaintenance();
    }
}

public class ClothingStoreCashRegister {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();

        System.out.println("------ Atendimento ------");
        cashRegister.processPayment();

        System.out.println("\n------ Em Manutenção ------");
        cashRegister.startMaintenance();

        System.out.println("\n------ Livre ------");
        cashRegister.processPayment();
        cashRegister.startMaintenance();
    }
}
