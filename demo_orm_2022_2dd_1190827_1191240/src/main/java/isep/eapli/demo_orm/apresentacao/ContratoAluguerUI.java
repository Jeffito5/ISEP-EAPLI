package isep.eapli.demo_orm.apresentacao;

import isep.eapli.demo_orm.aplicacao.AutomovelController;
import isep.eapli.demo_orm.aplicacao.ClienteController;
import isep.eapli.demo_orm.aplicacao.ContratoAluguerController;
import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.Cliente;
import isep.eapli.demo_orm.dominio.CondutorAutorizado;
import isep.eapli.demo_orm.dominio.ContratoAluguer;
import isep.eapli.demo_orm.util.Console;

import java.util.List;

/**
 * @author
 */
public class ContratoAluguerUI {
    private final ContratoAluguerController controller = new ContratoAluguerController();
    private final AutomovelController automovelController = new AutomovelController();
    private final ClienteController clienteController = new ClienteController();

    public void registarCA() {
        System.out.println("*** Registo Contrato Aluguer ***\n");
        int tempoDeContrato = Console.readInteger("Tempo do contrato:");
        Automovel automovel = procurarAutomovelPorID();
        Cliente cliente = procurarClientePorID();
        ContratoAluguer contratoAluguer = controller.registarContratoAluguer(tempoDeContrato, automovel, automovel.grupo(), cliente);
        System.out.println("Contrato Aluguer:\n" + contratoAluguer.toString());
    }

    public void listarCAs() {
        System.out.println("Contratos aluguer:");
        List<ContratoAluguer> finalList = controller.listarContratosAluguer();
        for (ContratoAluguer ca : finalList)
            System.out.println(ca.toString());
    }

    public void procurarCAPorID(long id) {
        System.out.println("Contratos aluguer por id:");
        System.out.println(controller.procurarContratosAluguer(id).toString());
    }

    public void registarCondutorAutorizado(long id) {
        ContratoAluguer ca = controller.procurarContratosAluguer(id);
        if (ca.temCondutoresAutorizados()) {
            int number = lapr.project.utils.Utils.readIntegerFromConsole("Quantos condutores pretende adiconar?");
            while (number != 0) {
                System.out.println("Registar Condutor Autorizado:");
                String dataDeNascimento = lapr.project.utils.Utils.readLineFromConsole("Data de nascimento:");
                String nome = lapr.project.utils.Utils.readLineFromConsole("Nome:");
                String endereco = lapr.project.utils.Utils.readLineFromConsole("Endereço:");
                String codigoCartaDeConducao = lapr.project.utils.Utils.readLineFromConsole("Código da carta de condução:");
                String validadeDaCartaDeConducao = lapr.project.utils.Utils.readLineFromConsole("Validade da carta de condução:");
                CondutorAutorizado condutorAutorizado = new CondutorAutorizado(dataDeNascimento, nome, endereco, codigoCartaDeConducao, validadeDaCartaDeConducao);
                if (ca.adicionarCondutorAutorizador(condutorAutorizado)) {
                    System.out.println("Condutor Autorizado adicionado.");
                    System.out.println();
                }
                number--;
            }
            controller.atualizarContratoAluguer(ca);
        } else {
            System.out.println("Não é possível adicionar.\n");
        }
    }

    public Automovel procurarAutomovelPorID() {
        Long automovelId = lapr.project.utils.Utils.readLongFromConsole("Introduza o id do automovel");
        return automovelController.procurarAutomovelPorID(automovelId);
    }

    public Cliente procurarClientePorID() {
        String clienteId = lapr.project.utils.Utils.readLineFromConsole("Introduza o nif do cliente");
        return clienteController.procurarClientePorID(clienteId);
    }
}
