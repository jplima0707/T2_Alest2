import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] v = {2 ,3 ,4};
        int[] vv = {8 , 4, 9}; 

        Caixa a = new Caixa(v);
        Caixa b = new Caixa(vv);

        a.adicionaAresta(b);
        b.adicionaAresta(a);

        List<Caixa> caixas = new ArrayList<>();
        caixas.add(a);
        caixas.add(b);
        
        Grafo g = new Grafo(2, caixas);
        g.passaAdjacentes(caixas);
        System.out.println(g.getTodasAdjacentes());
    }
}
