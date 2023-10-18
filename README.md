# Tabela Hash

Uma tabela hash, também conhecida como tabela de dispersão, é uma estrutura de dados especial que associa chaves de pesquisa a valores, permitindo uma busca rápida e eficiente. Ela é composta por um vetor, cada uma das posições armazena zero, uma, ou mais chaves (e valores associados). 
A tabela hash utiliza uma função de hashing para mapear as chaves em índices do vetor, permitindo que a busca seja realizada em tempo constante, independentemente do tamanho da tabela.

### A função Hash

A função de hashing é responsável por espalhar as chaves pela tabela de hash, e pode ser implementada de diversas maneiras, como por exemplo, utilizando os dois primeiros dígitos da chave, os dois dígitos do meio ou os dois últimos dígitos. Quando duas ou mais chaves são mapeadas para a mesma posição da tabela, ocorre uma colisão, e é necessário utilizar um mecanismo de resolução de colisões, como o encadeamento separado ou o endereçamento aberto.

Definições: [Tabela de dispersão](https://pt.wikipedia.org/wiki/Tabela_de_dispers%C3%A3o); [Hashing](https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/st-hash.html); [Tabelas hash](https://www.dca.fee.unicamp.br/cursos/EA876/apostila/HTML/node26.html).

## O projeto

O projeto foi desenvolvido seguindo as boas práticas de Programação Orientada a Objetos.
Possui três classes:
- A classe <b>Cliente</b> refere-se ao objeto Cliente criado, que possui um nome (String) e um CPF (aqui tratado com um int). Para fins de simplificação, o CPF é tratado como um número inteiro e apenas pelos seus últimos 4 números.
- A classe <b>HashLinear</b> refere-se ao tratamento de prossíveis colisões na tabela Hash com Sondagem Linear;
- A classe <b>HashListaEncadeada</b> refere-se ao tratamento de prossíveis colisões na tabela Hash com Lista Encadeada;

Quando duas ou mais chaves são mapeadas para a mesma posição da tabela, ocorre uma colisão, e é necessário utilizar um mecanismo de resolução de colisões.

## Sondagem Linear

Na sondagem linear, quando ocorre uma colisão, a busca é realizada <b>sequencialmente</b> nas posições seguintes da tabela <b>até encontrar uma posição livre</b> para armazenar a chave. A sondagem linear é uma técnica simples e fácil de implementar, mas pode levar a agrupamentos de chaves na tabela, o que pode prejudicar o desempenho da busca.

Saiba mais: [Resolução de colisões por sondagem linear](https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/st-hash.html);

## Lista Encadeada

No método de lista encadeada, <b>cada posição da tabela contém um ponteiro para uma lista encadeada</b>, que armazena todas as chaves que foram mapeadas para essa posição. Quando ocorre uma colisão, a nova chave é adicionada à lista encadeada correspondente à posição da tabela. Na busca, é aplicada a função de hash, e o retorno indica qual ponteiro deve ser seguido para acessar a lista encadeada correspondente à chave procurada.

Saiba mais: [Resolução de colisões por encadeamento (lista ligada)](https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/st-hash.html);

# Métodos

Todos os métodos existem para os dois tipos de tratamento de colisão, porém são implementados seguindo a melhor abordagem dependendo do mesmo.

### Método Inserir

O método `inserir()` para <b>sondagem linear</b> insere um cliente na tabela hash, verificando se a posição calculada pela função de hash já está ocupada; em caso afirmativo, ele realiza uma varredura linear subsequente para encontrar a próxima posição vazia. Já o método de inserção para <b>lista encadeada</b> insere um cliente na tabela hash, adicionando-o a uma lista encadeada na posição calculada pela função de hash, permitindo que vários clientes ocupem a mesma posição sem colisões.

### Método Buscar

O método `buscar()` para <b>sondagem linear</b> procura um cliente na tabela hash percorrendo as posições sequencialmente até encontrar o cliente correspondente ou uma posição vazia. Por outro lado, o método de busca para <b>lista encadeada</b> procura o cliente na lista encadeada da posição calculada pela função de hash, percorrendo a lista até encontrar o cliente desejado ou determinar que ele não está presente na lista. Ambos os métodos têm como objetivo localizar um cliente na tabela, mas a abordagem linear examina todas as posições, enquanto a lista encadeada examina apenas os elementos da lista na posição calculada.

### Método Remover

O método `remover()` para <b>sondagem linear</b> procura um cliente na tabela hash e, quando encontrado, o remove marcando a posição como "removida". Enquanto o método de remoção para <b>lista encadeada</b> pesquisa a lista encadeada na posição da tabela hash, encontra o cliente correspondente e o remove da lista sem afetar outros elementos na mesma posição.

É importante ressaltar que existe uma diferença, quando o espaço na tabela é vazio, ou seja, nunca foi inserido um valor ali, ele é definido como "-1", já quando um valor é removido e o espaço se torna disponível, ele é definido como "-2".

### Método Imprimir
O método de `imprimir()` nada mais faz que imprimir a árvore de forma amigável para o entendimento do usuário;

