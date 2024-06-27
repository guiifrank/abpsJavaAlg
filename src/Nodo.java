public class Nodo {
        String nomeProduto;
        int quantidade;
        Nodo esquerda, direita;

        public Nodo(String nomeProduto, int quantidade) {
            this.nomeProduto = nomeProduto;
            this.quantidade = quantidade;
            this.esquerda = this.direita = null;
        }
    }


