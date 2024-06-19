public class Aresta{

    private Caixa origem;
    private Caixa destino;
    private final int peso;

    public Aresta(Caixa a, Caixa b){
        this.origem = a;
        this.destino = b;
        this.peso = 1;

    }

    public Caixa getOrigem(){
        return origem;
    }

    public Caixa getDestino(){
        return destino;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getOrigem()).append("==>").append(getDestino());
        return sb.toString();
    }
}