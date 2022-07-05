package isep.eapli.demo_orm.exceptions;

public class CorInvalidoException extends IllegalArgumentException{
    public CorInvalidoException(){
        super("A cor introduzida para a pintura não está disponivel ou não existe.");
    }

    public CorInvalidoException(String mensagem){
        super(mensagem);
    }
}
