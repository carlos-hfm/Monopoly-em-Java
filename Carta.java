/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Gabriel Evangelista Goncalves da Silva
 */

package monopoly;

public class Carta {

  // unico atributo geral de todas as cartas.
  private final String DESCRICAO;
  

  public Carta(EnumCarta e) {
    this.DESCRICAO = e.getDescricao();
  }

  public String getDescricao() {
    return DESCRICAO;
  }

}