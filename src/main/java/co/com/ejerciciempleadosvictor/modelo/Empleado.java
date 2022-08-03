package co.com.ejerciciempleadosvictor.modelo;

import co.com.ejerciciempleadosvictor.excepciones.sueldoErroneoException;

public class Empleado extends Persona implements Comparable<Empleado> { // heredo-extiendo-generalizo de persona y ademas implemento comparable (una interfaz)
    public static final Double SALARIO_MINIMO = 1_000_000d;  // constante para el salario minimo
    // Atributos
    private Double sueldoBruto;


    // los constructores los definino segun mis necesidades, en este caso puedo crear empleados de diferentes maneras - sobrecarga
    // Metodo constructor con dos argumentos - tengo dos formas de crear un objeto, dependiendo de lo que envie
    public Empleado(String nombre, Integer edad) { 
        this(nombre, edad, SALARIO_MINIMO); // de esta manera uso this como una funcion, la cual llama a otro constructor con n parametros, redirije al otro constructor y asigne los parametros dados
        // super(nombre, edad);
        // this.sueldoBruto = 1_000_000d;
    }
    // Metodo constructor con 3 argumentos 
    public Empleado(String nombre, Integer edad, Double sueldoBruto) {
        super(nombre, edad); // super hace referencia a la superclase, llamando al constructor dandole los dos parametros, asi asignando los parametros
        this.sueldoBruto = sueldoBruto;
    }


    // cuando podemos modificar atributos, usamos un metodo set, el cual asigna un nuevo valor a un atributo
    // Setters
    public void setSueldoBruto(Double sueldoBruto) {
        if (sueldoBruto < this.sueldoBruto) { // e n caso de que el sueldo que modificamos sea menor que el por defecto, no se modificara
            throw new sueldoErroneoException("El sueldo no puede ser menor a el minimo"); 
        } else {
            this.sueldoBruto = sueldoBruto;
        }
    }

    // Getters
    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    @Override // con el override indicamos que queremos sobreescribir un metodo de la superclase
    public void mostrar() {
       System.out.printf("Empleado--> Nombre: %s\tEdad: %d\tSueldo: $%,.2f %n", getNombre(), getEdad(), sueldoBruto);
    }



    public void calcularSalarioNeto() {
        // TODO: implementar salario neto
    }

    // el compare to en si no es de la clase persona, pero este es una interface compare, que se implemento, por tanto
    // este comportamiento se sobreescribe, asi que cuando implementamos interfaces, sobreescribimos su compartamiento
    @Override
    public int compareTo(Empleado o) { // aca implemento la comparacion para ordenar, en este caso lo hare por salario
        var comparacion = sueldoBruto.compareTo(o.getSueldoBruto());
        // if (sueldoBruto > o.getSueldoBruto()) {
        //     return 1; // en este caso si "mi sueldo bruto" es mayor que el del empleado que se recibe, devuelve uno
        //     // es decir que mi sueldo es mayor
        // } else if (sueldoBruto < o.getSueldoBruto()) {
        //     return -1;
        if (comparacion == 0) {
            comparacion = getNombre().compareTo(o.getNombre());
        }
        
        return comparacion; // el compareto devuvle si es mayor - -1 si es diferente - 0 si son iguales
        // verfico los suelods, si hay diferencias devuelvo las diferencias, si no hay diferencias entonces 
        // busco por el nombre 
    }


    
    
}
