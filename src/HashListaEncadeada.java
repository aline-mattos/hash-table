import java.util.ArrayList;
import java.util.List;

public class HashListaEncadeada {
    private int maxItens;
    private int maxPosicoes;
    private int qtdeItens;
    private List<Cliente>[] estrutura; // Usando uma matriz de listas encadeadas

    public HashListaEncadeada(int tamVetor, int max) {
        maxItens = max;
        maxPosicoes = tamVetor;
        estrutura = new ArrayList[tamVetor]; // Inicializa a matriz de listas encadeadas

        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new ArrayList<>();
        }
    }

    public int funcaoHash(Cliente cliente) {
        return (cliente.getCpf() % maxPosicoes);
    }

    private void redimensionarTabelaLista() {
        int novoTamanho = maxPosicoes * 2;

        List<Cliente>[] novaEstrutura = new ArrayList[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaEstrutura[i] = new ArrayList<>();
        }

        for (int i = 0; i < maxPosicoes; i++) {
            for (Cliente cliente : estrutura[i]) {
                int novaPosicao = funcaoHash(cliente) % novoTamanho;
                novaEstrutura[novaPosicao].add(cliente);
            }
        }
        estrutura = novaEstrutura;

        System.out.println("Tabela de lista redimensionada!");
    }

    public void inserirLista(Cliente cliente) {
        if (qtdeItens >= maxItens) {
            System.out.println("\nLimite de itens alcançado. Redimensionando a tabela de lista.");
            redimensionarTabelaLista();
        }
        int localInsercao = funcaoHash(cliente);
        estrutura[localInsercao].add(cliente); // Adiciona o cliente à lista encadeada na posição
        qtdeItens++;
    }

    public void removerLista(Cliente cliente) {
        int localRemocao = funcaoHash(cliente);
        List<Cliente> lista = estrutura[localRemocao];

        for (Cliente c : lista) {
            if (c.getCpf() == cliente.getCpf()) {
                lista.remove(c); // Remove o cliente da lista
                break; // Como encontramos o cliente, podemos sair do loop
            }
        }
    }

    public void buscarListaEncadeada(Cliente cliente) {
        int localBuscado = funcaoHash(cliente);
        boolean encontrado = false;

        List<Cliente> lista = estrutura[localBuscado];

        for (Cliente c : lista) {
            if (c.getCpf() == cliente.getCpf()) {
                cliente = c;
                System.out.println("\n--* Cliente encontrado -> Na tabela com Lista, na posição " + localBuscado + " com CPF " + cliente.getCpf() + " e nome " + cliente.getNome());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nTabela Hash Lista --* Cliente não encontrado.");
        }
    }



    public void imprimirTabelaEncadeada() {
        System.out.println("\n## Tabela Hash Lista Encadeada:");

        for (int i = 0; i < maxPosicoes; i++) {
            List<Cliente> lista = estrutura[i];

            if (!lista.isEmpty()) {
                System.out.println("Posição " + i + " -> Clientes:");
                for (Cliente cliente : lista) {
                    System.out.println("  CPF: " + cliente.getCpf() + " Nome: " + cliente.getNome());
                }
            }
        }
    }

}
