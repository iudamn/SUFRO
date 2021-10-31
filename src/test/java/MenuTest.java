import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void verificador() throws IOException {
        Menu menu = new Menu();
        menu.login_.add(new Login("usuarioTest","contraseñaTest"));
        assertTrue(menu.verificador("src/test/resources/pruebaUnitariaVerificador.txt"));
    }
}