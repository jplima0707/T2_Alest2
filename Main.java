import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    try{
        BufferedReader file = new BufferedReader(new FileReader("caixas_5.txt"));
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
            System.out.println(caixa);
			
        }
        
    }
    catch(Exception o){
    }

    //     Caixa caixa1 = new Caixa(new int[]{3, 2, 1});
    //     Caixa caixa2 = new Caixa(new int[]{6, 5, 4});
    //     Caixa caixa3 = new Caixa(new int[]{9, 8, 7});
    //     List<Caixa> todasCaixas = new ArrayList<>();

    //     Grafo grafo = new Grafo(todasCaixas.size(), todasCaixas);
    //     grafo.adicionaCaixa(caixa1);
    //     grafo.adicionaCaixa(caixa2);
    //     grafo.adicionaCaixa(caixa3);

    //     System.out.println(caixa1.ligaCaixa(caixa2));
    //     System.out.println(caixa1.ligaCaixa(caixa3));
    //     System.out.println(caixa2.ligaCaixa(caixa3));
    //     System.out.println(caixa2.ligaCaixa(caixa1));
    //     System.out.println(caixa3.ligaCaixa(caixa1));
    //     System.out.println(caixa3.ligaCaixa(caixa2));

    //     List<Aresta> maiorCaminho = grafo.encontraMaiorCaminho();
    //     System.out.println("Maior Caminho: " + (maiorCaminho.size()+1));
    //     System.out.println("Caminho: " + maiorCaminho);

    //     String dotRepresentation = grafo.toDot(maiorCaminho);
    //     System.out.println("DOT Representation:\n" + dotRepresentation);
    }
}
