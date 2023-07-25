
/** GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 *
 * responsavel pela classe: Carlos Henrique de França Marques
 */

package monopoly;

public class TaxaDeRiqueza extends Espaco {
  private static final int TAXA = 200;

  public TaxaDeRiqueza() {
    super(NomeDoEspaco.TAXA_RIQUEZA);
  }

  @Override
  public double tarefaEspaco(Jogador j) {
    return getTaxa();
  }

  public static int getTaxa() {
    return TAXA;
  }
}