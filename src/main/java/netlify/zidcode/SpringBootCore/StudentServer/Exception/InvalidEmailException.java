package netlify.zidcode.SpringBootCore.StudentServer.Exception;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
