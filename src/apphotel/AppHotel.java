
package apphotel;

import java.io.*;
import java.util.*;


public class AppHotel {

    static Scanner Leer = new Scanner(System.in);
    static Hotel hotel;
    static boolean hotelModificado = false;
    public static void main(String[] args) {
        int opcion;
        try {
            File fichero = new File("hotel.dat");
            if (!fichero.exists()) {
                hotel = new Hotel();
                System.out.println("Se ha creado un nuevo hotel. ");

            } else {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hotel.dat"));
                hotel = (Hotel) ois.readObject();
                System.out.println("El hotel se cargo con exito ");
            }
            do {
                System.out.println("-HOTEL CONTINETAL-");
                System.out.println("ELIJA EL TIPO DE USUARIO\n");
                System.out.println("1.Administrador.");
                System.out.println("2.Usuario.");
                System.out.println("3.Salir.");
                opcion = Leer.nextInt();
                switch (opcion) {
                    case 1:
                        menuAdministrador();
                        break;
                    case 2:
                        menuUsuarios();
                        break;
                    case 3:
                        System.out.println("Gracias por su visita, hasta luego (^_^)_/ ");
                        System.out.println("Se guardo el hotel. ");
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hotel.dat"));
                        oos.writeObject(hotel);
                        oos.close();
                    default:
                        System.out.println("opcion digitada no valida");
                        break;
                }
            } while (opcion != 3);
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("io");
        } catch (ClassNotFoundException e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("ERROR CLASS");
        }
    }
///////////////////////__________ADMIINSTRADOR___________////////////////////////////////////////////////////////////////////

