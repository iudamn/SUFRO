import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    ArrayList<Login> login_ = new ArrayList<>();
    ArrayList<CargarPartida> cargarPartida_ = new ArrayList<>();

    public void startProgram() throws IOException {
        int option = 0;
        login_.add(new Login("placeholder","placeholder"));
        cargarPartida_.add(new CargarPartida(0,0,0,0,0));
        do{
            System.out.println("Bienvenido.");
            showMenu();
            option = MetodosRepetidos.validateInput("012");
            menuSwitch(option);
        }while(option == 1 || option == 0);
    }

    public void showMenu() {
        System.out.println("-------------");
        System.out.println("[1] Nueva Partida.");
        System.out.println("[2] Cargar Partida.");
        System.out.println("[0] Salir (S/N)");
    }

    public void menuSwitch(int option) throws IOException {
        switch (option) {
            case 1:
                recibirUsuario();
                int posicion = MetodosRepetidos.textReader("progreso.txt").size()+1;
                agregar(login_.get(0).getUsuario(),login_.get(0).getContraseña(),posicion);
                System.out.println("Usuario creado correctamente");
                break;
            case 2:
                login();
                statSetter(MetodosRepetidos.leerDatosUsuario(login_.get(0).getUsuario()));
                Ejecutar ejecutar = new Ejecutar(cargarPartida_.get(0),login_.get(0).getUsuario());
                break;
            case 0:
                exit();
                break;
        }
    }

    public void login() throws IOException {
        boolean log;
        do{
            setUser();
            setPass();
            log = verificador("IDPass.txt");
        }while(!log);
    }

    public void setUser(){
        this.login_.get(0).setUsuario(MetodosRepetidos.getInput("Ingrese usuario: "));
    }

    public void setPass(){
        this.login_.get(0).setContraseña(MetodosRepetidos.getInput("Ingrese contraseña: "));
    }

    public void setPassConfirmada(String pass){
        this.login_.get(0).setContraseña(pass);
    }

    public void exit() {
        String respuesta = MetodosRepetidos.getInput("Desea salir del programa? S/N");
        respuesta = respuesta.toLowerCase();
        if(respuesta.contains("s")){
            System.exit(0);
        }
        else if (respuesta.contains("n")){
            System.out.println("");
        }
    }

    public boolean verificador(String path) throws IOException {
        boolean verificador = false;
        if(Login.archivo(path).containsKey(login_.get(0).getUsuario())){
            if(Login.archivo(path).get(login_.get(0).getUsuario()).equals(login_.get(0).getContraseña())){
                verificador = true;
            }
        }
        return verificador;
    }

    public void statSetter(String[] arrayDatosUsuario){
        cargarPartida_.get(0).setCoordenada(Integer.parseInt(arrayDatosUsuario[1]));
        cargarPartida_.get(0).setStatA(Integer.parseInt(arrayDatosUsuario[2]));
        cargarPartida_.get(0).setStatB(Integer.parseInt(arrayDatosUsuario[3]));
        cargarPartida_.get(0).setStatC(Integer.parseInt(arrayDatosUsuario[4]));
        cargarPartida_.get(0).setPosicion(Integer.parseInt(arrayDatosUsuario[5]));
    }

    public void recibirUsuario(){
        boolean match = false;
        do{
            setUser();
            String pass1 = MetodosRepetidos.getInput("Ingrese contraseña: ");
            String pass2 = MetodosRepetidos.getInput("Ingrese nuevamente contraseña: ");
            if (pass1.equals(pass2)){
                setPassConfirmada(pass1);
                match = true;
            }
        }while(!match);
    }

    public static void agregar(String usuario, String contraseña, int posicion){
        BufferedWriter bw = null;
        BufferedWriter bw1= null;
        FileWriter fichero = null;
        FileWriter fichero1= null;

        try {
            int a=0;
            int b=0;
            int c=0;
            int d=0;

            File file = new File("progreso.txt");
            File file1= new File("IDPass.txt");

            // flag true, indica adjuntar información al archivo.
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            fichero1 = new FileWriter(file1.getAbsoluteFile(), true);

            bw = new BufferedWriter(fichero);
            bw1= new BufferedWriter(fichero1);

            bw.write("\n"+usuario+","+a+","+b+","+c+","+d+","+(posicion-1));
            bw1.write("\n"+usuario+","+contraseña);

            //System.out.println("información agregada");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fichero != null)
                    fichero.close();
                if (bw1 != null)
                    bw1.close();
                if (fichero1 != null)
                    fichero1.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}