package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;

/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 *
 * responsável pela classe: todos
 */

public class Jogo {
  private int jogadorTurno;
  private int totalJogadores;
  private ArrayList<Jogador> jogadores;
  private Tabuleiro tabuleiro;
  private Dado[] dados;
  private Banco banco;
  private DeckDeCartas cofre;
  private DeckDeCartas sorte;
  private Scanner sc = new Scanner(System.in);

  // CONSTRUTORES - para 2, 3 e 4 jogadores
  public Jogo(String jog1, String jog2) {
    jogadores = new ArrayList<>();
    this.jogadores.add(new Jogador(jog1));
    this.jogadores.add(new Jogador(jog2));
    Collections.shuffle(jogadores);

    this.totalJogadores = 2;
    this.jogadorTurno = 0;
    this.tabuleiro = new Tabuleiro();
    this.cofre = new DeckDeCartas();
    this.cofre.fazerDeckDeCofre();
    this.sorte = new DeckDeCartas();
    this.cofre.fazerDeckDeSorte();
    this.banco = new Banco();

    dados = new Dado[2];
    this.dados[0] = new Dado();
    this.dados[1] = new Dado();

    System.out.printf("Novo jogo criado com dois jogadores: %s(1) e %s(2)\n", jogadores.get(0).getNome(),
            jogadores.get(1).getNome());
  }

  public Jogo(String jog1, String jog2, String jog3) {
    jogadores = new ArrayList<>();
    this.jogadores.add(new Jogador(jog1));
    this.jogadores.add(new Jogador(jog2));
    this.jogadores.add(new Jogador(jog3));
    Collections.shuffle(jogadores);

    this.totalJogadores = 3;
    this.jogadorTurno = 0;
    this.tabuleiro = new Tabuleiro();
    this.cofre = new DeckDeCartas();
    this.cofre.fazerDeckDeCofre();
    this.sorte = new DeckDeCartas();
    this.cofre.fazerDeckDeSorte();
    this.banco = new Banco();

    dados = new Dado[2];
    this.dados[0] = new Dado();
    this.dados[1] = new Dado();

    System.out.printf("Novo jogo criado com tres jogadores: %s(1), %s(2) e %s(3)\n", jogadores.get(0).getNome(),
            jogadores.get(1).getNome(), jogadores.get(2).getNome());

  }

  public Jogo(String jog1, String jog2, String jog3, String jog4) {
    jogadores = new ArrayList<>();
    this.jogadores.add(new Jogador(jog1));
    this.jogadores.add(new Jogador(jog2));
    this.jogadores.add(new Jogador(jog3));
    this.jogadores.add(new Jogador(jog4));
    Collections.shuffle(jogadores);

    this.totalJogadores = 4;
    this.jogadorTurno = 0;
    this.tabuleiro = new Tabuleiro();
    this.cofre = new DeckDeCartas();
    this.cofre.fazerDeckDeCofre();
    this.sorte = new DeckDeCartas();
    this.cofre.fazerDeckDeSorte();
    this.banco = new Banco();

    dados = new Dado[2];
    this.dados[0] = new Dado();
    this.dados[1] = new Dado();

    System.out.printf("Novo jogo criado com quatro jogadores: %s(1), %s(2), %s(3) e %s(4)\n",
            jogadores.get(0).getNome(), jogadores.get(1).getNome(), jogadores.get(2).getNome(), jogadores.get(3).getNome());
  }

  // METODOS

  public void iniciarPartida() throws Exception {
    while (!checarVitoria()) {
      realizarTurno();
    }
    
  }

