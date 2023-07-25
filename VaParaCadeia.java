/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Nicholas Pandelis Papadopoulos Ferreira
 */

package monopoly;

public class VaParaCadeia extends Espaco {
    public VaParaCadeia(){
        super(NomeDoEspaco.VA_PARA_CADEIA);
    }
    
    @Override
    public double tarefaEspaco(Jogador j){
        j.setPosicao(10);  //11 eh a posicao da cadeia, porem o indice do array de espacos eh um a menos
        j.setNaCadeia(true);
        
        return 0f;
    }
}