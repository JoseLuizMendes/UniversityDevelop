1 – Imagine que você está desenvolvendo uma aplicação que simula a navegação em um
navegador de internet. Sempre que o usuário acessa uma nova página, ela é adicionada
ao histórico de navegação. Se o usuário desejar voltar, o sistema deve recuperar a página
anterior a partir da pilha de páginas visitadas.
O objetivo deste trabalho é implementar, em Java, uma aplicação que utilize a estrutura
de dados Pilha para gerenciar o histórico das páginas visitadas. Para isso, construa as
classes abaixo:
Especificações

1. Classe Pagina
  • Deve conter, no mínimo, os atributos:
  ◦ String url
  ◦ String titulo
  • Construtor e métodos get/set.
• Método toString() para exibir os dados de forma legível.

2. Classe PilhaPaginas
  • Implementar os métodos básicos da pilha:
  ◦ push(Pagina p) → adiciona uma nova página.
  ◦ pop() → remove a página atual.
  ◦ peek() → mostra a página atual .
  ◦ isEmpty() → verifica se a pilha está vazia.

3. Classe Main
  • Implementar um menu de opções para o usuário interagir:
  1 – Acessar nova página: solicitar título e URL e empilhar.
  2 – Voltar para página anterior
  3 – Ver página atual (título e URL)
  4 – Exibir histórico de navegação.
  5 – Sair.

Regras do Trabalho
  • A implementação da pilha deve ser feita usando LinkedList (não usar Stack da
  biblioteca Java).
  • O programa deve ser orientado a objetos, com no mínimo as três classes descritas.
  • O menu deve permitir que o usuário interaja de forma contínua até escolher sair.
  • O código deve estar identado e bem estruturado.

Critérios de Avaliação
  • Correta implementação da classe Pagina (0,5).
  • Correta implementação da pilha (PilhaPaginas) com os métodos exigidos (0,5 pts).
  • Funcionamento adequado do menu na classe Main (1,5 pts).
  • Clareza, legibilidade e documentação do código (0,5 pts).

Nota máxima: 10 pontos.

