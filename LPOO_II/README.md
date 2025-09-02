# 📚 Navegador com Histórico usando Pilha em Java

Este projeto implementa uma aplicação em **Java** que simula o funcionamento de um navegador simples, armazenando o **histórico de páginas visitadas** com a estrutura de dados **Pilha**.  

A pilha foi implementada manualmente com **LinkedList**, sem utilizar a classe `Stack` da biblioteca Java.

---

## 🚀 Funcionalidades

- **Acessar nova página**: solicita título e URL e adiciona ao histórico.  
- **Voltar para página anterior**: remove a página atual da pilha.  
- **Ver página atual**: exibe título e URL da página no topo da pilha.  
- **Exibir histórico de navegação**: mostra todas as páginas visitadas, do mais recente ao mais antigo.  
- **Sair**: encerra o programa.

---

## 🛠 Estrutura do Projeto

- **Classe `Pagina`**  
  Representa uma página visitada, com os atributos `titulo` e `url`.

- **Classe `PilhaPaginas`**  
  Implementa os métodos básicos de uma pilha:  
  - `push(Pagina p)` → adiciona uma nova página.  
  - `pop()` → remove a página atual.  
  - `peek()` → mostra a página atual.  
  - `isEmpty()` → verifica se a pilha está vazia.  
  - `exibirHistorico()` → mostra todo o histórico de navegação.  

- **Classe `Main`**  
  Contém o **menu interativo** para o usuário navegar e interagir com o histórico.

---

## 📂 Estrutura de Pastas

```plaintext
navegador/
│── Pagina.java
│── PilhaPaginas.java
│── Main.java
