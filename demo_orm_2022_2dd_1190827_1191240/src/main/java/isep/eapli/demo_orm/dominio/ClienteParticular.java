package isep.eapli.demo_orm.dominio;

/**
 * @author
 */
public class ClienteParticular extends Cliente {
    private String enderecoParticular;

    public ClienteParticular(String nif, String nome, String dataDeNascimento, String email) {
        super(nif, nome, dataDeNascimento, email);
    }
}
