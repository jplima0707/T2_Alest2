import java.util.ArrayList;
import java.util.List;

public class Caixa{

    private int altura;
    private int comprimento;
    private int largura;
    private int aux;
    private List<Aresta> adjacentes;

    public Caixa(int []valores){
        if(valores.length > 3){
            System.out.println("Numero de entrada invalido!");
        } else {  
        for(int i =0; i < valores.length; i++){
            for(int j = i+1;j< valores.length; j++){
                if(valores[i] < valores[j]){
                    aux = valores[i];
                    valores[i] = valores[j];
                    valores[j] = aux; 
                    }
                }
            }
        }
        this.altura = valores[0];
        this.comprimento = valores[1];
        this.largura = valores[2];
        adjacentes = new ArrayList<>();
    }

    public int getAltura(){
        return altura;
    }

    public int getComprimento(){
        return comprimento;
    }

    public int getLargura(){
        return largura;
    }

    public Aresta getAdjacentes(){
        for (Aresta a : adjacentes){
            return a;
        }
        return null;
    }

    public void adicionaAresta(Caixa a){
        Aresta aresta = new Aresta(this, a);
        adjacentes.add(aresta);
    }
}