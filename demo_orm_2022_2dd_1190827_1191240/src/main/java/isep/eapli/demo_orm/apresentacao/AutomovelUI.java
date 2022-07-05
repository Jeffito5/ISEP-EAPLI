package isep.eapli.demo_orm.apresentacao;

import isep.eapli.demo_orm.aplicacao.AutomovelController;
import isep.eapli.demo_orm.aplicacao.GrupoAutomovelController;
import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.GrupoAutomovel;

import java.util.List;

public class AutomovelUI {
    private AutomovelController automovelController;
    private GrupoAutomovelController gaController;

    public AutomovelUI(){
        automovelController=new AutomovelController();
        gaController=new GrupoAutomovelController();
    }

    public Automovel registarAutomovel() {
        lapr.project.utils.Utils.print("Será inicializado o processo de registo:");
        String matricula = lapr.project.utils.Utils.readLineFromConsole("Indique a matricula do automovel: ");
        int anoFabrico = lapr.project.utils.Utils.readIntegerFromConsole("Indique o ano de fabruico do automóvel: ");
        int anoAquisicao = lapr.project.utils.Utils.readIntegerFromConsole("Indique o ano em que o automóvel foi adquirido pela empresa: ");
        String cor = lapr.project.utils.Utils.readLineFromConsole("Indique a cor do automovel: ").trim();
        double cilindrada = Double.parseDouble(lapr.project.utils.Utils.readLineFromConsole("Indique a cilindrada do automóvel: ").trim());
        double kmsPercorrido = Double.parseDouble(lapr.project.utils.Utils.readLineFromConsole("Indique os kms percorridos pelo automóvel: ").trim());
        GrupoAutomovel grupoAutomovel= procurarGrupoAutomovelPorID();
        return automovelController.registarAutomovel(matricula,anoFabrico,anoAquisicao,cor,cilindrada,kmsPercorrido,grupoAutomovel);
    }

    private GrupoAutomovel procurarGrupoAutomovelPorID() {
        Long gaId= lapr.project.utils.Utils.readLongFromConsole("Introduza o id do Grupo do automovel");
        return gaController.procurarGrupoAutomovel(gaId);
    }

    /**String matricula, int anoFabrico, int anoAquisicao, String cor, double cilidrada, double kmsPercorrido, GrupoAutomovel grupoAutomovel*/

    public void listarAutomoveis() {
        System.out.println("Automóveis:");
        List<Automovel> finalList = automovelController.listarAutomoveis();
        for (Automovel au : finalList)
            System.out.println(au.toString());
    }

    public void procurarAutomovelPorID(long id) {
        System.out.println("Automóvel por id:");
        System.out.println(automovelController.procurarAutomovelPorID(id).toString());
    }
}
