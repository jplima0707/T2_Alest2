import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader file = new BufferedReader(new FileReader("caixas_15.txt"));
            List<Caixa> caixas = new ArrayList<>();

            String line;
            while ((line = file.readLine()) != null) {
                String[] dimensoesStr = line.trim().split(" ");
                int[] dimensoes = new int[dimensoesStr.length];
                for (int i = 0; i < dimensoesStr.length; i++) {
                    dimensoes[i] = Integer.parseInt(dimensoesStr[i]);
                }
                Caixa caixa = new Caixa(dimensoes);
                caixas.add(caixa);
            }
            file.close();

            Grafo g = new Grafo(caixas.size());

            // Adiciona todas as caixas ao grafo
            for (Caixa c : caixas) {
                g.adicionaCaixa(c);
            }

            // Verifica todas as possíveis ligações entre as caixas
            for (int i = 0; i < caixas.size(); i++) {
                for (int j = 0; j < caixas.size(); j++) {
                    caixas.get(i).ligaCaixa(caixas.get(j)); //tenta fazer todas as ligações possiveis, ligando realemnte apenas as que encaixam
                }
            }

            List<Aresta> maiorCaminho = g.encontraMaiorCaminho();
            System.out.println("Maior Caminho: " + (maiorCaminho.size() + 1)); // +1 pois o metodo nao conta a caixa inicial
            System.out.println("Caminho: " + maiorCaminho);

            String dotRepresentation = g.toDot(maiorCaminho);
            System.out.println("DOT Representation:\n" + dotRepresentation);

        } catch (Exception o) {
            o.printStackTrace();
        }
    }
}
