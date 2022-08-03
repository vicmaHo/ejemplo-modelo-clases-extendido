package co.com.ejerciciempleadosvictor;

import java.util.HashSet;

import co.com.ejerciciempleadosvictor.excepciones.sueldoErroneoException;
import co.com.ejerciciempleadosvictor.excepciones.telefonoErroneoException;
// Importo las clases necesarias del paquete modelo
import co.com.ejerciciempleadosvictor.modelo.Cliente;
import co.com.ejerciciempleadosvictor.modelo.Directivo;
import co.com.ejerciciempleadosvictor.modelo.Empleado;
import co.com.ejerciciempleadosvictor.modelo.Empresa;


public class Main {
    public static void main( String[] args ) {

        var victor = new Empleado("Victor Hernandez", 18, 9_999_999.99d);
  
        // System.out.println(victor.sueldoBruto);
        // System.out.println(victor.edad);
        // System.out.println(victor.nombre);

        var nicolas = new Empleado("Nicolas Florian", 23, 1_200_000d);
        // System.out.println(andres.nombre);
        // System.out.println(andres.edad);
        // System.out.println(andres.sueldoBruto);

        var carlos = new Empleado("Carlos Gonzales", 19, 1_500_000d);

        var manuel = new Directivo("Manuel Hernandez", 18, 2_500_000d, "Comunicador"); // puedo crear este directivo de todas estas formas
        // System.out.println("Directivo");
        // System.out.println(manuel.nombre);
        // System.out.println(manuel.edad);
        // System.out.println(manuel.sueldoBruto);
        // System.out.println(manuel.categoria);
        var daniela = new Directivo("Daniela Case", 23, "Jefe de proyectos");
        var elsocio = new Cliente("Socio", 32, "3127234476");
        var alejando = new Cliente("Alejandro", 18, "3104242334");

        // var empleados = new Empleado[] { victor, manuel, nicolas};
        // // var clientes = new Cliente[] {elsocio, alejando};
        // var empleados = new ArrayList<Empleado>(); // Ya que las listas me permiten almacenar elemntos repetidos, lo mejor es usar conjuntos
        // empleados.add(victor);
        // empleados.add(manuel);
        // empleados.add(nicolas);

        var empleados = new HashSet<Empleado>();
        empleados.add(victor);
        empleados.add(manuel);
        empleados.add(nicolas);
        empleados.add(victor);
        empleados.add(daniela); // puedo crear el objeto  
        // a la hora de agregarlo, o bien en una variable como se hizo anteriormente
        empleados.add(carlos);

        var empresa = new Empresa("Empresa chida", empleados);   // de esta forma creo un objeto, usando el constructor
        // el constructor es un metodo especial que me va a permmitir crear objetos e inicializarlos
        empresa.agregarClientes(elsocio);
        empresa.agregarClientes(alejando);

       
        // aca aplico una excepcion
        try{
            alejando.setTelefono(null);
            
        } catch (telefonoErroneoException ex) {
            System.err.println("El telefono no puede ser vacio");
        } 
        try {
            nicolas.setSueldoBruto(300d);
        }
        catch (sueldoErroneoException ex) {
            System.err.println(ex.getMessage());
        }
        

        
        // asignarle a la clase empleado un comportamiento de comparacin
        manuel.getSubordinados().add(carlos);
        manuel.getSubordinados().add(nicolas);
        manuel.getSubordinados().add(victor);
        daniela.getSubordinados().add(manuel);
        // Salida de datos
        empresa.mostrar();
    }
}
