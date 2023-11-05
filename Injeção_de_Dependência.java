// Classe que representa o serviço de e-mail
// Aqui é exemplificado a Injeção de Dependência usando construtores, ou seja, serviço de e-mail / 
// Cliente que ao invés de instanciar diretamente  ele(cliente) receberá uma instância injetada através do construtor.
class ServicoEmail {
    public void enviarEmail(String destinatario, String mensagem) {
        // Lógica para enviar e-mail
        System.out.println("Enviando e-mail para " + destinatario + ": " + mensagem);
    }
}

// Classe Cliente que depende do ServicoEmail
class Cliente {
    private ServicoEmail servicoEmail;

    public Cliente(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
    }

    public void enviarMensagemPorEmail(String destinatario, String mensagem) {
        servicoEmail.enviarEmail(destinatario, mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        ServicoEmail servicoEmail = new ServicoEmail();
        Cliente cliente = new Cliente(servicoEmail);

        cliente.enviarMensagemPorEmail("exemplo@email.com", "Olá, este é um e-mail de teste.");
    }
}
