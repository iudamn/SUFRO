import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MetodosRepetidos {

    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    public static int validateInput(String validacion) {
        while (true) {
            String input = getInput("Seleccione una opción:");
            if (validacion.indexOf(input) >= 0) {
                int option = Integer.parseInt(input);
                if (-1 < option && option < 5) {
                    return option;
                }
            }
            else {
                System.out.println("Opción inválida");
            }
        }
    }

    public static String[] stringToArray(String string) {
        return string.split(",");
    }

    public static String getString(ArrayList<String> progressFile, String userID) {
        String userTemp ="";
        for ( int i=0; i <progressFile.size(); i++) {
            if (progressFile.get(i).contains(userID)) {
                userTemp = progressFile.get(i);
            }
        }
        return userTemp;
    }

    public static ArrayList<String> textReader(String filepath) {
        String line=null;
        ArrayList<String> lines = new ArrayList<>();
        try {
            File archivo = new File(filepath);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, por favor contactar con administrador.");
        }
        return lines;
    }

    public static String[] leerDatosUsuario(String usuario){
        String path = "progreso.txt";
        String datosUsuario = MetodosRepetidos.getString(MetodosRepetidos.textReader(path),usuario);
        String[] arrayDatosUsuario = MetodosRepetidos.stringToArray(datosUsuario);
        return arrayDatosUsuario;
    }

}