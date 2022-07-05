package isep.eapli.demo_orm.dominio;

/**
 * @author
 */
public class PagamentoCheque extends Pagamento {
    private String numeroDoCheque;
    private String nomeDoTitular;
    private String dataDeValidade;
    private String dataDeCriacao;

    public PagamentoCheque(Long id, double valor, String dataDoPagamento, String numeroDoCheque, String nomeDoTitular, String dataDeValidade, String dataDeCriacao) {
        super(id, valor, dataDoPagamento);
        this.numeroDoCheque = numeroDoCheque;
        this.nomeDoTitular = nomeDoTitular;
        this.dataDeValidade = dataDeValidade;
        this.dataDeCriacao = dataDeCriacao;
    }

    @Override
    public String toString() {
        return "PagamentoCheque{" +
                "numeroDoCheque='" + numeroDoCheque + '\'' +
                ", nomeDoTitular='" + nomeDoTitular + '\'' +
                ", dataDeValidade='" + dataDeValidade + '\'' +
                ", dataDeCriacao='" + dataDeCriacao + '\'' +
                '}';
    }
}
