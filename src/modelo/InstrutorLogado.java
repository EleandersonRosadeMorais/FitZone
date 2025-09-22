
package modelo;

public class InstrutorLogado {
    
    private static Instrutor instrutorLogado;

    public InstrutorLogado() {
    }

    public static Instrutor getInstrutorLogado() {
        return instrutorLogado;
    }

    public static void setInstrutorLogado(Instrutor instrutorLogado) {
        InstrutorLogado.instrutorLogado = instrutorLogado;
    }

}
