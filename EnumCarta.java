package monopoly;

public enum EnumCarta {
    
    //obs: a classe de enumeracao foi mudada por Gabriel Evangelista, apenas quanto a
    //sintaxe das descricoes (para evitar caracteres errados no terminal)
    
    /* CARTAS COFRE */
    
    // Cartas de movimento
    COFRE_01("Avance para Niteroi"),
    COFRE_02("Avance para a Rua Oscar Freire"),
    COFRE_03("Avance para a Rua 25 de Marco"),
    COFRE_04("Avance para o Leblon"),
    COFRE_05("Avance 2 espacos"),
    COFRE_06("Volte 4 espacos"),
    COFRE_07("Avance para a Utilidade mais proxima"),
    
    // Cartas de dinheiro
    COFRE_08("Seu seguro de vida alcanca seu estagio mais avancado (colete $100)"),
    COFRE_09("Voce ficou em segundo lugar em um concurso de beleza (colete $10)"),
    COFRE_10("Erro bancario a seu favor (colete $200)"),
    COFRE_11("Receba $25 por seus servicos"),
    COFRE_12("Pague $75 para auxiliar na reconstrucao da cidade"),
    COFRE_13("Pague $100 ao hospital"),
    COFRE_14("Voce ganhou uma competicao de cruzadinha (colete $100)"),
    COFRE_15("Multa por alta velocidade (pague $45)"),
    
    // Carta "Vá para a cadeia"
    COFRE_16("Vah diretamente para a cadeia"),
    
    
    /* CARTAS SORTE */
    
    // Cartas de movimento
    SORTE_01("Avance para o Ponto de Partida"),
    SORTE_02("Avance para o Jardim Botanico"),
    SORTE_03("Avance para a Avenida Presidente Juscelino Kubitschek"),
    SORTE_04("Avance para a Praca da Se"),
    SORTE_05("Avance 5 espacos"),
    SORTE_06("Volte 3 espacos"),
    SORTE_07("Avance para a Estaçao de Metro mais proxima"),
    
    
    // Cartas de dinheiro
    SORTE_08("Voce foi eleito presidente do Conselho. Pague $50."),
    SORTE_09("Erro bancario a seu favor (colete $75)"),
    SORTE_10("Taxa de atendimento medico (pague $50)"),
    SORTE_11("Seu fundo bancario de Natal cresce (colete $100)"),
    SORTE_12("O Banco te paga um dividendo de $50"),
    SORTE_13("Sua sociedade de credito imobiliario cresce (colete $150)"),
    SORTE_14("Voce sofreu um acidente de transito (pague $40)"),
    SORTE_15("Eh seu aniversaio! (colete $200)"),
    
    // Carta "Vá para a cadeia"
    SORTE_16("Vah diretamente para a cadeia"),
    ;
    
    private final String descricao;

    EnumCarta(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
