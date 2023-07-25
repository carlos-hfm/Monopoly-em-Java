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

public class CartaDeDinheiro extends Carta{
    
    //todas as cartas de dinheiro possuem apenas um valor fixo atribuido
    //soh eh necessario salvar o valor em inteiro
    
    //o valor das cartas nao muda durante o jogo, eh constante
    private final int VALOR;
    
    
    public CartaDeDinheiro(EnumCarta e) {
        super(e);
        if (e.toString().compareTo(EnumCarta.COFRE_07.toString()) > 0 && e.toString().compareTo(EnumCarta.COFRE_16.toString()) < 0 || e.toString().compareTo(EnumCarta.SORTE_07.toString()) > 0 && e.toString().compareTo(EnumCarta.SORTE_16.toString()) < 0) {
            switch (e) {
                    case COFRE_08: {
                        this.VALOR = 100;
                        break;
                    }
                    case COFRE_09: {
                        this.VALOR = 10;
                        break;
                    }
                    case COFRE_10: {
                        this.VALOR = 200;
                        break;
                    }
                    case COFRE_11: {
                        this.VALOR = 25;
                        break;
                    }
                    case COFRE_12: {
                        this.VALOR = -75;
                        break;
                    }
                    case COFRE_13: {
                        this.VALOR = -100;
                        break;
                    }
                    case COFRE_14: {
                        this.VALOR = 100;
                        break;
                    }
                    case COFRE_15: {
                        this.VALOR = -45;
                        break;
                    }
                    case SORTE_08: {
                        this.VALOR = -50;
                        break;
                    }
                    case SORTE_09: {
                        this.VALOR = 75;
                        break;
                    }
                    case SORTE_10: {
                        this.VALOR = -50;
                        break;
                    }
                    case SORTE_11: {
                        this.VALOR = 100;
                        break;
                    }
                    case SORTE_12: {
                        this.VALOR = 50;
                        break;
                    }
                    case SORTE_13: {
                        this.VALOR = 150;
                        break;
                    }
                    case SORTE_14: {
                        this.VALOR = -40;
                        break;
                    }
                    case SORTE_15: {
                        this.VALOR = 200;
                        break;
                    }
                    default: {
                        this.VALOR = 0;
                    }
                }
        } else {
            this.VALOR = 0;
        }
    }
    
    public int getValor(){
        return this.VALOR;
    }
}
