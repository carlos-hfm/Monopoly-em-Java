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

public class Utilidade extends Propriedade {
  private int precoAluguel;

  public Utilidade(int preco, NomeDoEspaco nome) {
    super(nome, preco);
    this.precoAluguel = 0;
  }

  @Override
  public int calcularAluguel(int valor) {
    ArrayList<Propriedade> propriedades = getComprador().getPropriedades();
    int quantidadeUtilidades = 0;

    for (int i = 0; i < getComprador().getPropriedades().size(); i++) {
      if (propriedades.get(i).getClass().getSimpleName().equals("Utilidade")) {
        quantidadeUtilidades++;
      }
    }

    if (quantidadeUtilidades == 1) {
      this.precoAluguel = valor * 4;
    } else {
      this.precoAluguel = valor * 10;
    }

    return this.precoAluguel;
  }

  @Override
  public double valorConstrucoesTotal() {
    return 0;
  }
}
