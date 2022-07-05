package isep.eapli.demo_orm.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ContratoAluguer {

    //TODO Completar os comentários da classe

    /**
     * O id do contrato de aluguer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContrato;

    /**
     * O tempo de calidade de contrato.
     */
    private int tempoDoContrato;

    /**
     *
     */
    @OneToOne
    @JoinColumn(name = "grupo_automovel_idgrupoautomovel")
    private GrupoAutomovel grupoAutomovel;

    /**
     *
     */
    private String dataContrato;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "ClienteID")
    private Cliente cliente;

    /**
     *
     */
    @OneToOne
    @JoinColumn(name = "automovel_id")
    private Automovel automovel;

    /**
     *
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<CondutorAutorizado> condutoresAutorizados = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    /**
     *
     */
    protected ContratoAluguer() {
    }

    /**
     * @param tempoDoContrato
     * @param automovel
     * @param grupoAutomovel
     * @param cliente
     */
    public ContratoAluguer(int tempoDoContrato, Automovel automovel, GrupoAutomovel grupoAutomovel, Cliente cliente) {
        this.tempoDoContrato = tempoDoContrato;
        this.grupoAutomovel = grupoAutomovel;
        this.automovel = automovel;
        this.cliente = cliente;
    }

    public Pagamento pagamento() {
        return pagamento;
    }

    public Long idContrato() {
        return idContrato;
    }

    /**
     * @return
     */
    public double calcularTotalAPagar() {
        return grupoAutomovel.precoDiarioDoGrupo() * tempoDoContrato;
    }

    /**
     * @return
     */
    public Cliente cliente() {
        return this.cliente;
    }

    /**
     * @return
     */
    public String dataDoContratd() {
        return this.dataContrato;
    }

    /**
     * @return
     */
    public Automovel automovel() {
        return automovel;
    }

    /**
     * @return
     */
    public GrupoAutomovel grupoAutomovel() {
        return grupoAutomovel;
    }

    /**
     * @return
     */
    public boolean temCondutoresAutorizados() {
        return condutoresAutorizados.isEmpty();
    }

    /**
     * @param condutorAutorizado
     * @return
     */
    public boolean adicionarCondutorAutorizador(CondutorAutorizado condutorAutorizado) {
        return condutoresAutorizados.add(condutorAutorizado);
    }

    @Override
    public String toString() {
        return "ContratoAluguer{" +
                "idContrato=" + idContrato +
                ", tempoDoContrato=" + tempoDoContrato +
                ", grupoAutomovel=" + grupoAutomovel.nomeDoGrupo() +
                ", dataContrato='" + dataContrato + '\'' +
                ", cliente=" + cliente.nome() +
                ", automovel=" + automovel.matricula() +
                ", condutoresAutorizados=" + condutoresAutorizados.toString() +
                '}';
    }
}
