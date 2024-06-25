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

    public List<Aresta> encontraMaiorCaminho() {
        List<Aresta> maiorCaminho = new ArrayList<>();
        List<Aresta> caminhoAtual = new ArrayList<>();
        for (Caixa caixa : listaCaixas) {
            caminhoAtual.clear();
            List<Aresta> result = dfs(caixa, caminhoAtual);
            if (result.size() > maiorCaminho.size()) {
                maiorCaminho = result;
            }
        }
        return maiorCaminho;
    }

    private List<Aresta> dfs(Caixa caixa, List<Aresta> caminhoAtual) {
        List<Aresta> maxCaminhoLista = new ArrayList<>(caminhoAtual);

        for (Aresta aresta : caixa.getAdjacentes()) {
            Caixa destino = aresta.getDestino();
            if (!caminhoAtual.contains(aresta)) {
                List<Aresta> novoCaminhoAtual = new ArrayList<>(caminhoAtual);
                novoCaminhoAtual.add(aresta);
                List<Aresta> result = dfs(destino, novoCaminhoAtual);
                if (result.size() > maxCaminhoLista.size()) {
                    maxCaminhoLista = result;
                }
            }
        }
        return maxCaminhoLista;
    }

    public String toDot(List<Aresta> caminho) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        for (Aresta aresta : caminho) {
            sb.append("  \"")
              .append(aresta.getOrigem())
              .append("\" -> \"")
              .append(aresta.getDestino())
              .append("\"];\n");
        }
        sb.append("}");
        return sb.toString();
    }


}