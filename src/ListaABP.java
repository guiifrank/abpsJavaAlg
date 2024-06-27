import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaABP {
        Map<Character, ABP> arvores;

        public ListaABP() {
            arvores = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                arvores.put(c, new ABP());
            }
        }

        private ABP getArvore(char letra) {
            letra = Character.toUpperCase(letra);
            return arvores.get(letra);
        }

        public void insereProduto(String nomeProduto, int quantidade) {
            char letra = nomeProduto.charAt(0);
            ABP arvore = getArvore(letra);
            if (arvore != null) {
                arvore.insere(nomeProduto, quantidade);
            }
        }

        public Integer consultaProduto(String nomeProduto) {
            char letra = nomeProduto.charAt(0);
            ABP arvore = getArvore(letra);
            if (arvore != null) {
                return arvore.consulta(nomeProduto);
            }
            return null;
        }

        public void removeProduto(String nomeProduto) {
            char letra = nomeProduto.charAt(0);
            ABP arvore = getArvore(letra);
            if (arvore != null) {
                arvore.remove(nomeProduto);
            }
        }

        public int totalProdutos() {
            int total = 0;
            for (ABP arvore : arvores.values()) {
                total += arvore.totalProdutos();
            }
            return total;
        }

        public int totalQuantidadesProdutos() {
            int total = 0;
            for (ABP arvore : arvores.values()) {
                total += arvore.totalQuantidade();
            }
            return total;
        }

        public List<Nodo> exibeProdutosTotal(boolean reverso) {
            List<Nodo> todosProdutos = new ArrayList<>();
            for (char letra : arvores.keySet()) {
                todosProdutos.addAll(arvores.get(letra).percursoInOrder(reverso));
            }
            return todosProdutos;
        }

        public List<Nodo> exibeProdutosLetra(char letra, boolean reverso) {
            ABP arvore = getArvore(letra);
            if (arvore != null) {
                return arvore.percursoInOrder(reverso);
            }
            return new ArrayList<>();
        }

        public List<Nodo> exibePorQuantidade(int quantidade, boolean acima, boolean reverso) {
            List<Nodo> todosProdutos = exibeProdutosTotal(reverso);
            List<Nodo> resultado = new ArrayList<>();
            for (Nodo nodo : todosProdutos) {
                if (acima && nodo.quantidade >= quantidade) {
                    resultado.add(nodo);
                } else if (!acima && nodo.quantidade <= quantidade) {
                    resultado.add(nodo);
                }
            }
            return resultado;
        }
    }


