package isep.eapli.demo_orm.dominio;

/**
 * @author
 */
public class ClienteEmpresa extends Cliente {
    private String enderecoEmpresa;

    public ClienteEmpresa(String nif, String nome, String dataDeNascimento, String email) {
        super(nif, nome, dataDeNascimento, email);
    }
}
