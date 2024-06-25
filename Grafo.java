import java.util.ArrayList;
import java.util.List;

public class Grafo{

    private int numVertices;
    private List<Caixa> listaCaixas;
    private List<List<Aresta>> todasAdjacentes;

    public Grafo(int numVertices, List<Caixa> todasCaixas){
        listaCaixas = todasCaixas;
        todasAdjacentes = new ArrayList<>();
        numVertices = 0;
    }

    public List<List<Aresta>> getTodasAdjacentes(){
        todasAdjacentes.clear();
        for(Caixa c : listaCaixas){
            todasAdjacentes.add(c.getAdjacentes());
        }
        return todasAdjacentes;
    }

    public int getNumVertices(){
        return numVertices;

    }

    public void adicionaCaixa(Caixa caixa) {
        listaCaixas.add(caixa);
        todasAdjacentes.add(caixa.getAdjacentes());
        numVertices++;
    }

}