    public static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINENTAL MENU (ADMINISTRADOR)");
            System.out.println("1.Informacion general hotel.");
            System.out.println("2.Reservas.");
            System.out.println("3.Regresar a el menu anterior");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    informacionGeneralAdmin();
                    break;
                case 2:
                    menuReservasAdmin();
                    break;
                case 3:
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 3);
    }

    public static void informacionGeneralAdmin() {
        int opcion;
        do {

            System.out.println("HOTEL CONTINENTAL (Administrador/Clientes)");
            System.out.println("1._Manejo Servicios. ");
            System.out.println("2._Manejo contable. ");
            System.out.println("3._Regresar al menu anterior.");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    menuServiciosAdmin();
                    break;
                case 2:
                    menuManejoContable();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 3);

    }

    public static void menuServiciosAdmin() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINENTAL (Administrador/Servi)");
            System.out.println("1._Habitaciones. ");
            System.out.println("2._Piscina. ");
            System.out.println("3._Restaurante. ");
            System.out.println("4._Paqueadero. ");
            System.out.println("5._Mostrar todas los servicios.");
            System.out.println("6._regresar a el menu anterior. ");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    adminHabitaciones();
                    break;
                case 2:
                    adminPiscina();
                    break;
                case 3:
                    adminRestaurante();
                    break;
                case 4:
                    adminParqueadero();
                case 5:
                    hotel.mostrarServicios();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 6);
    }

    public static void adminHabitaciones() {
        int opcion;
        do {

            System.out.println("HOTEL CONTINENTAL (Administrador/Servicios/Habitaciones.)");
            System.out.println("1._Agregar habitacion. ");
            System.out.println("2._Eliminar habitacion.");
            System.out.println("3._Agregar habitacion vip.");
            System.out.println("4._Eliminar habitacion vip.");
            System.out.println("5. Mostrar todas las habitaciones.");
            System.out.println("6._Regresar a el menu anterior");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    agregarHabitacion();
                    break;
                case 2:
                    eliminarHabitacion();
                    break;
                case 3:
                    agregarHabitacionVIP();
                    break;
                case 4:
                    eliminarHabitacionVIP();
                case 5:
                    hotel.mostrarHabitacionesTotales();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 6);

    }

    private static void eliminarHabitacionVIP() {
        int id;
        hotel.mostrarHabitacionesVIP();
        System.out.println("Digite el ID de la habitacion: ");
        Leer.nextLine();
        id = Leer.nextInt();
        hotel.eliminarHabitacionVIP(id);
    }

    private static void agregarHabitacionVIP() {
        String nombre;
        double precio;
        hotel.mostrarHabitacionesVIP();
        System.out.println("Digite el nombre de la nueva habitacion VIP: ");
        Leer.nextLine();
        nombre = Leer.nextLine();
        System.out.println("Digite el precio de la habitacion VIP: ");
        precio = Leer.nextDouble();
        Leer.nextLine();
        System.out.println("Digite la cantidad de personas que pueden ocupar la habitacion. ");
        int cantPersonas = Leer.nextInt();
        hotel.agregarHabitacionVIP(nombre, precio, cantPersonas);
    }

    private static void eliminarHabitacion() {
        int id;
        double precio;
        hotel.mostrarHabitaciones();
        System.out.println("Digite el ID de la habitacion: ");
        Leer.nextLine();
        id = Leer.nextInt();
        hotel.eliminarHabitacion(id);
    }

    private static void agregarHabitacion() {
        String nombre;
        double precio;
        int cantPersonas;
        hotel.mostrarHabitaciones();
        System.out.println("Digite el nombre de la nueva habitacion: ");
        Leer.nextLine();
        nombre = Leer.nextLine();
        System.out.println("Digite el precio de la habitacion: ");
        precio = Leer.nextDouble();
        Leer.nextLine();
        System.out.println("Digite la cantidad de personas que ocuparan la habitacion. ");
        cantPersonas = Leer.nextInt();
        hotel.agregarHabitacion(nombre, precio, cantPersonas);
    }

    public static void adminRestaurante() {
    }

    public static void adminBar() {
    }

    public static void adminParqueadero() {
    }

    public static void adminPiscina() {
    }

    //MANEJO CONTABLE
    public static void menuManejoContable() {
        int opcion;
        do {

            System.out.println("HOTEL CONTINENTAL (Administrador/Clientes/Facturas)");
            System.out.println("1._Mostrar  todas las facturas y dinero en caja.");
            System.out.println("2._Buscar factura.");
            System.out.println("3._Eliminar factura.");
            System.out.println("4._Modificar factura.");
            System.out.println("5._Pagar factura. ");
            System.out.println("6._Regresar a el menu anterior.");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    hotel.manejoContable();
                    break;
                case 2:
                    consultarFactura();
                    break;
                case 3:
                    eliminarFacturaAdmin();
                    break;
                case 4:
                    modificarFactura();
                    break;
                case 5:
                    pagarFactura();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 6);
    }

    public static void mostrarFacturasAdmin() {
    }

    public static void eliminarFacturaAdmin() {
        int nro;
        hotel.manejoContable();
        Leer.nextLine();
        System.out.println("Digite el numero de la factura: ");
        nro = Leer.nextInt();

    }

    private static void pagarFactura() {
        String identificacion;
        Leer.nextLine();
        System.out.println("Digite la identificacion, por favor: ");
        identificacion = Leer.nextLine();
        Factura facturaBuscada = hotel.consultarFactura(identificacion);
        if (facturaBuscada != null) {
            facturaBuscada.mostrarFactura();
            if (facturaBuscada.getEstado() == false) {
                facturaBuscada.pagarFactura();
                hotel.cancelarFactura(facturaBuscada.getPrecio());
                System.out.println("La factura a sido cancelada con exito :)");
            } else {
                System.out.println("La factura, ya ha sido cancelada");
            }

        } else {
            System.out.println("No tiene ninguna factura.");
        }

    }

    //Reservas admin
    private static void menuReservasAdmin() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINENTAL (Administrador/Reservas)");
            System.out.println("1._Reservar habitacion. ");
            System.out.println("2._Modificar Reserva.");
            System.out.println("3._Eliminar Reserva. ");
            System.out.println("4._Buscar Reserva. ");
            System.out.println("5._Mostrar reservas.");
            System.out.println("6._regresar a el menu anterior");

            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    reservarHabitacion();
                    break;
                case 2:
                    modificarReserva();
                    break;
                case 3:
                    eliminarReserva();
                    break;
                case 4:
                    buscarReserva();
                    break;
                case 5:
                    hotel.mostrarReservas();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 6);
    }

    private static void reservarHabitacion() {
        int idTipo, idHabitacion;
        int numeroPersonas;
        System.out.println("Digite el ID del tipo de habitacion normal(1) o VIP(2): ");
        Leer.nextLine();
        idTipo = Leer.nextInt();
        if (idTipo == 1) {
            hotel.mostrarHabitaciones();
            Leer.nextLine();
            System.out.println("Digite el id de la habitacion que desea reservar. ");
            idHabitacion = Leer.nextInt();
            Producto habitacion = hotel.buscarHabitacion(idHabitacion);
            if (habitacion != null) {
                if (habitacion.totalIdentificaciones() == 0) {
                    hotel.reservarHabitacionNormal(habitacion);
                } else {
                    System.out.println("Lo sentimos, la habitacion ya esta ocupada");
                }
            } else {
                System.out.println("ID incorrecto. ");
            }

        } else {
            hotel.mostrarHabitacionesVIP();
            Leer.nextLine();
            System.out.println("Digite el id de la habitacion que desea reservar. ");
            idHabitacion = Leer.nextInt();
            Producto habitacionVIP = hotel.buscarHabitacionVIP(idHabitacion);
            if (habitacionVIP != null) {
                if (habitacionVIP.totalIdentificaciones() == 0) {
                    hotel.reservarHabitacionVIP(habitacionVIP);
                } else {
                    System.out.println("Lo sentimos, pero la habitacion ya esta ocupada. ");
                }
            } else {
                System.out.println("ID incorrecto. ");
            }
        }

    }

    private static void modificarReserva() {
        int idTipo, idReserva;
        int numeroPersonas;
        hotel.mostrarReservas();
        Leer.nextLine();
        System.out.println("Digite el id de la reserva. ");
        idReserva = Leer.nextInt();
        Reserva reserva = hotel.buscarReserva(idReserva);
        if (reserva != null) {
            ArrayList<String> identificaciones = new ArrayList<String>();
            String identificacion;
            for (int i = 0; i < reserva.getProductoReservado().getCantPersonas(); i++) {
                Leer.nextLine();
                System.out.println("Digite identificacion: " + (i + 1));
                identificacion = Leer.nextLine();
                identificaciones.add(identificacion);
            }
            reserva.modificarReserva(identificaciones);
        }
    }

    private static void eliminarReserva() {
        int idReserva;
        int numeroPersonas;
        hotel.mostrarReservas();
        Leer.nextLine();
        System.out.println("Digite el id de la reserva. ");
        idReserva = Leer.nextInt();
        int posReserva = hotel.posReserva(idReserva);
        if (idReserva != -1) {
            hotel.eliminarReserva(posReserva);
        } else {
            System.out.println("EL ID es incorrecto. ");
        }

    }

    public static void mostrarUsuarios() {
    }
