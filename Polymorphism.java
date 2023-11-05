// Polymorphism, foi exemplificada através da interface Veículo ser implementada por carro e caminhão.
// Interface comum para todos os veículos
interface Veiculo {
    void acelerar();
    void frear();
}

// Implementação concreta para um carro
class Carro implements Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Carro acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("Carro freando...");
    }
}

// Implementação concreta para um caminhão
class Caminhao implements Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Caminhão acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("Caminhão freando...");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Carro();
        Veiculo veiculo2 = new Caminhao();

        dirigir(veiculo1);
        dirigir(veiculo2);
    }

    public static void dirigir(Veiculo veiculo) {
        veiculo.acelerar();
        veiculo.frear();
    }
}
