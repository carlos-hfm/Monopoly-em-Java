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

abstract public class Propriedade extends Espaco {
  private int preco;
  private Jogador comprador;

  abstract public int calcularAluguel(int valor);
  
  public Propriedade(NomeDoEspaco nome, int preco){
      super(nome);
      this.preco = preco;
  }
  
  public void setComprador(Jogador comprador) {
    this.comprador = comprador;
  }

  public Jogador getComprador(){
    return this.comprador;
  }
  
  public int getPreco() {
    return this.preco;
  }
  
  public double valorConstrucoesTotal(){
    return 0;
  }

}