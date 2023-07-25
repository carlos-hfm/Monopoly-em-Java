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

public class CartaDeMovimento extends Carta{
    
    // ha tres tipos de cartas de movimento: movimento fixo, movimento a um ponto determinado
    // e movimento ate um ponto de um certo tipo. como atributos, tratar apenas valor, 
    // com o valor 0 indicando os tipos alem do valor fixo de movimento, que devem ser
    // tratadas a partir da descrição
    
    
    // o movimento é constante, não muda durante o uso das cartas
    private final int MOVIMENTO;
    
    
    public CartaDeMovimento(EnumCarta e) {
        super(e);
        if (e.toString().compareTo(EnumCarta.COFRE_08.toString()) < 0 || (e.toString().compareTo(EnumCarta.COFRE_16.toString()) > 0 && e.toString().compareTo(EnumCarta.SORTE_16.toString()) < 0)) {
            if ((e.toString().equals(EnumCarta.COFRE_05.toString()) || e.toString().equals(EnumCarta.COFRE_06.toString()) || e.toString().equals(EnumCarta.SORTE_05.toString()) || e.toString().equals(EnumCarta.SORTE_06.toString()))) {
                switch (e) {
                    case COFRE_05: {
                        this.MOVIMENTO = 2;
                        break;
                    }
                    case COFRE_06: {
                        this.MOVIMENTO = -4;
                        break;
                    }
                    case SORTE_05: {
                        this.MOVIMENTO = 5;
                        break;
                    }
                    case SORTE_06: {
                        this.MOVIMENTO = -3;
                        break;
                    }
                    default: {
                        this.MOVIMENTO = 0;
                    }
                }
            } else {
                this.MOVIMENTO = 0;
            }
        } else {
            this.MOVIMENTO = 0;
        }
    }
    
    public int getMovimento() {
        return this.MOVIMENTO;
    }
    
}
