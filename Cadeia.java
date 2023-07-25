/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Carlos Henrique de França Marques
 */

package monopoly;

public class Cadeia extends Espaco{
    private static final int FIANCA = 50;

    public Cadeia(){
        super(NomeDoEspaco.CADEIA);
    }

    @Override
    public double tarefaEspaco(Jogador j){
        return getFianca();
    }
    

    public static int getFianca(){
        return FIANCA;
    }
}