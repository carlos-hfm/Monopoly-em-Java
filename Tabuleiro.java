/** GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Murillo Justino
 */

package monopoly;

public class Tabuleiro {

  // atributos
  private Espaco espacos[];

  // construtor
  public Tabuleiro() {

    espacos = new Espaco[40];

    this.espacos[0] = new PontoDePartida();
    this.espacos[1] = new Lote(60, "Marrom", 2, 50, 10, NomeDoEspaco.AV_SUMARE);
    this.espacos[2] = new EspacoDeCarta(true);
    this.espacos[3] = new Lote(60, "Marrom", 2, 50, 20, NomeDoEspaco.PRACA_SE);
    this.espacos[4] = new ImpostoDeRenda();
    this.espacos[5] = new EstacaoDeMetro(200, NomeDoEspaco.METRO_MARACANA);
    this.espacos[6] = new Lote(100, "Azul claro", 6, 50, 30, NomeDoEspaco.RUA_25_MARCO);
    this.espacos[7] = new EspacoDeCarta(false);
    this.espacos[8] = new Lote(100, "Azul claro", 6, 50, 30, NomeDoEspaco.AV_SAO_JOAO);
    this.espacos[9] = new Lote(120, "Azul claro", 8, 50, 40, NomeDoEspaco.AV_PAULISTA);
    this.espacos[10] = new Cadeia();
    this.espacos[11] = new Lote(140, "Rosa", 10, 100, 50, NomeDoEspaco.AV_VIEIRA_SOUTO);
    this.espacos[12] = new Utilidade(150, NomeDoEspaco.COMP_ELETRICA);
    this.espacos[13] = new Lote(140, "Rosa", 10, 100, 50, NomeDoEspaco.NITEROI);
    this.espacos[14] = new Lote(160, "Rosa", 12, 100, 60, NomeDoEspaco.AV_ATLANTICA);
    this.espacos[15] = new EstacaoDeMetro(200, NomeDoEspaco.METRO_CARIOCA);
    this.espacos[16] = new Lote(180, "Laranja", 14, 100, 70, NomeDoEspaco.AV_PRES_JUSCELINO);
    this.espacos[17] = new EspacoDeCarta(true);
    this.espacos[18] = new Lote(180, "Laranja", 14, 100, 70, NomeDoEspaco.AV_ENG_LUIS);
    this.espacos[19] = new Lote(200, "Laranja", 16, 100, 80, NomeDoEspaco.AV_BRIGADEIRO);
    this.espacos[20] = new EstacionamentoGratis();
    this.espacos[21] = new Lote(220, "Vermelho", 18, 150, 90, NomeDoEspaco.IPANEMA);
    this.espacos[22] = new EspacoDeCarta(false);
    this.espacos[23] = new Lote(220, "Vermelho", 18, 150, 90, NomeDoEspaco.LEBLON);
    this.espacos[24] = new Lote(240, "Vermelho", 20, 150, 100, NomeDoEspaco.COPACABANA);
    this.espacos[25] = new EstacaoDeMetro(200, NomeDoEspaco.METRO_CONSOLACAO);
    this.espacos[26] = new Lote(260, "Amarelo", 22, 150, 110, NomeDoEspaco.AV_CIDADE_JARDIM);
    this.espacos[27] = new Lote(260, "Amarelo", 22, 150, 110, NomeDoEspaco.PACAEMBU);
    this.espacos[28] = new Utilidade(150, NomeDoEspaco.COMP_AGUA);
    this.espacos[29] = new Lote(280, "Amarelo", 24, 150, 120, NomeDoEspaco.IBIRAPUERA);
    this.espacos[30] = new VaParaCadeia();
    this.espacos[31] = new Lote(300, "Verde", 26, 200, 130, NomeDoEspaco.BARRA_DA_TIJUCA);
    this.espacos[32] = new Lote(300, "Verde", 26, 200, 130, NomeDoEspaco.JARDIM_BOTANICO);
    this.espacos[33] = new EspacoDeCarta(true);
    this.espacos[34] = new Lote(320, "Verde", 28, 200, 150, NomeDoEspaco.LAGOA_RODRIGO);
    this.espacos[35] = new EstacaoDeMetro(200, NomeDoEspaco.METRO_REPUBLICA);
    this.espacos[36] = new EspacoDeCarta(false);
    this.espacos[37] = new Lote(350, "Azul", 35, 200, 175, NomeDoEspaco.AV_MORUMBI);
    this.espacos[38] = new TaxaDeRiqueza();
    this.espacos[39] = new Lote(400, "Azul", 50, 200, 200, NomeDoEspaco.RUA_OSCAR_FREIRE);

  }

  public Espaco andar(Jogador j, int valor) {
    
    int novaPosicao = j.getPosicaoTabuleiro() + valor;

    if ((novaPosicao > 39) && (valor > 0)) {
      novaPosicao = novaPosicao - 40;
      j.setPosicao(novaPosicao);
      espacos[0].tarefaEspaco(j);// DEVE SER EXECUTADO AQUI MESMO?
      return espacos[novaPosicao];
    } 
    else if ((novaPosicao < 0) && (valor < 0)) {
      novaPosicao = novaPosicao + 40;
      j.setPosicao(novaPosicao);
      return espacos[novaPosicao];
    } else {
      j.setPosicao(novaPosicao);
      return espacos[novaPosicao];
    }
    
  }

  public Espaco movimentoCartaVaParaCadeia(Jogador j) {
    j.setPosicao(10);
    return espacos[10];
  }

  public Espaco paraEspaco(Jogador j, CartaDeMovimento carta) {

    if (carta.getMovimento() != 0) {
      this.andar(j, carta.getMovimento());
    }
    else if (carta.getDescricao().equals(EnumCarta.COFRE_01.getDescricao()))
      j.setPosicao(13);
    else if (carta.getDescricao().equals(EnumCarta.COFRE_02.getDescricao()))
      j.setPosicao(39);
    else if (carta.getDescricao().equals(EnumCarta.COFRE_03.getDescricao()))
      j.setPosicao(6);
    else if (carta.getDescricao().equals(EnumCarta.COFRE_04.getDescricao()))
      j.setPosicao(23);
    else if (carta.getDescricao().equals(EnumCarta.COFRE_07.getDescricao())) {

      int auxPos = j.getPosicaoTabuleiro();
      if (auxPos == 2 || auxPos == 17) {
        j.setPosicao(12);
      }
      else {
        j.setPosicao(28);
      }
      
    }

    else if (carta.getDescricao().equals(EnumCarta.SORTE_01.getDescricao()))
      j.setPosicao(0);
    else if (carta.getDescricao().equals(EnumCarta.SORTE_02.getDescricao()))
      j.setPosicao(32);
    else if (carta.getDescricao().equals(EnumCarta.SORTE_03.getDescricao()))
      j.setPosicao(16);
    else if (carta.getDescricao().equals(EnumCarta.SORTE_04.getDescricao()))
      j.setPosicao(3);
    else if (carta.getDescricao().equals(EnumCarta.SORTE_07.getDescricao())) {

      int auxPos = j.getPosicaoTabuleiro();
      if (auxPos == 7) {
        j.setPosicao(5);
      }
      else if (auxPos == 22) {
        j.setPosicao(25);
      }
      else {
        j.setPosicao(35);
      }
      
    }
    
    return espacos[j.getPosicaoTabuleiro()];
  }

  public Espaco getEspacoTabuleiro(int index) {
    return this.espacos[index];
  }

}