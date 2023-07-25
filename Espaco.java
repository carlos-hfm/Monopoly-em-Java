/* GRUPO:
 * Erik Gabriel Rodrigo da Silva - 801442
 * Carlos Henrique de França Marques - 802467
 * Nicholas Pandelis Papadopoulos Ferreira - 800917
 * Gabriel Evangelista Goncalves da Silva - 802791
 * Murillo Justino dos Santos - 801695
 * 
 * responsavel pela classe: Nicholas Pandelis Papadopoulos Ferreira e Carlos Henrique de França Marques
 */

package monopoly;

abstract class Espaco {
    private final NomeDoEspaco NOME;

  
    /*  RETORNOS:
     *  0 -> Operacao realiza com sucesso, sem dependecia de outra classe;
     *  -1 -> Operacao com erro;
     *  Demais valores -> Dependencia de metodos de outra classe;
    */

    public Espaco(NomeDoEspaco nome){
        this.NOME = nome;
    }
    
    // construtor que escolhe entre 2 nomes
    public Espaco(NomeDoEspaco nomeT, NomeDoEspaco nomeF, boolean qualNomeEscolher){
        if (qualNomeEscolher == true){
            this.NOME = nomeT;
        }
        else {
            this.NOME = nomeF;
        }
    }
    
    public double tarefaEspaco(Jogador j){
        return 0;
    }

    public double tarefaEspaco(Jogador j, int s){
        return 0;
    }
    
    public NomeDoEspaco getNomeDoEspaco(){
        return this.NOME;
    }

    
}