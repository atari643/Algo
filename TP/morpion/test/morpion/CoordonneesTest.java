package morpion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 */
public class CoordonneesTest {

    @Test
    public void testEstDansPlateau() {
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(0, 0), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(13, 13), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(0, 1), 14));
        assertFalse(Coordonnees.estDansPlateau(new Coordonnees(-1, 1), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(7, 13), 14));
        assertFalse(Coordonnees.estDansPlateau(new Coordonnees(7, 14), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(13, 0), 14));
        assertFalse(Coordonnees.estDansPlateau(new Coordonnees(14, 0), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(7, 0), 14));
        assertFalse(Coordonnees.estDansPlateau(new Coordonnees(7, -1), 14));
        assertTrue(Coordonnees.estDansPlateau(new Coordonnees(0, 1), 2));
        assertFalse(Coordonnees.estDansPlateau(new Coordonnees(0, 1), 1));
    }

    @Test
    public void testSuivante() {
        assertEquals(new Coordonnees(5, 4),
                Coordonnees.suivante(new Coordonnees(4, 4), Direction.SUD));
        assertEquals(new Coordonnees(2, 2),
                Coordonnees.suivante(new Coordonnees(3, 3), Direction.NORD_OUEST));
        assertEquals(new Coordonnees(-1, -1),
                Coordonnees.suivante(new Coordonnees(0, 0), Direction.NORD_OUEST));
        assertEquals(new Coordonnees(199, 201),
                Coordonnees.suivante(new Coordonnees(200, 200), Direction.NORD_EST));
    }
    
    @Test
    public void testCasesVoisines() {
        Coordonnees coord = new Coordonnees(0, 0);
        assertEquals(3, Coordonnees.voisines(coord, 3).length);
        Coordonnees coord2 = new Coordonnees(1, 1);
        assertEquals(8, Coordonnees.voisines(coord2, 3).length);
    }
}