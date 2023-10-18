public class Cliente {
    private int cpf;
    private String nome;

    public Cliente() {
        cpf = -1;
        nome = " ";
    }

    public Cliente(int id, String n) {
        cpf = id;
        nome = n;
    }

    public int getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
