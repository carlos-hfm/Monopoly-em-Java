package monopoly;

/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 *
 * responsavel pela classe: todos
 */

public class Banco {

  public Banco(){

  }

  public void pagarJogador(Jogador jog1, double dinheiro) {
    jog1.setSaldo(jog1.getSaldo() + dinheiro);
  }

  public boolean receberDoJogador(Jogador jog1, double dinheiro) {
    if(jog1.getSaldo() >= dinheiro){
      jog1.setSaldo(jog1.getSaldo() - dinheiro);

      return true;
    }

    return false;

  }

  public boolean transacaoEntreJogadores(Jogador jog1, Jogador jog2, double dinheiro) {
    if (jog2.getSaldo() >= dinheiro){
      jog1.setSaldo(jog1.getSaldo() + dinheiro);
      jog2.setSaldo(jog2.getSaldo() - dinheiro);

      return true;
    }
    else {
      return false;
    }
  }
}