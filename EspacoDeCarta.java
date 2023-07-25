/** GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Murillo Justino
 */

package monopoly;

public class EspacoDeCarta extends Espaco {

  // construtor (espaco = T para COFRE e espaco = F para SORTE)
  public EspacoDeCarta(boolean espaco) {
    super(NomeDoEspaco.COFRE, NomeDoEspaco.SORTE, espaco);
  }

  // métodos
  // @Override - Precisa desse override?
  public NomeDoEspaco tarefaEspaco() {
    return getNomeDoEspaco();
  }

}
