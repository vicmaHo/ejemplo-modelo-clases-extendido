package co.com.ejerciciempleadosvictor.modelo;
import java.util.TreeSet;
import java.util.Set;


public class Directivo extends Empleado { // extends define generalizacion
    // Atributos
    // usar constantes, para datos por defecto
    public static final String CATEGORIA_DEFAULT = "Sin categoria"; // la constante requiere el uso de final, asi que despues de asigando
    // el primer valor, no podra ser modificadad, ademas las constantes se escriben en mayus sostenida

    private String categoria;

    // Relaciones
    // un directivo puede tener multiples empleados, por tanto necesitamos almacenar n empleados en un array
    // private Empleado[] subordinados; // un directivo va a tener una muchos subordinados, relacion 1 a muchos 
    // private List<Empleado> subordinados;
    private Set<Empleado> subordinados;
 
    // Constructor
    // sobre carga de constructores - forma de poliformismo
    // los simplifico añadiendo los parametros faltantes, y depues llamando al constructor con todos los parametros para que use
    // los inicilizados 
    public Directivo(String nombre, Integer edad) {
        this(nombre, edad, CATEGORIA_DEFAULT);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto) {
        this(nombre, edad, sueldoBruto, CATEGORIA_DEFAULT);
    }

    public Directivo(String nombre, Integer edad, String categoria) {
        this(nombre, edad, SALARIO_MINIMO, categoria);

    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        // this.subordinados = new Empleado[10];
        this.subordinados = new TreeSet<>();
    }

    // // Getters
    // public Empleado[] getSubordinados() {
    //     return subordinados;
    // }

    public Set<Empleado> getSubordinados() {
        return subordinados;
    }

    public String getCategoria() {
        return categoria;
    }


    // Metodos
    @Override
    public void mostrar() {
        System.out.printf("Directivo--> Nombre: %s\tEdad: %d\tSueldo: %,.2f\tCategoria: %s %n", 
        getNombre(), getEdad(),getSueldoBruto(), categoria );


        // System.out.printf("subordinados de %s: %n", getNombre());
        // var agregoComa = false;
        // for (var empleado : subordinados) {
        //     if (agregoComa) {
        //         System.out.print(", ");
        //     }
        //     System.out.print(empleado.getNombre());
        //     agregoComa = true;
        // }
        // System.out.printf("%n %n");

        // USO DE MAP Y REDUCE - poder trabajar con las colecciones
        // con el map cojo cada uno de los elementos de la lista, cada uno de los subordinados, cojo cada empleado
        // y solo devuelve el nombre, 
        // despues aplico el rerduce, el cual sirve para reducir una lista a un solo valor 

        System.out.printf("Sus sobordinados son: " + 
        subordinados.stream() // stream --> coger la lista y conviertela en un stream, para tener un flujo de datos
            //.filter(empleado -> empleado.getSueldoBruto() > SALARIO_MINIMO) //  en este caso el filter, usa una lambda que devuelve un boolean 
            .map(empleado -> empleado.getNombre())
            .reduce((a, b) -> a + "," + b) // cojo dos valores, hago la concatenacion, si hay otro elementos usa el resultado anterior y lo concatena
            .orElse("Sin subordindos")); // en ves de usar get, ya que puede causar un error cuando una lista esta vacia, por tanto usaremos orElse
            // s iexiste algun valor en la lista lo devuelve, en caso de que no tenga se pondra el mensaje 

    }

   


   

    
}

