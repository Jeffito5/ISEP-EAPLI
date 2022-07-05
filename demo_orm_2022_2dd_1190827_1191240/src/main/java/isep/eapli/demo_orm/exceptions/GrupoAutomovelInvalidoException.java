package isep.eapli.demo_orm.exceptions;

public class GrupoAutomovelInvalidoException extends IllegalArgumentException{
    public GrupoAutomovelInvalidoException(){
        super("O grupo de automóvel indicado não é válido.");
    }

    public GrupoAutomovelInvalidoException(String mensagem){
        super(mensagem);
    }
}
