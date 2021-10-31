import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MetodosRepetidosTest {

    @Test
    void textReader() {
        ArrayList<String> actual = MetodosRepetidos.textReader("src/test/resources/pruebaUnitariaReader.txt");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("pato");
        expected.add("purific");
        assertEquals(expected, actual);
    }
}