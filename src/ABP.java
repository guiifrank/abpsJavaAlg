import java.util.ArrayList;
import java.util.List;

public class ABP {
        Nodo raiz;

        public ABP() {
            this.raiz = null;
        }

        public void insere(String nomeProduto, int quantidade) {
            raiz = insereRec(raiz, nomeProduto, quantidade);
        }

        private Nodo insereRec(Nodo raiz, String nomeProduto, int quantidade) {
            if (raiz == null) {
                raiz = new Nodo(nomeProduto, quantidade);
                return raiz;
            }

            if (nomeProduto.compareTo(raiz.nomeProduto) < 0) {
                raiz.esquerda = insereRec(raiz.esquerda, nomeProduto, quantidade);
            } else if (nomeProduto.compareTo(raiz.nomeProduto) > 0) {
                raiz.direita = insereRec(raiz.direita, nomeProduto, quantidade);
            } else {
                throw new IllegalArgumentException("Produto já existe.");
            }

            return raiz;
        }

        public Integer consulta(String nomeProduto) {
            return consultaRec(raiz, nomeProduto);
        }

        private Integer consultaRec(Nodo raiz, String nomeProduto) {
            if (raiz == null) {
                return null;
            }

            if (nomeProduto.equals(raiz.nomeProduto)) {
                return raiz.quantidade;
            } else if (nomeProduto.compareTo(raiz.nomeProduto) < 0) {
                return consultaRec(raiz.esquerda, nomeProduto);
            } else {
                return consultaRec(raiz.direita, nomeProduto);
            }
        }

        public void remove(String nomeProduto) {
            raiz = removeRec(raiz, nomeProduto);
        }

        private Nodo removeRec(Nodo raiz, String nomeProduto) {
            if (raiz == null) {
                return raiz;
            }

            if (nomeProduto.compareTo(raiz.nomeProduto) < 0) {
                raiz.esquerda = removeRec(raiz.esquerda, nomeProduto);
            } else if (nomeProduto.compareTo(raiz.nomeProduto) > 0) {
                raiz.direita = removeRec(raiz.direita, nomeProduto);
            } else {
                if (raiz.esquerda == null) {
                    return raiz.direita;
                } else if (raiz.direita == null) {
                    return raiz.esquerda;
                }

                raiz.nomeProduto = encontraMin(raiz.direita).nomeProduto;
                raiz.direita = removeRec(raiz.direita, raiz.nomeProduto);
            }

            return raiz;
        }

        private Nodo encontraMin(Nodo raiz) {
            Nodo min = raiz;
            while (min.esquerda != null) {
                min = min.esquerda;
            }
            return min;
        }

        public int totalProdutos() {
            return totalProdutosRec(raiz);
        }

        private int totalProdutosRec(Nodo raiz) {
            if (raiz == null) {
                return 0;
            }
            return 1 + totalProdutosRec(raiz.esquerda) + totalProdutosRec(raiz.direita);
        }

        public int totalQuantidade() {
            return totalQuantidadeRec(raiz);
        }

        private int totalQuantidadeRec(Nodo raiz) {
            if (raiz == null) {
                return 0;
            }
            return raiz.quantidade + totalQuantidadeRec(raiz.esquerda) + totalQuantidadeRec(raiz.direita);
        }

        public List<Nodo> percursoInOrder(boolean reverso) {
            List<Nodo> elementos = new ArrayList<>();
            percursoInOrderRec(raiz, elementos, reverso);
            return elementos;
        }

        private void percursoInOrderRec(Nodo raiz, List<Nodo> elementos, boolean reverso) {
            if (raiz != null) {
                if (reverso) {
                    percursoInOrderRec(raiz.direita, elementos, reverso);
                    elementos.add(raiz);
                    percursoInOrderRec(raiz.esquerda, elementos, reverso);
                } else {
                    percursoInOrderRec(raiz.esquerda, elementos, reverso);
                    elementos.add(raiz);
                    percursoInOrderRec(raiz.direita, elementos, reverso);
                }
            }
        }
    }


