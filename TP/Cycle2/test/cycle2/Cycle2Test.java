/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cycle2;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author qartigala
 */
public class Cycle2Test {

    @Test
    public void testMinTab() {
        assertTrue(Cycle2.gestionNoteMin(new int[]{1, 2, 3}, 3) == 1);
        assertFalse(Cycle2.gestionNoteMin(new int[]{8, 2, 7, 3}, 4) == 7);
        assertTrue(Cycle2.gestionNoteMin(new int[]{2, 10, 40, 0}, 4) == 0);
        assertTrue(Cycle2.gestionNoteMin(new int[]{2, -1, 7, -10}, 4) == -10);
        assertFalse(Cycle2.gestionNoteMin(new int[]{2, -1, 7, -10}, 4) == -1);
    }

    @Test
    public void testMaxTab() {
        assertTrue(Cycle2.gestionNoteMax(new int[]{1, 2, 3}, 3) == 3);
        assertFalse(Cycle2.gestionNoteMax(new int[]{8, 2, 7, 3}, 4) == 7);
        assertTrue(Cycle2.gestionNoteMax(new int[]{2, 10, 40, 0}, 4) == 40);
        assertTrue(Cycle2.gestionNoteMax(new int[]{2, -1, 7, -10}, 4) == 7);
        assertTrue(Cycle2.gestionNoteMax(new int[]{-10, -40, -20, -5}, 4) == -5);

    }

    @Test
    public void testMoyTab() {
        assertTrue(Cycle2.gestionNoteMoy(new int[]{1, 2, 3}, 3) == 2);
        assertFalse(Cycle2.gestionNoteMoy(new int[]{8, 2, 7, 3}, 4) == 8);
        assertTrue(Cycle2.gestionNoteMoy(new int[]{2, 10, 40, 0}, 4) == 13);
        assertTrue(Cycle2.gestionNoteMoy(new int[]{2, -1, 7, -10}, 4) == -0.5);
    }

    @Test
    public void testGestionMoyMax() {
        assertTrue(Cycle2.gestionMoyMax(new double[][]{{10.40, 09.30, 80}, {10.30, 02.03, 03.20}}, 0) == 80);
        assertTrue(Cycle2.gestionMoyMax(new double[][]{{10.40, 09.30, 20}, {10.30, 02.03, 03.20}}, 1) == 10.30);
        assertFalse(Cycle2.gestionMoyMax(new double[][]{{20.40, 40.39, 2}, {10.30, 02.03, 03.20}}, 0) == 2);
        assertTrue(Cycle2.gestionMoyMax(new double[][]{{-10.40, -09.30, -20}, {10.30, 02.03, 03.20}}, 0) == -09.30);
    }

    @Test
    public void testVerifAbsence() {
        boolean[][] abs = new boolean[5][3];
        for (int i = 0; i < abs.length; i++) {
            for (int e = 0; e < abs[0].length; e++) {
                abs[i][e] = true;
            }
        }
        assertTrue(Cycle2.verifAbsence(abs, 0));
        assertTrue(Cycle2.verifAbsence(abs, 1));
        assertTrue(Cycle2.verifAbsence(abs, 2));
        assertTrue(Cycle2.verifAbsence(abs, 3));
        assertTrue(Cycle2.verifAbsence(abs, 4));

        boolean[][] abs2 = new boolean[5][3];
        for (int i = 0; i < abs.length; i++) {
            for (int e = 0; e < abs[0].length; e++) {
                abs2[i][e] = false;
            }
        }
        assertFalse(Cycle2.verifAbsence(abs2, 0));
        assertFalse(Cycle2.verifAbsence(abs2, 1));
        assertFalse(Cycle2.verifAbsence(abs2, 2));
        assertFalse(Cycle2.verifAbsence(abs2, 3));
        assertFalse(Cycle2.verifAbsence(abs2, 4));

    }

    @Test
    public void testAfficherStatistique() {
        int[] tab = {10, 5, 8, 9};
        int[] tab2 = {20, 2, 3, 8};
        assertEquals(8.12, Cycle2.afficherStatistique(tab, tab2, tab.length, tab2.length, 1), 0.01);
        int[] tab3 = {-10, 5, 8, 9};
        int[] tab4 = {20, -2, 3, 8};
        assertEquals(5.12, Cycle2.afficherStatistique(tab3, tab4, tab3.length, tab4.length, 1), 0.01);
    }

    @Test
    public void testModifNoteUe() {
        double[][] tab1 = {{10, 12, 15.30}, {9, 8.43, 14.30}};
        double[][] tab2 = {{10, 12, 15.30}, {9, 11, 14.30}};
        Cycle2.modifNoteUe(tab1, 1, 1, 11);
        Assert.assertArrayEquals(tab1, tab2);
        double[][] tab3 = {{10, 12, 15.30}, {9, 8.43, 14.30}};
        Cycle2.modifNoteUe(tab3, 0, 0, 20);
        double[][] tab4 = {{15.30, 12, 15.30}, {9, 8.43, 14.30}};
        Assert.assertArrayEquals(tab3, tab4);
        double[][] tab5 = {{10, 12, 15.30}, {9, 8.43, 14.30}};
        Cycle2.modifNoteUe(tab4, 1, 0, 7);
        double[][] tab6 = {{10, 12, 15.30}, {9, 8.43, 14.30}};
        Assert.assertArrayEquals(tab5, tab6);
    }

    @Test
    public void nonModificationDesNotesEtu() {
        Cycle2.MAX_NOTE = 10;
        
        int ue1s1[] = new int[Cycle2.MAX_NOTE];
        int ue1s2[] = new int[Cycle2.MAX_NOTE];
        int ue2s1[] = new int[Cycle2.MAX_NOTE];
        int ue2s2[] = new int[Cycle2.MAX_NOTE];
        int ue3s1[] = new int[Cycle2.MAX_NOTE];
        int ue3s2[] = new int[Cycle2.MAX_NOTE];
        int tailleUe1s1 = Cycle2.MAX_NOTE;
        int tailleUe1s2 = Cycle2.MAX_NOTE;
        int tailleUe2s1 = Cycle2.MAX_NOTE;
        int tailleUe2s2 = Cycle2.MAX_NOTE;
        int tailleUe3s1 = Cycle2.MAX_NOTE;
        int tailleUe3s2 = Cycle2.MAX_NOTE;
        Cycle2.etuAfficherInfoDesUE(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
        Cycle2.etuAfficherAnneeValide(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
        int ue1s1t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue1s1, ue1s1t1);
        int ue1s2t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue1s2, ue1s2t1);
        int ue2s1t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue2s1, ue2s1t1);
        int ue2s2t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue2s2, ue2s2t1);
        int ue3s1t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue3s1, ue3s1t1);
        int ue3s2t1[] = new int[Cycle2.MAX_NOTE];
        Assert.assertArrayEquals(ue3s2, ue3s2t1);
    }

}