  private void realizarTurno() throws Exception {

    Jogador j = this.jogadores.get(this.jogadorTurno % this.totalJogadores);
    this.jogadorTurno++;

    Jogador quemDeve = null; // ver se jogador deve ao banco (0) ou outro jogador (1-4)

    Carta cartaRetirada;

    int escolha = 0;
    int valorDado1;
    int valorDado2;

    System.out.println("Agora é a vez de: " + j.getNome());
    System.out.println("Saldo atual: $" + j.getSaldo());

    // se o jogador estiver na cadeia (preso)
    if (j.getNaCadeia()) {
      if (saidaCadeia(j)) {
        valorDado1 = this.dados[0].getValor();
        valorDado2 = this.dados[1].getValor();
        j.sairDaCadeia();
      } else {
        return;
      }
    } else {
      if (j.getPropriedades().size() > 0) {
        System.out.println("Deseja ver suas propriedades? Sim(digite 1) ou nao(digite 2)?");
        do {
          try {
            escolha = sc.nextInt();
            if (escolha <= 0 || escolha >= 3)
              throw new Exception("Escolha inválida!!");
          } catch (IOException e) {
            System.out.println("Digite apenas números.");
            sc.nextLine();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        } while (escolha <= 0 || escolha >= 3);
        if (escolha == 1) {
          System.out.println("Suas propriedades: (nome da propriedade : cor da propriedade)");
          for (Propriedade p : j.getPropriedades()) {
            if (p instanceof Lote auxLote) {
              System.out.println(auxLote.getNomeDoEspaco() + " : " + auxLote.getCor());
            } else {
                System.out.println(p.getNomeDoEspaco() + " : não possui cor");
            }
          }
        }
      } else {
        System.out.println("Você não possui propriedades ainda!");
      }
      
      negociacao(j);
      
      System.out.println("Lançando os dados...");
      valorDado1 = this.dados[0].lancar();
      valorDado2 = this.dados[1].lancar();
      System.out.printf("Resultado dos dados: %d e %d\n", valorDado1, valorDado2);
    }

    // o jogador tirou uma dupla nos dados
    if (valorDado1 == valorDado2) {
      // incrementa numeroDadosIguais do jogador
      int ndi = j.getNumeroDadosIguais();
      j.setNumeroDadosIguais(ndi + 1);

      // verifica se é a terceira dupla
      if (j.getNumeroDadosIguais() == 3) {
        j.setNaCadeia(true);
        j.setNumeroDadosIguais(0);
        System.out.println("Terceira dupla seguida! Você está preso!\n");
        return;// encerra imediatamente seu turno
      }

      this.jogadorTurno--;
    }

    int valorMovimento = valorDado1 + valorDado2;
    Espaco espacoQueCaiu = this.tabuleiro.andar(j, valorMovimento);

    boolean foiPago = true;

    NomeDoEspaco nomeEspaco = espacoQueCaiu.getNomeDoEspaco();

    System.out.println("Voce caiu no espaço " + nomeEspaco);

    switch (nomeEspaco) {
      case PONTO_PARTIDA:
        System.out.println("Receba $200 do banco");
        banco.pagarJogador(j, espacoQueCaiu.tarefaEspaco(j));
        break;

      case IMPOSTO:
        System.out.println("Para pagar o Imposto, você tem duas opções:");
        System.out.println("1 - Pagar uma taxa fixa de $200.");
        System.out.println("2 - Pagar um valor equivalente a 10% da sua fortuna total.");
        System.out.println("Digite a opção desejada (1 ou 2):");

        do {
          try {
            escolha = sc.nextInt();
            if (escolha <= 0 || escolha >= 3)
              throw new Exception("Escolha inválida!!");
          } catch (IOException e) {
            System.out.println("Digite apenas números.");
            sc.nextLine();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        } while (escolha <= 0 || escolha >= 3);

        foiPago = banco.receberDoJogador(j, espacoQueCaiu.tarefaEspaco(j, escolha));
        break;

      case TAXA_RIQUEZA:
        System.out.println("Pague $200 ao Banco");
        foiPago = banco.receberDoJogador(j, espacoQueCaiu.tarefaEspaco(j));
        break;

      case ESTACIONAMENTO:
        break;

      case CADEIA:
        System.out.println("Porém fique tranquilo, voce esta apenas visitando");
        break;

      case VA_PARA_CADEIA:
        System.out.println("Voce foi preso e deve ir pra cadeia");
        espacoQueCaiu.tarefaEspaco(j);
        this.jogadorTurno++;
        break;

      case COFRE:
        // acoes espaco cofre
        cartaRetirada = cofre.getCartaDoTopo();
        if (cartaRetirada instanceof CartaDeMovimento cartaM) {
          System.out.println("Voce retirou uma Carta de Movimento!");
          System.out.println(cartaM.getDescricao());
          System.out.println("Posição atual: " + tabuleiro.paraEspaco(j, cartaM).getNomeDoEspaco());
        } else if (cartaRetirada instanceof CartaDeDinheiro cartaD) {
          System.out.println("Voce retirou uma Carta de Dinheiro!");
          System.out.println(cartaD.getDescricao());
          if (cartaD.getValor() > 0) {
            banco.pagarJogador(j, cartaD.getValor());
          } else {
            foiPago = banco.receberDoJogador(j, (-1) * cartaD.getValor());
          }
        } else if (cartaRetirada instanceof CartaVaParaCadeia) {
          System.out.println("Voce retirou uma Carta de Vá para Cadeia!");
          j.setNaCadeia(true);
          tabuleiro.movimentoCartaVaParaCadeia(j);
          this.jogadorTurno++;
        }
        break;

      case SORTE:
        // acoes espaço sorte
        cartaRetirada = sorte.getCartaDoTopo();
        if (cartaRetirada instanceof CartaDeMovimento cartaM) {
          System.out.println("Voce retirou uma Carta de Movimento!");
          System.out.println(cartaM.getDescricao());
          System.out.println("Posição atual: " + tabuleiro.paraEspaco(j, cartaM).getNomeDoEspaco());
        } else if (cartaRetirada instanceof CartaDeDinheiro cartaD) {
          System.out.println("Voce retirou uma Carta de Dinheiro!");
          System.out.println(cartaD.getDescricao());
          if (cartaD.getValor() > 0) {
            banco.pagarJogador(j, cartaD.getValor());
          } else {
            foiPago = banco.receberDoJogador(j, (-1) * cartaD.getValor());
          }
        } else {
          System.out.println("Voce retirou uma Carta de Vá para Cadeia!");
          j.setNaCadeia(true);
          tabuleiro.movimentoCartaVaParaCadeia(j);
          this.jogadorTurno++;
        }
        break;

      default: // Ações para propriedade
        if (espacoQueCaiu instanceof Propriedade propriedade) {

          if (propriedade.getComprador() == j) {
            System.out.println("Este lote pertence à você!");
            if (propriedade instanceof Lote lote) { // somente lote tem opcoes de ação nesse caso
              System.out.println("Escolha uma opção:");
              System.out.printf("1 - Comprar uma casa (Preço: $%d)\n", lote.getPrecoConstrucaoCasa());
              System.out.println("2 - Passar turno");
              System.out.println("Digite a opção desejada (1 ou 2):");

              do {
                try {
                  escolha = sc.nextInt();
                  if (escolha <= 0 || escolha >= 3)
                    throw new Exception("Escolha inválida!!");
                } catch (IOException e) {
                  System.out.println("Digite apenas números.");
                  sc.nextLine();
                } catch (Exception e) {
                  System.out.println(e.getMessage());
                }
              } while (escolha <= 0 || escolha >= 3);

              if (escolha == 1) {
                foiPago = banco.receberDoJogador(j, lote.getPrecoConstrucaoCasa());
                if (foiPago) {
                  lote.adicionarCasa();
                }
              }
            }
          } else if (propriedade.getComprador() == null) {
            if(propriedade instanceof Lote lote) {
              System.out.printf("Preço $%d | Cor: %s\n", propriedade.getPreco(), lote.getCor());
            } else {
              System.out.printf("Preço: $%d\n", propriedade.getPreco());
            }
            // verificar se jogador possui dinheiro suficiente pra comprar a propriedade

            if (j.getSaldo() >= propriedade.getPreco()) {
              System.out.println("Escolha uma opção:");
              System.out.printf("1 - Comprar a propriedade (Preço: $%d)\n", propriedade.getPreco());
              System.out.println("2 - Passar turno");
              System.out.println("Digite a opção desejada (1 ou 2):");

              do {
                try {
                  escolha = sc.nextInt();
                  if (escolha <= 0 || escolha >= 3)
                    throw new Exception("Escolha inválida!!");
                } catch (IOException e) {
                  System.out.println("Digite apenas números.");
                } catch (Exception e) {
                  System.out.println(e.getMessage());
                }
              } while (escolha <= 0 || escolha >= 3);

              if (escolha == 1) {
                foiPago = banco.receberDoJogador(j, propriedade.getPreco());
                if (foiPago) {
                  j.adicionarPropriedade(propriedade);
                }
              }
            } else {
              System.out.println("Você não tem dinheiro suficiente, passando o turno!");
            }
          } else { // se dono da propriedade é outro jogador
            // pagar aluguel
            System.out.println("Esta propriedade pertence a " + propriedade.getComprador().getNome());
            System.out.println("Pagando aluguel no valor de $" + propriedade.calcularAluguel(dados[0].getValor() + dados[1].getValor()) + "...");
            foiPago = banco.transacaoEntreJogadores(propriedade.getComprador(), j, propriedade.calcularAluguel(dados[0].getValor() + dados[1].getValor()));
            if (!foiPago) {
              quemDeve = propriedade.getComprador();
            }
          }
        }
    }// fim do switch case

    if (!foiPago) {
      eliminarJogador(j, quemDeve);
    }

    System.out.println("");
  }

  private boolean checarVitoria() {
    for (Jogador jogador : jogadores) {
      if (jogador.checarMonopolios() == 2) {
        System.out.println(jogador.getNome() + " ganhou!");
        return true;
      } else if (jogador.checarMonopolios() == 1) {
        for (Propriedade p : jogador.getPropriedades()) {
          if (p instanceof Lote auxL) {
            if (auxL.getQuantidadeCasas() >= 4) {
              System.out.println(jogador.getNome() + " ganhou!");
              return true;
            }
          }
        }
        return true;
      }
    }
    if (jogadores.size() == 1) {
      System.out.println(jogadores.get(0).getNome() + " ganhou!");
      return true;
    }

    return false;
  }

  private void eliminarJogador(Jogador j, Jogador quemDeve) { // quemDeve: null = banco / nao null = jogador que deve
    // receber as propriedades do devedor
    this.totalJogadores--;
    this.jogadorTurno--;

    ArrayList<Propriedade> propriedadesDevedor = j.getPropriedades();

    if (quemDeve == null) { // deveu para o banco
      // devolve todas as propriedades ao banco e remove construções
      for (Propriedade p : propriedadesDevedor) {
        p.setComprador(null);
        if (p instanceof Lote lote) {
          lote.removerCasas();
        }
      }
    } else { // deveu para um jogador
      ArrayList<Propriedade> propriedadesRecebedor = quemDeve.getPropriedades();
      for (Propriedade p : propriedadesDevedor) {
        p.setComprador(quemDeve);
        if (p instanceof Lote lote) {
          lote.removerCasas();
        }
        propriedadesRecebedor.add(p);

      }
    }

    jogadores.remove(j);

    System.out.println("Você não tem saldo suficiente!");
    System.out.println("Você faliu e foi eliminado do jogo.");
    if (quemDeve == null){
      System.out.println("Suas propriedades foram devolvidas ao banco");
    } else {
      System.out.println("Suas propriedades foram transferida para " + quemDeve.getNome());
    }

  }

  private boolean saidaCadeia(Jogador j) throws Exception {
    int valorDado1;
    int valorDado2;
    if (j.getTurnosCadeia() < 2) {
      System.out.println("Para sair da cadeia, deseja pagar $50(digite 1) ou tentar uma dupla com os dados(digite 2)?");
      int escolha = 0;
      while (escolha == 0) {
        try {
          escolha = sc.nextInt();
          if (escolha != 1 && escolha != 2) {
            System.out.println("Opcao invalida! Pague $50(digite 1) ou tente uma dupla(digite 2).");
            escolha = 0;
          }
        } catch (Exception e) {
          System.out.println("Opcao invalida! Pague $50(digite 1) ou tente uma dupla(digite 2).");
          escolha = 0;
        }
      }
      if (escolha == 2) {
        valorDado1 = this.dados[0].lancar();
        valorDado2 = this.dados[1].lancar();
        System.out.printf("Resultado: %d e %d\n", valorDado1, valorDado2);
        if (valorDado1 == valorDado2) {
          System.out.print("Conseguiu uma dupla! Esta livre da cadeia.\n");
          j.sairDaCadeia();
          return true;
        } else {
          j.passarTurnoEmCadeia();
          System.out.print("Nao conseguiu uma dupla. Espere a proxima rodada para tentar sair da cadeia\n");
          return false;
        }
      } else if (escolha == 1) {
        if (!banco.receberDoJogador(j, 50)) {
          System.out
                  .print("Voce nao possui dinheiro suficiente, nao pode pagar a fianca!\nDeve tentar lancar os dados.\n");
          valorDado1 = this.dados[0].lancar();
          valorDado2 = this.dados[1].lancar();
          System.out.printf("Resultado: %d e %d\n", valorDado1, valorDado2);
          if (valorDado1 == valorDado2) {
            System.out.print("Conseguiu uma dupla! Esta livre da cadeia.\n");
            j.sairDaCadeia();
            return true;
          } else {
            System.out.print("Nao conseguiu uma dupla... Deve esperar a próxima rodada.\n");
            j.passarTurnoEmCadeia();
            return false;
          }
        } else {
          System.out.print(
                  "Voce possui dinheiro suficiente, pode pagar a fianca!(-$50)\nJogue os dados para realizar seu turno fora da cadeia.\n");
          j.sairDaCadeia();
          valorDado1 = this.dados[0].lancar();
          valorDado2 = this.dados[1].lancar();
          System.out.printf("Resultado: %d e %d\n", valorDado1, valorDado2);
          return true;
        }
      }
    } else {
      System.out.println(
              "Tente uma dupla com os dados. Caso nao consiga dois numeros iguais, voce devera pagar $50 ou sera eliminado da partida!(pressione enter para continuar)");
      try {
        sc.nextLine();
      } catch (Exception e) {
        ; // solucoes 101 XD
      }
      valorDado1 = this.dados[0].lancar();
      valorDado2 = this.dados[1].lancar();
      System.out.printf("Resultado: %d e %d\n", valorDado1, valorDado2);
      if (valorDado1 == valorDado2) {
        System.out.print("Conseguiu uma dupla! Esta livre da cadeia.\n");
        j.sairDaCadeia();
        return true;
      } else {
        System.out.print("Nao conseguiu uma dupla... A saida da cadeia so eh permitida com o pagamento de $50 agora. ");
        if (!banco.receberDoJogador(j, 50)) {
          System.out.print("Voce nao possui dinheiro suficiente, esta eliminado do jogo!\n");
          eliminarJogador(j, null);
          return false;
        } else {
          System.out.print(
                  "Voce possui dinheiro suficiente, pode pagar a fianca!(-$50)\nJogue os dados para realizar seu turno fora da cadeia.\n");
          j.sairDaCadeia();
          valorDado1 = this.dados[0].lancar();
          valorDado2 = this.dados[1].lancar();
          System.out.printf("Resultado: %d e %d\n", valorDado1, valorDado2);
          return true;
        }
      }
    }
    return false;
  }

  public void negociacao(Jogador jogadorTurno) throws Exception {
    while(true) {
      int escolha = -1, valor = -1;
      Jogador auxJ;
      Propriedade novaProp;
      System.out.println("Saldo do jogador: $" + jogadorTurno.getSaldo());
  
      Espaco space;
      for (int i = 0; i < 40; i++) {
        space = tabuleiro.getEspacoTabuleiro(i);
        if (space instanceof Lote auxLote) {
          if (auxLote.getComprador() != null && auxLote.getComprador() != jogadorTurno) {
            System.out.println("Lista de propriedades de outros jogadores:");
            valor = 0;
            break;
          }
        }
      }
      if (valor == -1) {
        System.out.println("Nenhum jogador adversário possui propriedades para serem compradas.");
        return;
      }
  
      boolean[] posicoes = new boolean[41];
      posicoes[0] = true;
      for (int i = 0; i < 40; i++) {
        space = tabuleiro.getEspacoTabuleiro(i);
        if (space instanceof Lote auxLote) {
          if (auxLote.getComprador() != null && auxLote.getComprador() != jogadorTurno) {
            System.out.println("-> " + auxLote.getNomeDoEspaco() + " : Posição " + (i + 1));
            posicoes[i+1] = true;
          } else {
            posicoes[i+1] = false;
          }
        }
      }
  
      System.out.println("Deseja ofertar para alguma dessas propriedades?");
      System.out.println("(Digite 0 para não tentar negociar ou a posição da propriedade para pedir negócio)");
  
      do {
        try {
          escolha = sc.nextInt();
          if (escolha < 0 || escolha > 41 || !posicoes[escolha])
            throw new Exception("Escolha inválida!!");
        } catch (IOException e) {
          System.out.println("Digite apenas números.");
          sc.nextLine();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } while ((escolha < 0 || escolha > 41) || !posicoes[escolha]);
  
      if (escolha == 0) {
        return;
      }
        
      novaProp = (Propriedade)tabuleiro.getEspacoTabuleiro(escolha - 1);
      auxJ = novaProp.getComprador();
  
      System.out.println("Qual valor você propõe?");
      do {
        try {
          valor = sc.nextInt();
          if (valor < 0)
            throw new Exception("Escolha inválida!!");
        } catch (IOException e) {
          System.out.println("Digite apenas números.");
          sc.nextLine();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } while (valor < 0);
  
      System.out.println(auxJ.getNome() + ", aceitará a proposta?\n 1 - Sim\n 2 - Não");
      escolha = -1;
      do {
        try {
          escolha = sc.nextInt();
          if (escolha < 1 || escolha > 2)
            throw new Exception("Escolha inválida!!");
        } catch (IOException e) {
          System.out.println("Digite apenas números.");
          sc.nextLine();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } while (escolha < 1 || escolha > 2);
      if (escolha == 2) {// nao aceitou
        System.out.println("Proposta não aceita! Tente novamente.");
        continue;
      }
      
      //comprando...
      if(!banco.transacaoEntreJogadores(auxJ, jogadorTurno, valor)){
        System.out.println("Sem dinheiro...");
        continue;
      }
  
      //remove casas da propriedade
      if(novaProp instanceof Lote auxLote){
        while(auxLote.getQuantidadeCasas() != 0)
          auxLote.removerCasas();
      }
  
      jogadorTurno.checarMonopolios();
      
      auxJ.removerPropriedade(novaProp);
      
      jogadorTurno.adicionarPropriedade(novaProp);
    }
  }
}