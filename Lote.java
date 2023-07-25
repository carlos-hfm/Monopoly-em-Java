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

public class Lote extends Propriedade {
  private String cor;
  private int precoAluguel;
  private int precoConstrucaoCasa;
  private int precoAluguelComCasa;
  private int quantidadeCasas;

  public Lote(int preco, String cor, int precoAluguel, int precoConstrucaoCasa, int precoAluguelComCasa,
      NomeDoEspaco nome) {
    super(nome, preco);
    this.cor = cor;
    this.precoAluguel = precoAluguel;
    this.precoConstrucaoCasa = precoConstrucaoCasa;
    this.precoAluguelComCasa = precoAluguelComCasa;
    this.quantidadeCasas = 0;
  }

  public String getCor() {
    return this.cor;
  }

  public int getPrecoConstrucaoCasa() {
    return this.precoConstrucaoCasa;
  }

  public int getQuantidadeCasas() {
    return this.quantidadeCasas;
  }

  public void adicionarCasa() {
    this.quantidadeCasas++;
  }

  public void removerCasas(){
    this.quantidadeCasas = 0;
  }

  @Override
  public int calcularAluguel(int valor) {
    if (quantidadeCasas > 0) {
      return this.precoAluguelComCasa * this.quantidadeCasas;
    }
    return this.precoAluguel;
  }

  @Override
  public double valorConstrucoesTotal() {
    return (this.quantidadeCasas * this.precoConstrucaoCasa);
  }
}