// A herança permite que a classe Carro compartilhe características comuns da classe Veiculo e, ao mesmo tempo, 
// adicione seu próprio comportamento específico. Isso é um exemplo prático do uso do conceito de herança na programação orientada a objetos.

// Classe base (superclasse)
class Veiculo {
    String marca;
    String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void acelerar() {
        System.out.println("O veículo está acelerando.");
    }

    public void frear() {
        System.out.println("O veículo está freando.");
    }
}

// Subclasse que herda de Veiculo
class Carro extends Veiculo {
    int numeroPortas;

    public Carro(String marca, String modelo, int numeroPortas) {
        super(marca, modelo);
        this.numeroPortas = numeroPortas;
    }

    public void abrirPorta() {
        System.out.println("Uma porta do carro foi aberta.");
    }
}

public class Main {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "Corolla", 4);

        System.out.println("Marca: " + meuCarro.marca);
        System.out.println("Modelo: " + meuCarro.modelo);
        System.out.println("Número de Portas: " + meuCarro.numeroPortas);

        meuCarro.acelerar();
        meuCarro.abrirPorta();
    }
}
