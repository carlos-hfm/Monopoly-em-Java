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

public class PontoDePartida extends Espaco {
    private final int QUANTIAVIRADA;
    
    public PontoDePartida(){
        super(NomeDoEspaco.PONTO_PARTIDA);
        this.QUANTIAVIRADA = 200;    
    }
    
    @Override
    public double tarefaEspaco(Jogador j){
        return this.QUANTIAVIRADA;  //operacao sera feita pelo banco.
    }
}
