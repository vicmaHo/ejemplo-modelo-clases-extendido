package co.com.ejerciciempleadosvictor.excepciones;

public class sueldoErroneoException extends RuntimeException{ // las excepciones runtime no necesitan ser marcadas

    public sueldoErroneoException(String message) {
        super(message);
    } 
    
    
}
