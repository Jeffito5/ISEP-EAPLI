package isep.eapli.demo_orm.dominio;

import isep.eapli.demo_orm.util.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * @author
 */
@Entity
public class Cliente {
    @Id
    private String nif;

    /**
     * Nome do cliente
     */
    private String nome;

    /**
     * Data de nascimento do cliente
     */
    private String dataDeNascimento;
    /**
     * Email do cliente
     */
    private String email;

    /**
     *
     * @param nif
     * @param nome
     * @param dataDeNascimento
     * @param email
     */
    public Cliente(String nif, String nome, String dataDeNascimento, String email) {
        this.nif = nif;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
    }

    /**
     *
     */
    protected Cliente() {
    }

    public String nome() {
        return nome;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public String dataDeNascimento() {
        return dataDeNascimento;
    }

    public void alterarDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String email() {
        return email;
    }

    public void alterarEmail(String email) {
        this.email = email;
    }

    public String nif(){
        return this.nif;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif='" + nif + '\'' +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
