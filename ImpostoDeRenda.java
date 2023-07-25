/** GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 *
 * responsavel pela classe: Carlos Henrique de França Marques
 */

package monopoly;

import java.util.ArrayList;
import java.util.Objects;

public class ImpostoDeRenda extends Espaco {
  private double fortunaDoJogador; // armazena o valor total da fortuna do jogador
  private static final int VALORIMPOSTOFIXO = 200; // armazena o valor do imposto fixo
  private double valorImpostoJogador; // armazena o valor do imposto a ser pago pelo jogador
  private String formaDeImposto; // armazena a opção de imposto escolhida pelo jogador

  public ImpostoDeRenda() {
    super(NomeDoEspaco.IMPOSTO);
    this.formaDeImposto = "Indefinida";
    this.fortunaDoJogador = -1;
    this.valorImpostoJogador = -1;

  }

  @Override
  public double tarefaEspaco(Jogador j, int forma) {
    setFormaDeImposto(forma);
    calculaValorImposto(j);
    double valorCalculadoImposto = this.valorImpostoJogador;

    reiniciaImposto();

    return valorCalculadoImposto;
  }


  private void calculaValorImposto(Jogador j) {
    if (Objects.equals(this.formaDeImposto, "Imposto Fixo")) {
      this.valorImpostoJogador = VALORIMPOSTOFIXO;
    } else if (Objects.equals(this.formaDeImposto, "Porcentagem da Fortuna")) {
      setFortunaDoJogador(j);
      this.valorImpostoJogador = this.fortunaDoJogador * 0.1;
    }

  }

  private boolean reiniciaImposto() {
    this.fortunaDoJogador = -1;
    this.valorImpostoJogador = -1;
    this.formaDeImposto = "Indefinida";

    return true;

  }

  private void setFortunaDoJogador(Jogador j) {
    this.fortunaDoJogador = j.getSaldo();
    ArrayList<Propriedade> pr = j.getPropriedades();
    for (Propriedade propriedade : pr) {
      this.fortunaDoJogador = this.fortunaDoJogador + propriedade.getPreco() + propriedade.valorConstrucoesTotal();
    }
  }

  private void setFormaDeImposto(int forma) {
    if (forma == 1){
      this.formaDeImposto = "Imposto Fixo";
    } else if (forma == 2){
      this.formaDeImposto = "Porcentagem da Fortuna";
    } else {
      this.formaDeImposto = "Forma inválida";
    }
  }

}