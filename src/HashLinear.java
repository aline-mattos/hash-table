public class HashLinear {
    private int maxItens;
    private int maxPosicoes;
    private int qtdeItens;
    private Cliente[] estrutura;

    public int funcaoHash(Cliente cliente) {
        return (cliente.getCpf() % maxPosicoes);
    }

    public HashLinear(int tamVetor, int max) {
        qtdeItens = 0;
        estrutura = new Cliente[tamVetor]; // Usando um array de tamanho fixo

        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new Cliente();
        }
        maxPosicoes = tamVetor;
        maxItens = max;

        double fatorDeCarga = (double) max / tamVetor;
        double fatorDeCargaMaximo = 0.7; // Define o limite de fator de carga

        System.out.println("Fator de Carga = " + fatorDeCarga);

        if (fatorDeCarga > fatorDeCargaMaximo) {
            redimensionarTabelaLinear();
        }
    }

    private void redimensionarTabelaLinear() {
        // Calcular o novo tamanho da tabela (por exemplo, dobrar o tamanho)
        int novoTamanho = maxPosicoes * 2;

        // Criar uma nova estrutura para a tabela hash com o novo tamanho
        Cliente[] novaEstrutura = new Cliente[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaEstrutura[i] = new Cliente();
        }

        // Transferir os elementos da estrutura antiga para a nova estrutura
        for (Cliente cliente : estrutura) {
            if (cliente.getCpf() != -1) {
                int novaPosicao = funcaoHash(cliente) % novoTamanho;

                // Realize uma sondagem linear para encontrar a próxima posição vazia na nova estrutura
                while (novaEstrutura[novaPosicao].getCpf() != -1) {
                    novaPosicao = (novaPosicao + 1) % novoTamanho;
                }
                novaEstrutura[novaPosicao] = cliente;
            }
        }
        // Atualizar a estrutura com a nova estrutura
        estrutura = novaEstrutura;

        System.out.println("Tabela linear redimensionada!");
    }

    public void inserirLinear(Cliente cliente) {
        int localInsercao = funcaoHash(cliente);
        while (estrutura[localInsercao].getCpf() > 0) {
            if (qtdeItens >= maxItens) {
                System.out.println("\nLimite de itens alcançado. Redimensionando a tabela linear.");
                redimensionarTabelaLinear();
            }
            localInsercao = (localInsercao + 1) % maxPosicoes;
        }
        estrutura[localInsercao] = cliente;
        qtdeItens++;
    }
    public void removerLinear(Cliente cliente) {
        int localRemocao = funcaoHash(cliente);
        boolean teste = false;
        while (estrutura[localRemocao].getCpf() != -1) {
            if (estrutura[localRemocao].getCpf() == cliente.getCpf()){
                System.out.println("Elemento removido!\n");
                estrutura[localRemocao] = new Cliente(-2, "removido");
                qtdeItens--;
                teste = true;
                break;
            }
            localRemocao = (localRemocao + 1) % maxPosicoes;
        }
        if (!teste){
            System.out.println("Elemento não encontrado!\nNenhum elemento removido.");
        }
    }
    public void buscarLinear(Cliente cliente){
        int localBuscado = funcaoHash(cliente);
        boolean encontrado = false;
        while (estrutura[localBuscado].getCpf() != -1) {
            if (estrutura[localBuscado].getCpf() == cliente.getCpf()) {
                    cliente = estrutura[localBuscado];
                    System.out.println("\n--* Cliente encontrado -> Na tabela Linear, na posição " +  localBuscado +  " com CPF " + cliente.getCpf() + " e nome " + cliente.getNome());
                    encontrado = true;
                    break;
            }
            localBuscado = (localBuscado + 1) % maxPosicoes;
        }
        if(!encontrado) {
            System.out.println("\nTabela Hash Linear --* Cliente não encontrado.");
        }
    }

    public void imprimirTabelaLinear() {
        System.out.println("\n## Tabela Hash Linear:");
        for (int i = 0; i < maxPosicoes; i++) {
            Cliente cliente = estrutura[i];
            if (cliente.getCpf() > 0) {
                System.out.println("Posição " + i + "-> CPF: " + cliente.getCpf() + " Nome: " + cliente.getNome());
            }
        }
    }
}
