package isep.eapli.demo_orm.dominio;

/**
 * @author
 */
public class PagamentoCredito extends Pagamento {
    private String numeroDoCartao;
    private String nomeDoTitular;
    private String dataDeValidade;
    private String cvv;

    public PagamentoCredito(Long id, double valor, String dataDoPagamento, String numeroDoCartao, String nomeDoTitular, String dataDeValidade, String cvv) {
        super(id, valor, dataDoPagamento);
        this.numeroDoCartao = numeroDoCartao;
        this.nomeDoTitular = nomeDoTitular;
        this.dataDeValidade = dataDeValidade;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "PagamentoCredito{" +
                "numeroDoCartao='" + numeroDoCartao + '\'' +
                ", nomeDoTitular='" + nomeDoTitular + '\'' +
                ", dataDeValidade='" + dataDeValidade + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
