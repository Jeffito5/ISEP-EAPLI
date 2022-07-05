package isep.eapli.demo_orm.dominio;

import isep.eapli.demo_orm.dominio.GrupoAutomovel;
import isep.eapli.demo_orm.exceptions.CorInvalidoException;
import isep.eapli.demo_orm.exceptions.GrupoAutomovelInvalidoException;

import javax.persistence.*;

@Entity
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * A matrcula do automóvel.
     */
    private String matricula;

    /**
     * O ano de fabrico do automóvel.
     */
    private int anoFabrico;

    /**
     * O ano de aquisição do veículo pela empresa.
     */
    private int anoAquisicaoEmpresa;

    /**
     * A cor do automóvel.
     */
    private String cor;

    /**
     * A cilidrada de do automóvel.
     */
    private double cilindrada;

    /**
     * Os kms percorridos pelo carro.
     */
    private double kmsPecorrido;

    /**
     * O grupo à que o automóvel está inserido.
     */
    @ManyToOne
    @JoinColumn(name = "IDGRUPOAUTOMOVEL")
    private GrupoAutomovel grupoAutomovel;

    /**
     * A cor do veículo caso não for especificado.
     */
    @Transient
    private final String COR_POR_OMISSAO="preto";

    /**
     * Os kms do automóvel caso não for especificado.
     */
    @Transient
    private final double KMS_PERCORIDDO_POR_OMISSAO =0.0;

    public GrupoAutomovel getGrupoAutomovel() {
        return grupoAutomovel;
    }

    protected Automovel(){}

    /**
     * Construtor caso todas as carateriscas forem especificadas.
     *
     * @param matricula do automóvel.
     * @param anoFabrico do automóvel.
     * @param anoAquesicaoEmpresa, o ano de aquisição do automóvel pela empresa.
     * @param cor do automóvel.
     * @param cilindrada do automóvel.
     * @param kmsPercorrido pelo do automóvel, indicado no radar.
     * @param grupoAutomovel que o automóvel faz.
     */
    public Automovel(String matricula, int anoFabrico, int anoAquesicaoEmpresa, String cor, double cilindrada, double kmsPercorrido, GrupoAutomovel grupoAutomovel){
        this.matricula=matricula;
        this.anoFabrico=anoFabrico;
        this.anoAquisicaoEmpresa=anoAquesicaoEmpresa;
        this.cor=cor;
        this.cilindrada=cilindrada;
        this.grupoAutomovel=grupoAutomovel;
        this.kmsPecorrido=kmsPercorrido;
    }

    /**
     * Construtor caso Kms percorrido não for especificado.
     *
     * @param matricula do automóvel.
     * @param anoFabrico do automóvel.
     * @param anoAquesicaoEmpresa, o ano de aquisição do automóvel pela empresa.
     * @param cor do automóvel.
     * @param cilindrada do automóvel.
     * @param grupoAutomovel que o automóvel faz.
     */
    public Automovel(String matricula, int anoFabrico, int anoAquesicaoEmpresa, String cor, double cilindrada, GrupoAutomovel grupoAutomovel){
        this.matricula=matricula;
        this.anoFabrico=anoFabrico;
        this.anoAquisicaoEmpresa=anoAquesicaoEmpresa;
        this.cor=cor;
        this.cilindrada=cilindrada;
        this.grupoAutomovel=grupoAutomovel;
        this.kmsPecorrido= KMS_PERCORIDDO_POR_OMISSAO;
    }

    /**
     * Construtor caso Kms percorridos nem cor não forem especificados.
     *
     * @param matricula do automóvel.
     * @param anoFabrico do automóvel.
     * @param anoAquesicaoEmpresa, o ano de aquisição do automóvel pela empresa.
     * @param cilindrada do automóvel.
     * @param grupoAutomovel que o automóvel faz.
     */
    public Automovel(String matricula, int anoFabrico, int anoAquesicaoEmpresa, double cilindrada, GrupoAutomovel grupoAutomovel){
        this.matricula=matricula;
        this.anoFabrico=anoFabrico;
        this.anoAquisicaoEmpresa=anoAquesicaoEmpresa;
        this.cor=COR_POR_OMISSAO;
        this.cilindrada=cilindrada;
        this.grupoAutomovel=grupoAutomovel;
        this.kmsPecorrido= KMS_PERCORIDDO_POR_OMISSAO;
    }

    /**
     * Retorna a cilidrada do automóvel.
     * @return cilidrada.
     */
    public double cilidrada(){
        return this.cilindrada;
    }

    /**
     * Retorna o ano de fabrico do automóvel
     *
     * @return anoFabrico.
     */
    public int anoFabrico(){
        return this.anoFabrico;
    }

    /**
     * Retorn o ano que o automóvel fora adquirido pela empresa.
     * @return anoAquisicaoEmpresa.
     */
    public int anoAquisicaoEmpresa(){
        return this.anoAquisicaoEmpresa;
    }

    /**
     * Retorna a cor do automóvel.
     *
     * @return cor.
     */
    public String cor(){
        return this.cor;
    }

    /**
     * Pinta o automóvel com uma nova cor.
     * @param novaCor do automóvel,
     */
    public void pintar(String novaCor){
        if (cor.equalsIgnoreCase(novaCor))
            throw new CorInvalidoException("O automóvel já se encontra com a cor indicada");
        this.cor=novaCor;
    }

    /**
     * Retorna os quilómetros percorrido pelo automóvel.
     * @return kmsPercorrido.
     */
    public double kmsPercorridos(){
        return this.kmsPecorrido;
    }

    /**
     * Retorna o grupo à qual o automóvel faz parte.
     * @return grupoAutomóvel.
     */
    public GrupoAutomovel grupo() {
        return this.grupoAutomovel;
    }

    /**
     * Retorna a matrícula do automóvel.
     * @return matricula.
     */
    public String matricula() {
        return matricula;
    }


    /**
     * Define um valor valor em relação aos quilómetros percorridos pelo automóvel.
     */
    public void alterarKmsPercorridos(double kmsPecorrido){
        this.kmsPecorrido=kmsPecorrido;
    }

    /**
     * Muda o grupo de automóvel que o automóvel faz parte..
     *
     * @param grupoAutomovel que o automóvel faz parte.
     */
    public void mudarDeGrupo(GrupoAutomovel grupoAutomovel){
        if(grupoAutomovel==null)
            throw new GrupoAutomovelInvalidoException("O grupo automóvel introduzido não pode ser nulo");
        this.grupoAutomovel=grupoAutomovel;
    }

    @Override
    public String toString() {
        return "Informações do Automovel: \n" +
                "Id:" +id+
                "\nMatricula: " + matricula  +
                "\nAno de Fabrico: " + anoFabrico +
                "\nAno de Aquisicao pela Empresa:" + anoAquisicaoEmpresa +
                "\nCor: " + cor +
                "\nCilindrada: " + cilindrada +
                "\nKms Pecorridos: " + kmsPecorrido +
                "\nGrupo de Automovel: " + grupoAutomovel.nomeDoGrupo();
    }
}
