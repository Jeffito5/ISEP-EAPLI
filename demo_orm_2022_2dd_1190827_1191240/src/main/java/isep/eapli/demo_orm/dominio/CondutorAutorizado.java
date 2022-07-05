package isep.eapli.demo_orm.dominio;

import isep.eapli.demo_orm.util.DateTime;

import javax.persistence.*;

@Entity
public class CondutorAutorizado {
    //TODO Completar os comentários da classe

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcondutor;
    /**
     *
     */
    private String dataDeNascimento;

    /**
     *
     */
    private String nome;

    /**
     *
     */
    private String endereco;

    /**
     *
     */
    private String codigoCartaDeConducao;

    /**
     *
     */
    private String validadeDaCartaDeConducao;

    /**
     *
     * @param dataDeNascimento
     * @param nome
     * @param endereco
     * @param codigoCartaDeConducao
     * @param validadeDaCartaDeConducao
     */
    public CondutorAutorizado(String dataDeNascimento, String nome, String endereco, String codigoCartaDeConducao, String validadeDaCartaDeConducao) {
        this.dataDeNascimento = dataDeNascimento;
        this.nome = nome;
        this.endereco = endereco;
        this.codigoCartaDeConducao = codigoCartaDeConducao;
        this.validadeDaCartaDeConducao = validadeDaCartaDeConducao;
    }

    /**
     *
     */
    protected CondutorAutorizado() {
    }

    /**
     *
     * @return
     */
    public String dataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     *
     * @param dataDeNascimento
     */
    public void alterarDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     *
     * @return
     */
    public String nome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void alterarNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String endereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void alterarEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public String validadeDaCartaDeConducao() {
        return validadeDaCartaDeConducao;
    }

    /**
     *
     * @return
     */
    public String codigoCartaDeConducao(){
        return this.codigoCartaDeConducao;
    }

    /**
     *
     * @param validadeDaCartaDeConducao
     */
    public void alterarValidadeDaCartaDeConducao(String validadeDaCartaDeConducao) {
        this.validadeDaCartaDeConducao = validadeDaCartaDeConducao;
    }

    @Override
    public String toString() {
        return "CondutorAutorizado{" +
                "idcondutor=" + idcondutor +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", codigoCartaDeConducao='" + codigoCartaDeConducao + '\'' +
                ", validadeDaCartaDeConducao='" + validadeDaCartaDeConducao + '\'' +
                '}';
    }
}
