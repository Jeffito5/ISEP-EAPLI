package isep.eapli.demo_orm;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.GrupoAutomovel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutomovelTest {
    Automovel auto1;
    GrupoAutomovel ga;
    @BeforeEach
    void setUp() {
        ga=new GrupoAutomovel("Grupo Pobre",25,"Pobre",4);
        auto1= new Automovel("AA-25-BB",1999,2005,"Azul",100.2,ga);
    }

    @Test
    void cilidrada() {
        double cilidradaEsperada=100.2;
        assertEquals(cilidradaEsperada,auto1.cilidrada(),"As cilidradas não se coincidem.");
    }

    @Test
    void anoFabrico() {
        int anoFabricoEsperado=1999;
        assertEquals(anoFabricoEsperado, auto1.anoFabrico(),"Os anos de frabrico não coincidem.");
    }

    @Test
    void anoAquisicaoEmpresa() {
        int anoAquisicao=2005;
        assertEquals(anoAquisicao, auto1.anoAquisicaoEmpresa(),"Os anos de aquisição não coincidem.");
    }

    @Test
    void cor() {
        String corEsperado="Azul";
        assertEquals(corEsperado,auto1.cor(),"As cores não se coincidem.");
    }

    @Test
    void pintar() {
        String corEsperado1="Azul";
        assertEquals(corEsperado1,auto1.cor(),"As cores não se coincidem.");
        String corEsperado2="Vermelho";
        auto1.pintar("Vermelho");
        assertEquals(corEsperado2,auto1.cor(),"As cores não se coincidem.");
    }

    @Test
    void kmsPercorridos() {
        double kmsExperado=0.0;
        assertEquals(kmsExperado,auto1.kmsPercorridos(),"Os kms percorridos não coincidem.");
    }

    @Test
    void grupo() {
        GrupoAutomovel grupoAutomovelEsperado=ga;
        assertEquals(grupoAutomovelEsperado,auto1.grupo());
    }

    @Test
    void matricula() {
        String matriculaEsperada="AA-25-BB";
        assertEquals(matriculaEsperada,auto1.matricula(),"As matriculas não se coincidem.");
    }

    @Test
    void alterarKmsPercorridos() {
        double kmsEsperado=10.0;
        auto1.alterarKmsPercorridos(10);
        assertEquals(kmsEsperado,auto1.kmsPercorridos(),"Os kms percorridos não foram alterados.");
    }

    @Test
    void mudarDeGrupo() {
        GrupoAutomovel grupoAutomovelEsperado1=ga;
        assertEquals(grupoAutomovelEsperado1,auto1.grupo());
        GrupoAutomovel grupoAutomovelEsperado2=new GrupoAutomovel("Grupo Mais Pobre", 12.5,"Super Pobre",3);
        auto1.mudarDeGrupo(grupoAutomovelEsperado2);
        assertEquals(grupoAutomovelEsperado2,auto1.grupo(),"O grupo não fora alterado.");
    }

    @Test
    void testToString() {
        System.out.println(auto1);
    }
}