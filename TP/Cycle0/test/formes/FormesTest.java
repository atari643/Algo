package formes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FormesTest {

    @Test
    public void testFormeCorrecte() {
    assertEquals('c', Formes.formeCorrecte(1));
    assertEquals('c', Formes.formeCorrecte(2));
    assertEquals('t', Formes.formeCorrecte(3));
    assertEquals('t', Formes.formeCorrecte(4));
    }
    
    @Test
    public void testSurfaceCorrect(){
        assertEquals('9', Formes.surfaceCorrect(1));
        assertEquals('25', Formes.surfaceCorrect(2));
        assertEquals('2', Formes.surfaceCorrect(3));
        assertEquals('14', Formes.surfaceCorrect(4));

    }
}