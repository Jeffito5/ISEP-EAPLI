package isep.eapli.demo_orm.dominio;

import javax.persistence.*;

/**
 * @author
 */
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;

    private String dataDoPagamento;

    public Pagamento() {
    }

    public Pagamento(Long id, double valor, String dataDoPagamento) {
        this.id = id;
        this.valor = valor;
        this.dataDoPagamento = dataDoPagamento;
    }

    public Long idDoPagamento() {
        return id;
    }

    public double valorDoPagamento() {
        return valor;
    }

    public String dataDoPagamento() {
        return dataDoPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataDoPagamento='" + dataDoPagamento + '\'' +
                '}';
    }
}
