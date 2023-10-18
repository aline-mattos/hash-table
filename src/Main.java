import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int escolha;
        int tamVetor;
        int max;

        System.out.println("----------------------------------------+++++----------------------------------------");
        System.out.println("Olá! Vamos criar a nossa tabela Hash?\n " +
                "Primeiramente, escolha o que você o tamanho da tabela:");
        tamVetor = leitor.nextInt();
        System.out.println("Escolha o máximo de itens:");
        max = leitor.nextInt();
        HashLinear tabelaHashLinear = new HashLinear(tamVetor, max);
        HashListaEncadeada tabelaHashLista = new HashListaEncadeada(tamVetor, max);

        System.out.println("----------------------------------------+++++----------------------------------------");

        System.out.println("Pronto! Criamos nossa tabela de Clientes, que possuem um cpf (sua id) e um nome.\n" +
                "A fim de trabalharmos melhor, informe apenas os 4 ÚLTIMOS NÚMEROS do cpf.");
        System.out.println("----------------------------------------+++++----------------------------------------");
        try {
            do {
                System.out.println("\nO que você deseja fazer agora?");
                System.out.println("0. Sair");
                System.out.println("1. Inserir Cliente;");
                System.out.println("2. Buscar Cliente;");
                System.out.println("3. Remover Cliente;");
                System.out.println("4. Imprimir Tabela Hash;");
                System.out.println("\nDigite uma opção:");

                escolha = leitor.nextInt();

                    switch (escolha) {
                        case 0 -> System.out.println("Encerrando o programa.");
                        case 1 -> {
                            System.out.println("Você escolheu a Opção 1. Inserir Cliente;");
                            System.out.println("Digite os 4 últimos números do cpf do cliente:");
                            int cpfCliente = leitor.nextInt();
                            leitor.nextLine();
                            System.out.println("Digite o nome do cliente:");
                            String nomeCliente = leitor.nextLine();
                            Cliente cliente = new Cliente(cpfCliente, nomeCliente);

                            //comeco teste eficiencia
                            long tempoComeco = System.nanoTime();
                            //insercao com sondagem linear
                            tabelaHashLinear.inserirLinear(cliente);
                            //fim teste eficiencia
                            long tempoFim = System.nanoTime();
                            long duracaoLinear = tempoFim - tempoComeco;

                            //comeco teste eficiencia
                            tempoComeco = System.nanoTime();
                            //insercao com lista encadeada
                            tabelaHashLista.inserirLista(cliente);
                            //fim teste eficiencia
                            tempoFim = System.nanoTime();
                            long duracaoLista = tempoFim - tempoComeco;

                            System.out.println("----------------------------------------+++++----------------------------------------");
                            System.out.println("Cliente inserido com sucesso!\n");

                            //resultado eficiencia
                            System.out.println("\n---------------------------------Teste de Eficiência---------------------------------");
                            System.out.println("Tempo de inserção Linear: " + duracaoLinear + " ns");
                            System.out.println("Tempo de inserção de Lista Encadeada: " + duracaoLista + " ns");
                            System.out.println("-------------------------------------------------------------------------------------");

                            //imprimir tabelas
                            tabelaHashLinear.imprimirTabelaLinear();
                            tabelaHashLista.imprimirTabelaEncadeada();
                            System.out.println("----------------------------------------+++++----------------------------------------");
                        }
                        case 2 -> {
                            System.out.println("Você escolheu a Opção 2. Buscar Cliente;");
                            System.out.println("Digite os 4 últimos números do cpf do cliente:");
                            int cpfCliente = leitor.nextInt();
                            Cliente clienteProcurado = new Cliente(cpfCliente, "");

                            //comeco teste eficiencia
                            long tempoComeco = System.nanoTime();
                            //buscar linear
                            tabelaHashLinear.buscarLinear(clienteProcurado);
                            //fim teste eficiencia
                            long tempoFim = System.nanoTime();
                            long duracaoLinear = tempoFim - tempoComeco;

                            //comeco teste eficiencia
                            tempoComeco = System.nanoTime();
                            //buscar lista
                            tabelaHashLista.buscarListaEncadeada(clienteProcurado);
                            //fim teste eficiencia
                            tempoFim = System.nanoTime();
                            long duracaoLista = tempoFim - tempoComeco;

                            //resultado eficiencia
                            System.out.println("\n---------------------------------Teste de Eficiência---------------------------------");
                            System.out.println("Tempo de busca Linear: " + duracaoLinear + " ns");
                            System.out.println("Tempo de busca de Lista Encadeada: " + duracaoLista + " ns");
                            System.out.println("-------------------------------------------------------------------------------------");
                        }
                        case 3 -> {
                            System.out.println("Você escolheu a Opção 3. Remover Cliente;");
                            System.out.println("Qual Cliente você gostaria de remover?\nDigite os 4 últimos números do cpf do cliente:");
                            int cpfCliente = leitor.nextInt();
                            Cliente clienteProcurado = new Cliente(cpfCliente, "");

                            //comeco teste eficiencia
                            long tempoComeco = System.nanoTime();
                            //remove linear
                            tabelaHashLinear.removerLinear(clienteProcurado);
                            //fim teste eficiencia
                            long tempoFim = System.nanoTime();
                            long duracaoLinear = tempoFim - tempoComeco;

                            //comeco teste eficiencia
                            tempoComeco = System.nanoTime();
                            //remove da lista
                            tabelaHashLista.removerLista(clienteProcurado);
                            //fim teste eficiencia
                            tempoFim = System.nanoTime();
                            long duracaoLista = tempoFim - tempoComeco;

                            //resultado eficiencia
                            System.out.println("\n---------------------------------Teste de Eficiência---------------------------------");
                            System.out.println("Tempo de remoção Linear: " + duracaoLinear + " ns");
                            System.out.println("Tempo de temoção de Lista Encadeada: " + duracaoLista + " ns");
                            System.out.println("-------------------------------------------------------------------------------------");

                            //imprimir tabelas
                            tabelaHashLinear.imprimirTabelaLinear();
                            tabelaHashLista.imprimirTabelaEncadeada();
                        }
                        case 4 -> {
                            tabelaHashLinear.imprimirTabelaLinear();
                            tabelaHashLista.imprimirTabelaEncadeada();
                        }
                        default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
                    }
                } while (escolha != 0);
        }         catch (Exception e) {
            System.out.println("Escolha um número inteiro!");
        }

    }
}