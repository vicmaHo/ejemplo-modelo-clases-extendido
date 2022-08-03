package co.com.ejerciciempleadosvictor.modelo;

import co.com.ejerciciempleadosvictor.excepciones.telefonoErroneoException;

public class Cliente extends Persona{
    private String telefono;

    
    

    // Metodo constructor
    public Cliente(String nombre, Integer edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }


    // agrego una excepcion 
    // como es posible modificar el telefono, entonces podemos usar un setter para dar pie a la posterior modificacion de este atributo
    public void setTelefono(String telefono) throws telefonoErroneoException{
        if (telefono == null || telefono.isEmpty()) { // en caso de que el telefono sea una cadena vacia o un valor nulo, no se modificara
            throw new telefonoErroneoException(); // dentro lanzo la excepcion en casi de que suceda
        } else {
            this.telefono = telefono;
        }
        
    }

    // Getters
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void mostrar() {
        System.out.printf("Cliente--> Nombre: %s\tEdad: %d\tTelefono: %s %n", getNombre(),getEdad(), telefono);
    }

    
}
