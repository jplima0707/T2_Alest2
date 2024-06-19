import java.util.List;

public class Grafo{

    private int numVertices;
    private List<Caixa> listaCaixas;
    private List<Aresta> todasAdjacentes;

    public Grafo(int numVertices, List<Caixa> todasCaixas){
        listaCaixas = todasCaixas;
    }

    public List<Aresta> getTodasAdjacentes(){
        return todasAdjacentes;
    }

    public void passaAdjacentes(List<Caixa> caixas){    
        for (Caixa caixa : caixas) {
            todasAdjacentes.add(caixa.getAdjacentes());
        }

    }
}