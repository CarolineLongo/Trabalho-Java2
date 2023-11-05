//Indirection, foi exemplificado através da verificação de um login
// Interface para o sistema real
interface Sistema {
    void acessar(String nomeUsuario);
}

// Implementação concreta do Sistema
class SistemaReal implements Sistema {
    public void acessar(String nomeUsuario) {
        System.out.println("Acesso concedido para " + nomeUsuario);
    }
}

// Proxy para o Sistema
class SistemaProxy implements Sistema {
    private SistemaReal sistemaReal;
    private String usuario;
    private String senha;

    public SistemaProxy(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void acessar(String nomeUsuario) {
        if (autenticar()) {
            if (sistemaReal == null) {
                sistemaReal = new SistemaReal();
            }
            sistemaReal.acessar(nomeUsuario);
        } else {
            System.out.println("Acesso negado para " + nomeUsuario);
        }
    }

    private boolean autenticar() {
        // Simulação de verificação de credenciais de login
        return "usuario".equals(usuario) && "senha123".equals(senha);
    }
}

public class SistemaLoginExample {
    public static void main(String[] args) {
        SistemaProxy proxy = new SistemaProxy("usuario", "senha123");

        proxy.acessar("Alice"); // Acesso concedido
        proxy.acessar("Bob");   // Acesso negado
    }
}
