/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Erik Gabriel Rodrigo da Silva
 */

package monopoly;

import java.util.ArrayList;

public class EstacaoDeMetro extends Propriedade {
  private int precoAluguel;

  public EstacaoDeMetro(int preco, NomeDoEspaco nome) {
    super(nome, preco);
    this.precoAluguel = 25;
  }

  @Override
  public int calcularAluguel(int valor) {
    ArrayList<Propriedade> propriedades = getComprador().getPropriedades();
    int quantidadeMetros = 0;

    for (int i = 0; i < getComprador().getPropriedades().size(); i++) {
      if (propriedades.get(i).getClass().getSimpleName().equals("EstacaoDeMetro")) {
        quantidadeMetros++;
      }
    }
    this.precoAluguel = 25 * quantidadeMetros;
    return this.precoAluguel;
  }

  @Override
  public double valorConstrucoesTotal() {
    return 0;
  }
}