/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cycle1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author qartigala
 */
public class TestCycle1 {
    
    @Test
    public void testFormeCorrect(){
        assertEquals('♣', Cycle1.jeuSuite_formeCorrecte(1));
        assertEquals('♥', Cycle1.jeuSuite_formeCorrecte(2));
        assertEquals('♥', Cycle1.jeuSuite_formeCorrecte(3));
    }
    @Test
    public void testJoueurSuivant(){
        assertEquals(1, Cycle1.jeuCourse_joueurSuivant(2));
        assertEquals(2, Cycle1.jeuCourse_joueurSuivant(1));
    }
    @Test
    public void testTirage(){
        int res = 0;
        res = Cycle1.jeuDevin_tirage(1);
        assertTrue(res>=0 && res<=10);
        res = Cycle1.jeuDevin_tirage(2);
        assertTrue(res >= 0 && res <= 50);
        res = Cycle1.jeuDevin_tirage(3);
        assertTrue(res >= 0 && res <= 100);
        res = Cycle1.jeuDevin_tirage(1);
        assertFalse(res>=100 && res<=0);
                
    }
    @Test
    public void testCoupAJouer(){
        assertEquals(4, Cycle1.jeuDevin_coupAJouer(1));
        assertEquals(9, Cycle1.jeuDevin_coupAJouer(2));
        assertEquals(9, Cycle1.jeuDevin_coupAJouer(3));
                
    }
}
