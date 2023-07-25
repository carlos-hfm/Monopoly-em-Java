/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Nicholas Pandelis Papadopoulos Ferreira
 */

package monopoly;
import java.lang.Math;   

public class Dado {
    private int valorDado;
    
    public int lancar(){
        this.valorDado = (int)(Math.random()*6)+1;  //Dado de 6 lados
      
        return this.valorDado;
    }

    public int getValor() {
      return this.valorDado;
    }
}
