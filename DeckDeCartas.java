/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Gabriel Evangelista Goncalves da Silva
 */

package monopoly;

public class DeckDeCartas {
    
    private final int MAXCARTAS = 16;
    
    private Carta[] deck;
    //o deck funcionarah como um vetor circular, visto que nao eh necessario embaralha-lo
    //apos ser iniciado.
    private int indiceTopo;
    //tipo bool usado para verificacoes gerais de tipo de deck e inicializacao.
    private boolean temCartas;
   
    //baralho iniciado sem o tipo definido. este eh definido por outras duas funcoes,
    //e o deck nao pode ser mudado apos ser iniciado por elas.
    public DeckDeCartas() {
        this.deck = new Carta[MAXCARTAS];
        this.indiceTopo = MAXCARTAS - 1;
        this.temCartas = false;
    }
    
    //funcao especifica para decks de cofre. nao pode ser usada quando o baralho ja foi iniciado.
    public boolean fazerDeckDeCofre() {
        
        if (!this.temCartas) {
            int i = 0;

            for (EnumCarta e : EnumCarta.values()) {
                if(this.indiceTopo > 8) {
                    this.deck[this.indiceTopo] = new CartaDeMovimento(e);
                    i++;
                    this.indiceTopo--;
                } else if (this.indiceTopo > 0) {
                    this.deck[this.indiceTopo] = new CartaDeDinheiro(e);
                    i++;
                    this.indiceTopo--;
                } else if (this.indiceTopo == 0){
                    this.deck[this.indiceTopo] = new CartaVaParaCadeia();
                    this.temCartas = true;
                    i++;
                }
                if (i >= 16) {
                    break;
                }
            }

            this.embaralhaDeck();
            return true;
        }
        return false;
    }
    
    //funcao especifica para decks de sorte. nao pode ser usada quando o baralho ja foi iniciado.
    public boolean fazerDeckDeSorte() {
        
        if (!this.temCartas) {
            int i = 0;

            for (EnumCarta e : EnumCarta.values()) {
                if (i <= 15) {
                    i++;
                    continue;
                }
                
                if(this.indiceTopo > 8) {
                    this.deck[this.indiceTopo] = new CartaDeMovimento(e);
                    i++;
                    this.indiceTopo--;
                } else if (this.indiceTopo > 0) {
                    this.deck[this.indiceTopo] = new CartaDeDinheiro(e);
                    i++;
                    this.indiceTopo--;
                } else if (this.indiceTopo == 0){
                    this.deck[this.indiceTopo] = new CartaVaParaCadeia();
                    this.temCartas = true;
                    i++;
                }
            }

            this.embaralhaDeck();
            return true;
        }
        return false;
    }
    
    //funcao padrao para retirar uma carta do topo. como a carta do deck sempre
    //deve ser retirada do topo e retornada ao final, o topo eh imediatamente atualizado
    //apos o get.
    public Carta getCartaDoTopo() {
        if (this.temCartas) {
            int aux = this.indiceTopo;
            this.indiceTopo = (this.indiceTopo + 1) % MAXCARTAS;
            if (this.indiceTopo == 0) {
              Carta auxCarta = this.deck[aux];
              this.embaralhaDeck();
              return auxCarta;
            }
            return this.deck[aux];
        } else {
            return null;
        }
    }
    
    //as funcoes embaralhaDeck e swapCarta sao criadas para evitar redundancia no codigo.
    
    private boolean embaralhaDeck() {
        if (this.temCartas) {
            int i, j;
            for (int k = 0; k <  MAXCARTAS * 2; k++) {
                i = (int)(Math.random()*MAXCARTAS);
                j = (int)(Math.random()*MAXCARTAS);
                this.swapCarta(i,j);
            }
            return true;
        }
        return false;
    }
    
    private boolean swapCarta(int i, int j) {
        if (i <  MAXCARTAS && j <  MAXCARTAS) {
            Carta aux = this.deck[i];
            this.deck[i] = this.deck[j];
            this.deck[j] = aux;
            return true;
        }
        return false;
    }

    public Carta[] getDeck() {
      return this.deck;
    }
}
