import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejecutar {

    public Ejecutar(CargarPartida cargarPartida,String usuario) {
        gameLoop(cargarPartida.getCoordenada(),cargarPartida.getPosicion(),usuario);
    }

    public void gameLoop(int linea, int posicion, String usuario) {
        String pathHistoria = "test1.txt";
        ArrayList<String> historia = MetodosRepetidos.textReader(pathHistoria);
        String pathProgreso = "progreso.txt";
        ArrayList<String> progresoArrayList = MetodosRepetidos.textReader(pathProgreso);
        int count =0;
        do {
            String[] array = MetodosRepetidos.leerDatosUsuario(usuario);
            List<String> mainDisplay = historia.subList(linea + 3, linea + 18);
            System.out.println(mainDisplay);
            List<String> Opciones = historia.subList(linea + 19, linea + 25);
            System.out.println(Opciones);
            List<String> StatsA = historia.subList(linea + 26, linea + 30);
            List<String> StatsB = historia.subList(linea + 30, linea + 34);
            List<String> StatsC = historia.subList(linea + 34, linea + 38);
            int option = 0;

            option = MetodosRepetidos.validateInput("123");
            switch (option) {
                case 1:
                    saveData(progressUpdate(statUpdate(array, StatsA)), posicion, progresoArrayList);
                    linea = Integer.parseInt(StatsA.get(0));
                    count++;
                    break;
                case 2:
                    saveData(progressUpdate(statUpdate(array, StatsB)), posicion, progresoArrayList);
                    linea = Integer.parseInt(StatsB.get(0));
                    count++;
                    break;
                case 3:
                    saveData(progressUpdate(statUpdate(array, StatsC)), posicion, progresoArrayList);
                    linea = Integer.parseInt(StatsC.get(0));
                    count++;
                    break;
            }
        }while (count <3);
    }

    public static void saveData(String nuevaLinea, int posicion, ArrayList<String> stats){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter("progreso.txt");
            escritor = new PrintWriter(fichero);
            escritor.flush();
            String[] split = stats.toArray(new String[0]);
            split[posicion] = nuevaLinea;
            for(int x = 0; x < split.length; x++){
                escritor.write(split[x]);
                if (x < split.length-1){
                escritor.println();}
            }
            escritor.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de texto: "+e.getMessage());
        } finally {
            if(fichero != null){
                try {
                    fichero.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar archivo de texto: "+e.getMessage());
                }
            }
        }
    }

    public static String[] statUpdate (String[] stats, List Stats){
        var v0 = stats[0];
        var v1 = Integer.parseInt((String) Stats.get(0));
        var v2 = Integer.parseInt(stats[2]) + Integer.parseInt((String) Stats.get(1));
        var v3 = Integer.parseInt(stats[3]) + Integer.parseInt((String) Stats.get(2));
        var v4 = Integer.parseInt(stats[4]) + Integer.parseInt((String) Stats.get(3));
        var v5 = stats[5];
        String[] statUpdated = {v0, String.valueOf(v1), String.valueOf(v2), String.valueOf(v3), String.valueOf(v4), v5};
        return statUpdated;
    }

    public static String progressUpdate (String[] array){
        StringBuffer sb = new StringBuffer();
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i]);
            } else {
                sb.append(array[i] + ",");
            }
            str = sb.toString();
        }
        return str;
    }
}