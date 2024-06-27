import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaABP listaABP = new ListaABP();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir produto");
            System.out.println("2. Consultar produto");
            System.out.println("3. Remover produto");
            System.out.println("4. Total de produtos");
            System.out.println("5. Total de quantidades de produtos");
            System.out.println("6. Exibir produtos em ordem alfabética");
            System.out.println("7. Exibir produtos por letra");
            System.out.println("8. Exibir produtos por quantidade");
            System.out.println("9. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    listaABP.insereProduto(nome, quantidade);
                    break;

                case 2:
                    System.out.print("Digite o nome do produto: ");
                    nome = scanner.nextLine();
                    Integer quant = listaABP.consultaProduto(nome);
                    if (quant != null) {
                        System.out.println("Quantidade: " + quant);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do produto: ");
                    nome = scanner.nextLine();
                    listaABP.removeProduto(nome);
                    break;

                case 4:
                    System.out.println("Total de produtos: " + listaABP.totalProdutos());
                    break;

                case 5:
                    System.out.println("Total de quantidades de produtos: " + listaABP.totalQuantidadesProdutos());
                    break;

                case 6:
                    System.out.println("Produtos em ordem alfabética:");
                    List<Nodo> produtos = listaABP.exibeProdutosTotal(false);
                    for (Nodo nodo : produtos) {
                        System.out.println(nodo.nomeProduto + ": " + nodo.quantidade);
                    }
                    break;

                case 7:
                    System.out.print("Digite a letra: ");
                    char letra = scanner.nextLine().charAt(0);
                    System.out.println("Produtos que começam com '" + letra + "':");
                    produtos = listaABP.exibeProdutosLetra(letra, false);
                    for (Nodo nodo : produtos) {
                        System.out.println(nodo.nomeProduto + ": " + nodo.quantidade);
                    }
                    break;

                case 8:
                    System.out.print("Digite a quantidade: ");
                    quantidade = scanner.nextInt();
                    System.out.print("Acima (true) ou abaixo (false): ");
                    boolean acima = scanner.nextBoolean();
                    System.out.println("Produtos com quantidade " + (acima ? "acima" : "abaixo") + " de " + quantidade + ":");
                    produtos = listaABP.exibePorQuantidade(quantidade, acima, false);
                    for (Nodo nodo : produtos) {
                        System.out.println(nodo.nomeProduto + ": " + nodo.quantidade);
                    }
                    break;

                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