/////////////////////////___________USUARIOS__________///////////////////////////////////////////////////////////////	

    public static void menuUsuarios() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINETAL USUARIO");
            System.out.println("1. Manejo reservas.");
            System.out.println("2. Ingresar con reserva.");
            System.out.println("3. Ingresar sin reserva.");
            System.out.println("4. Manejo reportes de cliente (salida del hotel). ");
            System.out.println("5. Regresar a el menu anterior.");
            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    manejoReservas();
                case 2:
                    ingresarReserva();
                    break;
                case 3:
                    ingresarSinReserva();
                    break;
                case 4:
                    manejoReportesCliente();
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 5);

    }

    public static void ingresarUsuario() {
    }

    public static void eliminarUsuario() {
    }

    public static void buscarUsuario() {
    }

    public static void habitacionesDisponibles() {
    }

    public static void cancelarReserva() {
    }

    public static void mostrarFacturas() {
    }

    public static void eliminarFactura() {
    }

    public static void verificacionDeUsuario() {
    }

    public static void registrarUsuario() {
    }

    private static void ingresarReserva() {
        String identificacion;
        String rta;
        String nombre;
        String telefono;
        Leer.nextLine();
        System.out.println("Digite la identificacion. ");
        identificacion = Leer.nextLine();
        Producto productoBuscado = hotel.buscarReserva(identificacion);
        if (productoBuscado != null) {
            System.out.println("Usted ya reservo una habitacion.");
            System.out.println("Informacion de la habitacion");
            productoBuscado.mostrarProducto();
            Leer.nextLine();
            System.out.println("Desea adquirir la habitacion y regitrarse en el hotel. si/no?");
            rta = Leer.nextLine();
            if (rta.equalsIgnoreCase("si")) {
                Usuario usuarioBuscado = hotel.buscarUsuario(identificacion);
                if (usuarioBuscado == null) {
                    System.out.println("Llene los siguientes datos por favor.\n");
                    Leer.nextLine();
                    System.out.println("Nombre: ");
                    nombre = Leer.nextLine();
                    Leer.nextLine();
                    System.out.println("Telefono: ");
                    telefono = Leer.nextLine();
                    hotel.registrarUsuario(nombre, telefono, identificacion);
                    usuarioBuscado = hotel.buscarUsuario(identificacion);
                    usuarioBuscado.setHabitacion(productoBuscado);
                    hotel.hacerFactura(identificacion, productoBuscado);
                    int posReserva = hotel.posReserva(productoBuscado.getIDProducto());
                    hotel.eliminarReserva(posReserva);
                } else {
                    System.out.println("Usted ya se encuentra registrado en el hotel. ");
                    usuarioBuscado = hotel.buscarUsuario(identificacion);
                    usuarioBuscado.setHabitacion(productoBuscado);
                    hotel.hacerFactura(identificacion, productoBuscado);
                    int posReserva = hotel.posReserva(productoBuscado.getIDProducto());
                    hotel.eliminarReserva(posReserva);
                }
            }

        } else {
            System.out.println("Lo sentimos, pero no ha reservado ninguna habitacion. ");
        }

    }

    private static void ingresarSinReserva() {
        int idTipo, idHabitacion;
        int numeroPersonas;
        String identificacion, nombre, telefono;
        System.out.println("Digite el ID del tipo de habitacion normal(1) o VIP(2): ");
        Leer.nextLine();
        idTipo = Leer.nextInt();
        if (idTipo == 1) {
            hotel.mostrarHabitaciones();
            Leer.nextLine();
            System.out.println("Digite el id de la habitacion que desea adquirir. ");
            idHabitacion = Leer.nextInt();
            Producto habitacion = hotel.buscarHabitacion(idHabitacion);
            if (habitacion != null) {
                if (habitacion.totalIdentificaciones() == 0) {
                    Leer.nextLine();
                    System.out.println("Por favor digite su identificacion.");
                    identificacion = Leer.nextLine();
                    Usuario usuarioBuscado = hotel.buscarUsuario(identificacion);
                    if (usuarioBuscado == null) {
                        System.out.println("Llene los siguientes datos por favor.\n");
                        Leer.nextLine();
                        System.out.println("Nombre: ");
                        nombre = Leer.nextLine();
                        Leer.nextLine();
                        System.out.println("Telefono: ");
                        telefono = Leer.nextLine();
                        hotel.registrarUsuario(nombre, telefono, identificacion);
                        usuarioBuscado = hotel.buscarUsuario(identificacion);
                        usuarioBuscado.setHabitacion(habitacion);
                        hotel.hacerFactura(identificacion, habitacion);
                    } else {
                        System.out.println("Usted ya se encuentra registrado. ");
                        usuarioBuscado = hotel.buscarUsuario(identificacion);
                        if (usuarioBuscado.getHabitacion() == null) {
                            usuarioBuscado.setHabitacion(habitacion);
                            hotel.hacerFactura(identificacion, habitacion);
                        } else {
                            System.out.println("Lo sentimos, pero ya tiene una habitacion.");
                        }
                    }
                } else {
                    System.out.println("Lo sentimos, la habitacion esta ocupada ");
                }

            } else {
                System.out.println("ID inocorrecto");
            }
        } else {
            hotel.mostrarHabitacionesVIP();
            Leer.nextLine();
            System.out.println("Digite el id de la habitacion que desea adquirir. ");
            idHabitacion = Leer.nextInt();
            Producto habitacionVIP = hotel.buscarHabitacionVIP(idHabitacion);
            if (habitacionVIP != null) {
                if (habitacionVIP.totalIdentificaciones() == 0) {
                    System.out.println("Por favor digite su identificacion.");
                    identificacion = Leer.nextLine();
                    Usuario usuarioBuscado = hotel.buscarUsuario(identificacion);
                    if (usuarioBuscado == null) {
                        System.out.println("Llene los siguientes datos por favor.\n");
                        Leer.nextLine();
                        System.out.println("Nombre: ");
                        nombre = Leer.nextLine();
                        Leer.nextLine();
                        System.out.println("Telefono: ");
                        telefono = Leer.nextLine();
                        hotel.registrarUsuario(nombre, telefono, identificacion);
                        usuarioBuscado = hotel.buscarUsuario(identificacion);
                        usuarioBuscado.setHabitacion(habitacionVIP);
                        hotel.hacerFactura(identificacion, habitacionVIP);
                    } else {
                        System.out.println("Usted ya se encuentra registrado. ");
                        usuarioBuscado = hotel.buscarUsuario(identificacion);
                        if (usuarioBuscado.getHabitacion() == null) {
                            usuarioBuscado.setHabitacion(habitacionVIP);
                            hotel.hacerFactura(identificacion, habitacionVIP);
                        } else {
                            System.out.println("Lo sentimos, pero ya tiene una habitacion.");
                        }
                    }
                } else {
                    System.out.println("Lo sentimos, la habitacion esta ocupada ");
                }

            } else {
                System.out.println("ID incorrecto");
            }
        }
    }

    private static void buscarReserva() {
        String identificacion;
        Leer.nextLine();
        System.out.println("Digite la identificacion. ");
        identificacion = Leer.nextLine();
        Producto productoBuscado = hotel.buscarReserva(identificacion);
        if (productoBuscado != null) {
            System.out.println("Usted ya reservo una habitacion.");
            System.out.println("Informacion de la habitacion\n");
            productoBuscado.mostrarProducto();
        } else {
            System.out.println("No ha reservado ninguna habitacion.");
        }
    }

    private static void manejoReservas() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINENTAL (Usuarios/Reservas)");
            System.out.println("1._Reservar habitacion. ");
            System.out.println("2._Modificar Reserva.");
            System.out.println("3._Eliminar Reserva. ");
            System.out.println("4._Buscar reserva.");
            System.out.println("5._Regresar al menu anterior. ");
            Leer.nextLine();
            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    reservarHabitacion();
                    break;
                case 2:
                    modificarReserva();
                    break;
                case 3:
                    eliminarReserva();
                    break;
                case 4:
                    buscarReserva();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 5);
    }

    private static void manejoReportesCliente() {
        int opcion;
        do {
            System.out.println("HOTEL CONTINENTAL (Usuarios/Reservas)");
            System.out.println("1._Consultar factura.");
            System.out.println("2._Regresar al menu anterior. ");
            Leer.nextLine();
            opcion = Leer.nextInt();
            switch (opcion) {
                case 1:
                    consultarFactura();
                    break;
                default:
                    System.out.println("opcion digitada no valida");
                    break;
            }

        } while (opcion != 2);
    }

    private static void consultarFactura() {
        String identificacion;
        Leer.nextLine();
        System.out.println("Digite su identificacion, por favor: ");
        identificacion = Leer.nextLine();
        Factura facturaBuscada = hotel.consultarFactura(identificacion);
        if (facturaBuscada != null) {
            System.out.println("Si la encontre.");
            facturaBuscada.mostrarFactura();
        } else {
            System.out.println("Usted no tiene ninguna factura pendiente dentro del hotel. ");
        }
        System.out.println("Para cancelar la factura, queja, reclamo, modificacion, etc. Por favor ir con el administrador.");
    }

    private static void modificarFactura() {
        String identificacion;
        Leer.nextLine();
        System.out.println("Digite su identificacion, por favor: ");
        identificacion = Leer.nextLine();
        Factura facturaBuscada = hotel.consultarFactura(identificacion);
        if (facturaBuscada != null) {
            facturaBuscada.mostrarFactura();
            Leer.nextLine();
            System.out.println("Digite el nuevo precio.");
            facturaBuscada.setPrecio(0);
        }
    }
}
