package co.com.ejerciciempleadosvictor.modelo;

import java.util.HashSet;
import java.util.Set;


public class Empresa {
    // Atributos
    private String nombre;
    // private Integer numClientes;  ya no es necesario este contador ya que a traves de las listas podremos obtener el tamaño


    // Relaciones

    // Composicion -- cambio de las coleccine de array, a un list del java collection framework
    // esto nos servira para tener una coleccin dinamica de cleintes (añadir sin necesidad de dar un tamaño fijo)
    // private List<Empleado> empleados;
    private Set<Empleado> empleados;
    // private Empleado[] empleados; // a la empresa asocio una coleccion de empleados
    // Agregacion
    // private Cliente[] clientes; // son varios clientes, por tanto un array de clientes
    // private List<Cliente> clientes; // de esta forma creo la lista - en la lista clientes solo puedo almacenar objetos tipo Cliente
    private Set<Cliente> clientes;


    public Empresa(String nombre, Set<Empleado> empleados) {
        // this(nombre, empleados, new Cliente[100]);
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new HashSet<>();  // puedo añadir el tipo de dato que almacenara el array list, pero como anetiormente
        // definimos el tipo de dato, no es necesario volverlo a realizar
        // var lista = new ArrayList<>(); // al declarar un array list de esta forma, recibira datos tipo objeto, es decir cualquier datos


        // this.numClientes = 0; // inicializo los clientes en 0

        
    }
    // este connstructor recibe nombre empleados y clientes
    public Empresa(String nombre, Set<Empleado> empleados, Set<Cliente> clientes) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.clientes = clientes;
    }
  

    public void agregarClientes(Cliente cliente) { // como estoy haciendo encapsulamiento, requiero de un metodo para poder añadir clientes
        // Al implementar las colecciones, cambiamos nuestra forma de agregar clientes por una mas sencilla
        clientes.add(cliente); 

        // clientes[numClientes] = cliente;
        // numClientes++;
    }

    // Tambien gracias a las colecciones dinamicas, podemos implementar un metodo el cual permita eliminar clientes
    public void eliminarCliente(Cliente cliente) {
        // var pos = clientes.indexOf(cliente); // con esto sacamos el indice/ posicion de donde se encuentra el objeto
        // if (pos == -1) { // si la variable pos es igual a -1 (no encontro el indice) entonces este mostrara un mensaje de error no continuara
        //     System.err.println("El cliente no existe");
        //     return;
        // }

        // clientes.remove(pos); // puedo recomver mediante indices, en este caso la posicion del objeto

        clientes.remove(cliente); // con esta podemos remover el objeto en si, en caso de que no exista la lista quedara igual
        // por lo tanto, con esta forma nos ahorramos lo anterior, aca podemos evidenciar el polimorfismos al permitirnos eliminar
        // un objeto a traves de el propio objeto o a traves del indice 
    }


    public String getNombre() {
        return nombre;
    }

    // FACILIDAD DE RECORRER LISTAS DINAMICAS

    public void mostrar() {
        System.out.printf("Empleados de %s %n %n", nombre);
        // for (var empleado : empleados) {
        //     empleado.mostrar();  
        // }

        // cuando trabajo con las coleccions dinamicas de la java collection framework, puedo recorrer las colecciones de esta manera
        empleados.forEach(empleado -> empleado.mostrar()); // De la lista empleado, por cada uno, cojera el empleado y llamara el metodo mostrar


        // LAMBDAS

        System.out.printf("Clientes de %s %n %n", nombre);
        clientes.forEach(cliente -> {
            if (cliente == null)  {
                return; // con esto termino la funcion lambda
            }
            
            cliente.mostrar();
        }); // esto es como una lambda en java, una funcion anonima, java las lambdas pueden tener varias instrucciones, ser un poco mas compleja

        // for (var cliente : clientes) {
        //     if (cliente == null) {
        //         break;
        //     }
        //     cliente.mostrar();
            
        // }
    }
}
