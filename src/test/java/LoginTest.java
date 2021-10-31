import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void archivo() throws IOException {
        HashMap actual = Login.archivo("src/test/resources/pruebaUnitariaHashMap.txt");
        HashMap<String,String> expected = new HashMap();
        expected.put("user", "pass");
        assertEquals(expected, actual);
    }
}