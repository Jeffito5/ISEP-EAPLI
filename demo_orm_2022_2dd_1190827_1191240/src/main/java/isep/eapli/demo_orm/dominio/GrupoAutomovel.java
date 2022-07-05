package isep.eapli.demo_orm.dominio;

import javax.persistence.*;

/**
 * @author Luís Araújo
 */
@Entity
public class GrupoAutomovel {

    /**
     * O preço diário por omissão
     */
    @Transient
    private final double PRECO_DIARIO_POR_OMISSAO = 100.0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDGRUPOAUTOMOVEL")
    private Long idGA;
    /**
     * Atributo número de portas
     */
    private int numeroDePortas;
    /**
     * O nome do grupo de automóvel
     */
    private String nomeGrupo;
    /**
     * O preço diário do grupo de automóvel.
     */
    private double precoDiario;
    /**
     * A classe do grupo de automóvel.
     */
    private String classeGrupo;

    protected GrupoAutomovel() {
    }

    /**
     * Construtor em que todos as variaveis foram definidas.
     *
     * @param nomeGrupo,     o nome do grupo de automovel.
     * @param precoDiario    do automovél do grupo.
     * @param classeGrupo,   a classe do grupo.
     * @param numeroDePortas dos automóveis do grupo.
     */
    public GrupoAutomovel(String nomeGrupo, double precoDiario, String classeGrupo, int numeroDePortas) {
        this.nomeGrupo = nomeGrupo;
        this.precoDiario = precoDiario;
        this.classeGrupo = classeGrupo;
        this.numeroDePortas = numeroDePortas;
    }

    public GrupoAutomovel(String nomeGrupo, String classeGrupo, int numeroDePortas) {
        this.nomeGrupo = nomeGrupo;
        this.classeGrupo = classeGrupo;
        this.numeroDePortas = numeroDePortas;
    }

    /**
     * Método para modificar o número de portas
     *
     * @param numeroDePortas
     */
    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    /**
     * Retorna o nome do grupo de automóvel.
     *
     * @return nomeGrupo.
     */
    public String nomeDoGrupo() {
        return this.nomeGrupo;
    }

    /**
     * Retorna o preço diario do grupo de automóveis.
     *
     * @return precoDiario.
     */
    public double precoDiarioDoGrupo() {
        return this.precoDiario;
    }

    /**
     * Retorna a classe do grupo de automóveis.
     *
     * @return classeGrupo.
     */
    public String classeDoGrupo() {
        return this.classeGrupo;
    }

    /**
     * O número de portas do grupo de automóveis.
     *
     * @return numeroDePortas.
     */
    public int numeroPortas() {
        return this.numeroDePortas;
    }

    @Override
    public String toString() {
        return "GrupoAutomovel{" +
                "PRECO_DIARIO_POR_OMISSAO=" + PRECO_DIARIO_POR_OMISSAO +
                ", id=" + idGA +
                ", numeroDePortas=" + numeroDePortas +
                ", nomeGrupo='" + nomeGrupo + '\'' +
                ", precoDiario=" + precoDiario +
                ", classeGrupo='" + classeGrupo + '\'' +
                '}';
    }
}
