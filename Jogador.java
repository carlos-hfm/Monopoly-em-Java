/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Nicholas Pandelis Papadopoulos Ferreira e __________________
 */

package monopoly;

import java.util.ArrayList;

public class Jogador {
  // ATRIBUTOS
  private double saldo;
  private final String nome;
  private ArrayList<Propriedade> propriedades;
  private boolean estaNaCadeia;
  private int turnosNaCadeia;
  private int numeroDadosIguais;
  private int posicaoTabuleiro;
  private int monopolios;

  // CONSTRUTOR
  public Jogador(String nome) {
    this.saldo = 1500;
    this.nome = nome;
    this.propriedades = new ArrayList<>();
    this.estaNaCadeia = false;
    this.numeroDadosIguais = 0;
    this.posicaoTabuleiro = 0;
    this.monopolios = 0;
    this.turnosNaCadeia = 0;
  }

  // METODOS
  public String getNome() {
    return this.nome;
  }

  public int setPosicao(int novaPos) {
    if (novaPos >= 0 && novaPos < 40) { // posicoes disponiveis do tabuleiro
      this.posicaoTabuleiro = novaPos;

      return 0;
    }
    return -1;
  }

  public ArrayList<Propriedade> getPropriedades() {
    return this.propriedades;
  }

  public int adicionarPropriedade(Propriedade propriedade) {
    if (this.propriedades.size() < 28) {
      this.propriedades.add(propriedade);
      propriedade.setComprador(this);

      return 0;
    }
    return -1;
  }

  public int removerPropriedade(Propriedade propriedade) {
    if (!this.propriedades.isEmpty()) {
      this.propriedades.remove(propriedade);
      
      return 0;
    }
    return -1;
  }
   
  public boolean getNaCadeia() {
    return this.estaNaCadeia;
  }
  public void setNaCadeia(boolean estaNaCadeia) {
    this.estaNaCadeia = estaNaCadeia;
  }

  public int getNumeroDadosIguais() {
    return this.numeroDadosIguais;
  }
  public void setNumeroDadosIguais(int ndi) {
    this.numeroDadosIguais = ndi;
  }

  public int getPosicaoTabuleiro() {
    return this.posicaoTabuleiro;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public void setSaldo(double novoSaldo) {
    this.saldo = novoSaldo;
  }

  public int getTurnosCadeia() {
    return this.turnosNaCadeia;
  }

  public void passarTurnoEmCadeia () {
    this.turnosNaCadeia++;
  }

  public void sairDaCadeia () {
    this.turnosNaCadeia = 0;
    this.setNaCadeia(false);
  }

  
  public int checarMonopolios() {
    this.monopolios = 0;
    
    int[] cores = new int[]{0,0,0,0,0,0,0,0};
    for (Propriedade p : this.propriedades) {
      if (p instanceof Lote auxLote) {
        switch(auxLote.getCor()) {
          case "Marrom" -> cores[0]++;
          case "Azul claro" -> cores[1]++;
          case "Rosa" -> cores[2]++;
          case "Laranja" -> cores[3]++;
          case "Vermelho" -> cores[4]++;
          case "Amarelo" -> cores[5]++;
          case "Verde" -> cores[6]++;
          case "Azul" -> cores[7]++;
        }
      }
    }
    for (int i = 0; i < 8; i++) {
      if (i == 0 || i == 7){
        if (cores[i] == 2) {
          this.monopolios++;
        }
      } else {
        if (cores[i] == 3){
          this.monopolios++;
        }
      }
    }

    return this.monopolios;
    
  }
}