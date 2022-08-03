package co.com.ejerciciempleadosvictor.modelo;

public abstract class Persona { // persona sera una clase abstracta
    // sirve para declarar ciertos metodo pero no la implementacion de estos metodos
    // almenos uno de los metodos debe ser abstracto
    // Atributos
    private String nombre; // debido al encapsulamiento, lo mejor es dejar todos los atributos en private
    private Integer edad;


    // Constructor - es un metodo especial para crear e inicializar un objeto creado a partir de una clase
    public Persona(String nombre, Integer edad) {
        // tengo que asiganar los valores que mandan al constructor a la clase
        this.nombre = nombre;  // this hace referencia a la clase, 
        this.edad = edad;// el this sirve si hay variables de una funcion con el mismo nombre del atributo para poder organizarlos bien
    }

    // ya que no podemos iinteractuar dirctamente con los atributos debido al encapsulamiento
    // usaremos metodos para ello
    // Getters se encarga de mostrar un atributo de un objeto el cual esta encapsulado
    public Integer getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }

    // Metodos
    public abstract void mostrar(); 

}
