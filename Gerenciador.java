/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Todos
 */

package monopoly;

import java.io.IOException;
import java.util.Scanner;

public class Gerenciador {
  public static void main(String[] args) throws Exception {
    Scanner entrada = new Scanner(System.in);
    Jogo jogo;
    int numUsuarios = 1;
    String[] nomes;
    System.out.println("Bem vindo ao Jogo Monopoly desenvolvido em Java!");
    System.out.println("Feito por: Erik, Carlos, Nicholas, Gabriel e Murillo, apenas.\n");
    System.out.println("Vamos começar!");

    do {
      try {
        System.out.println("Digite o número de jogadores (2-4):");
        numUsuarios = entrada.nextInt();

        if (numUsuarios < 2 || numUsuarios > 4)
          throw new Exception("VALOR INVALIDO DE JOGADORES");
      } catch (IOException e) {
        System.out.println("Digite apenas números.");
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Tente novamente...");

      }
    } while (numUsuarios < 2 || numUsuarios > 4);

    clearBuffer(entrada);

    System.out.println("Digite os nomes dos jogadores:");
    nomes = new String[numUsuarios];

    for (int i = 0; i < nomes.length; i++) {
      nomes[i] = entrada.nextLine();
    }

    switch (numUsuarios) {
      case 2 -> {
        jogo = new Jogo(nomes[0], nomes[1]);
        jogo.iniciarPartida();
      }
      case 3 -> {
        jogo = new Jogo(nomes[0], nomes[1], nomes[2]);
        jogo.iniciarPartida();
      }
      case 4 -> {
        jogo = new Jogo(nomes[0], nomes[1], nomes[2], nomes[3]);
        jogo.iniciarPartida();
      }
      default -> {
      }
    }
  }

  private static void clearBuffer(Scanner scanner) {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }
}