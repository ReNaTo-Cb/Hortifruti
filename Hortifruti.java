
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Scanner;

  // Classe Produto
  class Produto {
      private String nome;
      private int quantidade;

      public Produto(String nome, int quantidade) {
          this.nome = nome;
          this.quantidade = quantidade;
      }

      public String getNome() {
          return nome;
      }

      public int getQuantidade() {
          return quantidade;
      }

      public void adicionarQuantidade(int quantidade) {
          this.quantidade += quantidade;
      }

      @Override
      public String toString() {
          return "Produto: " + nome + ", Quantidade: " + quantidade;
      }
  }

  // Classe Estoque
  class Estoque {
      private List<Produto> produtos;

      public Estoque() {
          produtos = new ArrayList<>();
      }

      public void adicionarProduto(Produto produto) {
          produtos.add(produto);
          System.out.println("Produto adicionado com sucesso!");
      }

      public void listarProdutos() {
          System.out.println("\nProdutos no Estoque:");
          for (Produto produto : produtos) {
              System.out.println(produto);
          }
      }

      public Produto buscarProduto(String nome) {
          for (Produto produto : produtos) {
              if (produto.getNome().equalsIgnoreCase(nome)) {
                  return produto;
              }
          }
          return null;
      }
  }

  // Classe principal
  public class Main {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          Estoque estoque = new Estoque();

          while (true) {
              System.out.println("\nMenu:");
              System.out.println("1. Adicionar Produto");
              System.out.println("2. Listar Produtos");
              System.out.println("3. Adicionar Quantidade a Produto");
              System.out.println("4. Sair");
              System.out.print("Escolha uma opção: ");

              int opcao = scanner.nextInt();
              scanner.nextLine(); // Consumir nova linha

              if (opcao == 1) {
                  System.out.print("Digite o nome do produto: ");
                  String nome = scanner.nextLine();
                  System.out.print("Digite a quantidade do produto: ");
                  int quantidade = scanner.nextInt();
                  scanner.nextLine(); // Consumir nova linha
                  Produto produto = new Produto(nome, quantidade);
                  estoque.adicionarProduto(produto);
              } else if (opcao == 2) {
                  estoque.listarProdutos();
              } else if (opcao == 3) {
                  System.out.print("Digite o nome do produto para adicionar quantidade: ");
                  String nome = scanner.nextLine();
                  Produto produto = estoque.buscarProduto(nome);
                  if (produto != null) {
                      System.out.print("Digite a quantidade a ser adicionada: ");
                      int quantidade = scanner.nextInt();
                      produto.adicionarQuantidade(quantidade);
                      System.out.println("Quantidade atualizada com sucesso!");
                  } else {
                      System.out.println("Produto não encontrado.");
                  }
              } else if (opcao == 4) {
                  System.out.println("Saindo...");
                  break;
              } else {
                  System.out.println("Opção inválida. Tente novamente.");
              }
          }

          scanner.close();
      }
  }


