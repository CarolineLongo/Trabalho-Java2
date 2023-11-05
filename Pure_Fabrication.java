// Classe de Pure Fabrication para contar quilômetros percorridos
// Pure Fabrication, foi exemplificado através da criação de uma contagem de kilomeetro percorrido para bicicleta.
public class ContadorDeKilometros {
    private double distanciaTotal;

    public ContadorDeKilometros() {
        distanciaTotal = 0.0;
    }

    public void adicionarKilometros(double quilometros) {
        if (quilometros > 0) {
            distanciaTotal += quilometros;
        }
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }
}

public class BicicletaApp {
    public static void main(String[] args) {
        ContadorDeKilometros contador = new ContadorDeKilometros();

        // Simulação de andar de bicicleta
        contador.adicionarKilometros(10.5);
        contador.adicionarKilometros(5.3);

        // Obter a distância total percorrida
        double distanciaTotal = contador.getDistanciaTotal();
        System.out.println("Distância total percorrida: " + distanciaTotal + " km");
    }
}
