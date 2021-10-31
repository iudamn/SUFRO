import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Login {
    private String usuario;
    private String contraseña;

    public Login(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static HashMap archivo(String path) throws IOException {
        //Colocar dirección en la que se encontrará el archivo con usuarios y contraseñas.
        String filePath = path;
        //Inicializar HashMap que contendrá la información para despues verificarla
        HashMap<String, String> map = new HashMap();
        //Reader
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        reader.close();
        return map;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}