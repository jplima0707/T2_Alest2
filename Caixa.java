public class Caixa{

    private int altura;
    private int comprimento;
    private int largura;

    private Caixa(int larg, int comp, int alt){
        this.altura = alt;
        this.comprimento = comp;
        this.largura = larg;

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

    public Caixa criaCaixa(int[] valores){
        int aux;
        if(valores.length > 3){
            System.out.println("Numero de entrada invalido!");
            return null;
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
        Caixa caixa = new Caixa(valores[0], valores[1], valores[2]);
        return caixa;
    }
    }
}