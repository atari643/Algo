/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cycle2;


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author qartigala
 */
public class Cycle2 {
    /**
     * La Note max pouvant être obtenu.
     */
    static int NOTE_MAX = 20;

    /**
     * Le nombre de Note Possible.
     */
    static int MAX_NOTE = 10;
    /**
     * Le nombre étudiant.
     */
    static int NB_ETU = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

    /**
     * Affiche le menu de selection pour etudiant
     */
    static void etuAfficherMenu() {
        System.out.println("Taper un nombre entre 1 et 5 Pour: \n "
                + "1. Afficher les notes d'une UE pour un semestre \n "
                + "2. Statistiques de vos UE \n "
                + "3. Note à obtenir au prochain devoir d'une UE pour avoir la moyenne \n "
                + "4. Afficher si année est validée \n "
                + "5. Quitter");
    }

    /**
     * Affiche le menu d'identification
     */
    static void afficherIdentification() {
        System.out.println("Saisir 1) si vous êtes étudiant ou 2) si vous faites partie de la DDE");
    }

    /**
     * afficher le menu de selection pour DDE
     */
    static void ddeafficherMenu() {
        System.out.println("1) Information générales sur les notes et absences \n"
                + "2) Modification d'une moyenne \n"
                + "3) Listing des rattrapages à organiser \n"
                + "4) Quitter");
    }

    /**
     * execute chaque action decrit dans afficherMenu
     */
    static void menu() {
        int n = 0;
        int i = 0;
        afficherIdentification();
        i = gestionDeSaisieNombreIntervalle(1, 2);
        if (i == 2) {
            ddeMenu();
        } else {
            etuMenu();
        }
    }

    /**
     * Fonction qui execute le menu du DDE
     */
    static void ddeMenu() {
        double[][] ue = new double[NB_ETU][3];
        boolean[][] absUe = new boolean[NB_ETU][3];
        for (int i = 0; i < NB_ETU; i++) {
            for (int e = 0; e < 3; e++) {
                Random random = new Random();
                absUe[i][e] = random.nextBoolean();
            }
        }

        int n = 0;
        remplirMatriceAleatoire(ue);
        while (n != 4) {
            ddeafficherMenu();
            n = gestionDeSaisieNombreIntervalle(1, 4);
            switch (n) {
                case 1:
                    afficherInformationGeneral(ue, absUe);
                    break;
                case 2:
                    nouvelleNote(ue);
                    break;
                case 3:
                    rattrapageUE(ue, absUe);
                    break;
                case 4:
                    System.out.println("Programme Quitter");
                    break;
                default:
                    System.out.println("Erreur Nombre n'est pas dans l'intervalle");
                    break;

            }
        }
    }

    /**
     * execute les fonctionnalités du menu des étudiants
     */
    static void etuMenu() {
        int ue1s1[] = new int[MAX_NOTE];
        int ue1s2[] = new int[MAX_NOTE];
        int ue2s1[] = new int[MAX_NOTE];
        int ue2s2[] = new int[MAX_NOTE];
        int ue3s1[] = new int[MAX_NOTE];
        int ue3s2[] = new int[MAX_NOTE];

        int tailleUe1s1 = remplirTableauAleatoire(ue1s1);
        int tailleUe1s2 = remplirTableauAleatoire(ue1s2);
        int tailleUe2s1 = remplirTableauAleatoire(ue2s1);
        int tailleUe2s2 = remplirTableauAleatoire(ue2s2);
        int tailleUe3s1 = remplirTableauAleatoire(ue3s1);
        int tailleUe3s2 = remplirTableauAleatoire(ue3s2);
        int n = 0;
        while (n != 5) {
            etuAfficherMenu();
            n = gestionDeSaisieNombreIntervalle(1, 5);
            switch (n) {
                case 1:
                    etuAfficherNotesUE(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
                    break;
                case 2:
                    etuAfficherInfoDesUE(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
                    break;

                case 3:
                    etuAfficherNoteAObtenir(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
                    break;
                case 4:
                    etuAfficherAnneeValide(ue1s1, tailleUe1s1,
                            ue1s2, tailleUe1s2,
                            ue2s1, tailleUe2s1,
                            ue2s2, tailleUe2s2,
                            ue3s1, tailleUe3s1,
                            ue3s2, tailleUe3s2);
                    break;
                case 5:
                    System.out.println("Programme Quitter");
                    break;
                default:
                    System.out.println("Nombre n'est pas dans l'intervalle");
                    break;
            }
        }
    }

    /**
     * Fonction qui renvoie la saisi de l'utilisateur dans un intervalle de
     * nombre, placé en paramettre.
     *
     * @param min le plus petit nombre qui peut être entrer
     * @param max le plus grand nombre qui peut être entrer
     * @return la saisie de l'utilisateur
     */
    static int gestionDeSaisieNombreIntervalle(int min, int max) {
        int saisie = 0;
        do {
            System.out.println("choisi un nombre entre " + min + " et " + max);
            Scanner sc = new Scanner(System.in);
            saisie = sc.nextInt();
            if (saisie < min || saisie > max) {
                System.out.println("erreur hors intervalle reesaye");
            }
        } while (saisie < min || saisie > max);
        return saisie;
    }

    /**
     * remplie un tableau d'un nombre aléatoire (compris entre 1 et 10) de
     * valeur aléatoire (compris entre 0 et 20).
     *
     * @param tab tableau a modifier
     * @return la taille du tableau
     */
    static int remplirTableauAleatoire(int[] tab) {
        int n = 0;
        int tirage = 0;
        Random random = new Random();
        n = random.nextInt(MAX_NOTE) + 1;
        for (int i = 0; i < n; i++) {
            tirage = random.nextInt(NOTE_MAX + 1);
            tab[i] = tirage;
        }
        return n;
    }

    /**
     * Remplie une matrice totalement avec des moyennes aléatoire (compris entre
     * 0 et 20).
     *
     * @param tab Une matrice
     */
    static void remplirMatriceAleatoire(double[][] tab) {
        double tirage = 0.0;
        Random random = new Random();
        for (int i = 0; i < tab.length; i++) {
            for (int z = 0; z < tab[0].length; z++) {
                tirage = 20.00 * random.nextDouble();
                tab[i][z] = tirage;
            }

        }
    }

    /**
     * Permet a l'utilisateur d'afficher toutes les notes d'un UE selon le
     * semestre
     *
     * @param ue1s1 tableau de valeur ue1s1
     * @param tailleUe1s1 taille du tableau ue1s1
     * @param ue1s2 tableau de valeur ue1s2
     * @param tailleUe1s2 taille du tableau ue1s2
     * @param ue2s1 tableau de valeur ue2s1
     * @param tailleUe2s1 taille du tableau ue2s1
     * @param ue2s2 tableau de valeur ue2s2
     * @param tailleUe2s2 taille du tableau ue2s2
     * @param ue3s1 tableau de valeur ue3s1
     * @param tailleUe3s1 taille du tableau ue3s1
     * @param ue3s2 tableau de valeur ue3s2
     * @param tailleUe3s2 taille du tableau ue3s2
     */
    static void etuAfficherNotesUE(
            int[] ue1s1, int tailleUe1s1,
            int[] ue1s2, int tailleUe1s2,
            int[] ue2s1, int tailleUe2s1,
            int[] ue2s2, int tailleUe2s2,
            int[] ue3s1, int tailleUe3s1,
            int[] ue3s2, int tailleUe3s2) {
        int choixUe = 0;
        int choixS = 0;
        System.out.println("Choisi un UE entre 1 et 3");
        choixUe = gestionDeSaisieNombreIntervalle(1, 3);
        System.out.println("Choisi un semestre entre 1 et 2");
        choixS = gestionDeSaisieNombreIntervalle(1, 2);
        System.out.print("Notes de l'UE" + choixUe + " semestre " + choixS + ": ");
        switch (choixUe) {
            case 1:
                if (choixS == 1) {
                    afficherEntiers(ue1s1, tailleUe1s1);
                } else {
                    afficherEntiers(ue1s2, tailleUe1s2);
                }
                break;
            case 2:
                if (choixS == 1) {
                    afficherEntiers(ue2s1, tailleUe2s1);
                } else {
                    afficherEntiers(ue2s2, tailleUe2s2);
                }
                break;
            case 3:
                if (choixS == 1) {
                    afficherEntiers(ue3s1, tailleUe3s1);
                } else {
                    afficherEntiers(ue3s2, tailleUe3s2);
                }
                break;
            default:
                System.out.println("erreur de programme");
                break;
        }
    }

    /**
     * Affiche tous les entiers d'un tableau
     *
     * @param ue tableau de valeur de l'ue
     * @param tailleUe taille du tableau de l'ue
     */
    static void afficherEntiers(int[] ue, int tailleUe) {
        for (int i = 0; i < tailleUe; i++) {
            System.out.printf("%2d / %2d  ", ue[i], NOTE_MAX);
        }
        System.out.println("");
    }

    /**
     * Fonction qui affiche les statistiques
     *
     * @param ueS1 le tableau de valeur du semestre 1
     * @param ueS2 le tableau de valeur du semestre 2
     * @param tUeS1 la taille du tableau du semestre 1
     * @param tUeS2 la taille du tableau du semestre 2
     * @param ue le numéro de l'ue
     * @return la moyenne de l'ue
     */
    static double afficherStatistique(int[] ueS1, int[] ueS2, int tUeS1, int tUeS2, int ue) {
        int min = 0;
        int max = 0;
        double avg = 0.0;
        double moyenneUe = 0.0;
        min = gestionNoteMin(ueS1, tUeS1);
        max = gestionNoteMax(ueS1, tUeS1);
        avg = gestionNoteMoy(ueS1, tUeS1);
        moyenneUe += avg;
        System.out.printf("UE%d| moy: %05.2f min: %2d max : %2d", ue, avg, min, max);
        min = gestionNoteMin(ueS2, tUeS2);
        max = gestionNoteMax(ueS2, tUeS2);
        avg = gestionNoteMoy(ueS2, tUeS2);
        moyenneUe += avg;
        System.out.printf("        | moy: %05.2f min: %2d max : %2d", avg, min, max);
        System.out.println("");
        return moyenneUe / 2;
    }

    /**
     * Afficher l'ensemble des moyennes, notes max et notes min des semestres
     * des ue Ainsi que la moyenne de l'année
     *
     * @param ue1s1 tableau de valeur ue1s1
     * @param tailleUe1s1 taille du tableau ue1s1
     * @param ue1s2 tableau de valeur ue1s2
     * @param tailleUe1s2 taille du tableau ue1s2
     * @param ue2s1 tableau de valeur ue2s1
     * @param tailleUe2s1 taille du tableau ue2s1
     * @param ue2s2 tableau de valeur ue2s2
     * @param tailleUe2s2 taille du tableau ue2s2
     * @param ue3s1 tableau de valeur ue3s1
     * @param tailleUe3s1 taille du tableau ue3s1
     * @param ue3s2 tableau de valeur ue3s2
     * @param tailleUe3s2 taille du tableau ue3s2
     */
    static void etuAfficherInfoDesUE(
            int[] ue1s1, int tailleUe1s1,
            int[] ue1s2, int tailleUe1s2,
            int[] ue2s1, int tailleUe2s1,
            int[] ue2s2, int tailleUe2s2,
            int[] ue3s1, int tailleUe3s1,
            int[] ue3s2, int tailleUe3s2) {
        double moyenneAnnee = 0.0;
        System.out.println("                  S1                    |                   S2                 ");
        System.out.println("-----------------------------------------------------------------------");
        moyenneAnnee += afficherStatistique(ue1s1, ue1s2, tailleUe1s1, tailleUe1s2, 1);
        moyenneAnnee += afficherStatistique(ue2s1, ue2s2, tailleUe2s1, tailleUe2s2, 2);
        moyenneAnnee += afficherStatistique(ue3s1, ue3s2, tailleUe3s1, tailleUe3s2, 3);
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Moyenne de l'année %05.2f", moyenneAnnee / 3.0);
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------");
    }

    /**
     * Donne le minimum du tableau
     *
     * @param ue tableau de valeur de l'ue
     * @param tailleUe taille du tableau de l'ue
     * @return le minimum du tableau
     */
    static int gestionNoteMin(int[] ue, int tailleUe) {
        int minimum = ue[0];
        for (int i = 1; i < tailleUe; i++) {
            if (ue[i] < minimum) {
                minimum = ue[i];
            }
        }
        return minimum;
    }

    /**
     * Donne le maximum du tableau
     *
     * @param ue tableau de valeur de l'ue
     * @param tailleUe taille du tableau de l'ue
     * @return la valeur maximum du tableau
     */
    static int gestionNoteMax(int[] ue, int tailleUe) {
        int maximum = ue[0];
        for (int i = 1; i < tailleUe; i++) {
            if (ue[i] > maximum) {
                maximum = ue[i];
            }
        }
        return maximum;
    }

    /**
     * Donne la moyenne des valeur du tableau
     *
     * @param ue tableau de valeur de l'ue
     * @param tailleUe taille du tableau de l'ue
     * @return la moyenne des valeur du tableau
     */
    static double gestionNoteMoy(int[] ue, int tailleUe) {
        double moyenne = 0.0;
        for (int i = 0; i < tailleUe; i++) {
            moyenne = moyenne + ue[i];
        }
        moyenne = moyenne / tailleUe;
        return moyenne;

    }

    /**
     * Affiche si quelle note permet a la table d'avoir la moyenne sur 20
     *
     * @param ue1s1 tableau de valeur ue1s1
     * @param tailleUe1s1 taille du tableau ue1s1
     * @param ue1s2 tableau de valeur ue1s2
     * @param tailleUe1s2 taille du tableau ue1s2
     * @param ue2s1 tableau de valeur ue2s1
     * @param tailleUe2s1 taille du tableau ue2s1
     * @param ue2s2 tableau de valeur ue2s2
     * @param tailleUe2s2 taille du tableau ue2s2
     * @param ue3s1 tableau de valeur ue3s1
     * @param tailleUe3s1 taille du tableau ue3s1
     * @param ue3s2 tableau de valeur ue3s2
     * @param tailleUe3s2 taille du tableau ue3s2
     */
    static void etuAfficherNoteAObtenir(int[] ue1s1, int tailleUe1s1,
            int[] ue1s2, int tailleUe1s2,
            int[] ue2s1, int tailleUe2s1,
            int[] ue2s2, int tailleUe2s2,
            int[] ue3s1, int tailleUe3s1,
            int[] ue3s2, int tailleUe3s2) {
        int choixUe = 0;
        int choixS = 0;
        System.out.println("Choisi un UE entre 1 et 3");
        choixUe = gestionDeSaisieNombreIntervalle(1, 3);
        System.out.println("Choisi un semestre entre 1 et 2");
        choixS = gestionDeSaisieNombreIntervalle(1, 2);
        switch (choixUe) {
            case 1:
                if (choixS == 1) {
                    etuNoteAObtenir(ue1s1, tailleUe1s1);
                } else {
                    etuNoteAObtenir(ue1s2, tailleUe1s2);
                }
                break;
            case 2:
                if (choixS == 1) {
                    etuNoteAObtenir(ue2s1, tailleUe2s1);
                } else {
                    etuNoteAObtenir(ue2s2, tailleUe2s2);
                }
                break;
            case 3:
                if (choixS == 1) {
                    etuNoteAObtenir(ue3s1, tailleUe3s1);
                } else {
                    etuNoteAObtenir(ue3s2, tailleUe3s2);
                }
                break;
            default:
                System.out.println("erreur de programme");
        }
    }

    /**
     * Fonction qui cherche quelle note permet d'avoir la moyenne
     *
     * @param ue tableau de valeur de l'ue
     * @param tailleUe taille du tableau ue
     */
    static void etuNoteAObtenir(int[] ue, int tailleUe) {
        double avg = 0;
        int i = 1;
        if (tailleUe > MAX_NOTE - 1) {
            System.out.println("Il n'y aura pas d'autre évalutation");
        } else if (tailleUe < MAX_NOTE) {
            double b = gestionNoteMoy(ue, tailleUe + 1);
            int taille = tailleUe + 1;
            if (b >= 10) {
                System.out.println("Même avec un 0 a la prochaine évaluation, tu auras la moyenne");

            } else {
                while ((avg / taille) < 10 && i < NOTE_MAX + 1) {
                    avg = (b * taille) + i;
                    i++;
                }
                if ((i) < NOTE_MAX + 1) {
                    System.out.println("il faut qu'a la prochaine évaluation tu es " + (i - 1) + "/" + NOTE_MAX);
                } else {
                    System.out.println("Ce n'est plus possible d'augmenter ta note ce semestre");
                }
            }

        }
    }

    /**
     * Affiche si l'année est validé
     *
     * @param ue1s1 tableau de valeur ue1s1
     * @param tailleUe1s1 taille du tableau ue1s1
     * @param ue1s2 tableau de valeur ue1s2
     * @param tailleUe1s2 taille du tableau ue1s2
     * @param ue2s1 tableau de valeur ue2s1
     * @param tailleUe2s1 taille du tableau ue2s1
     * @param ue2s2 tableau de valeur ue2s2
     * @param tailleUe2s2 taille du tableau ue2s2
     * @param ue3s1 tableau de valeur ue3s1
     * @param tailleUe3s1 taille du tableau ue3s1
     * @param ue3s2 tableau de valeur ue3s2
     * @param tailleUe3s2 taille du tableau ue3s2
     */
    static void etuAfficherAnneeValide(int[] ue1s1, int tailleUe1s1,
            int[] ue1s2, int tailleUe1s2,
            int[] ue2s1, int tailleUe2s1,
            int[] ue2s2, int tailleUe2s2,
            int[] ue3s1, int tailleUe3s1,
            int[] ue3s2, int tailleUe3s2) {
        boolean ue1 = false;
        boolean ue2 = false;
        boolean ue3 = false;
        int compteur = 0;
        if (gestionNoteMoy(ue1s1, tailleUe1s1) >= 8.0 && gestionNoteMoy(ue1s2, tailleUe1s2) >= 8.0 && (gestionNoteMoy(ue1s1, tailleUe1s1) + gestionNoteMoy(ue1s2, tailleUe1s2)) / 2 >= 10.0) {
            ue1 = true;
            compteur += 1;
        }
        if (gestionNoteMoy(ue2s1, tailleUe2s1) >= 8.0 && gestionNoteMoy(ue2s2, tailleUe2s2) >= 8.0 && (gestionNoteMoy(ue2s1, tailleUe2s1) + gestionNoteMoy(ue2s2, tailleUe2s2)) / 2 >= 10.0) {
            ue2 = true;
            compteur += 1;
        }
        if (gestionNoteMoy(ue3s1, tailleUe3s1) >= 8.0 && gestionNoteMoy(ue3s2, tailleUe3s2) >= 8.0 && (gestionNoteMoy(ue3s1, tailleUe3s1) + gestionNoteMoy(ue3s2, tailleUe3s2)) / 2 >= 10.0) {
            ue3 = true;
            compteur += 1;
        }
        double moyenneAnnée = (gestionNoteMoy(ue1s1, tailleUe1s1) + gestionNoteMoy(ue1s2, tailleUe1s2)) + (gestionNoteMoy(ue2s1, tailleUe2s1) + gestionNoteMoy(ue2s2, tailleUe2s2)) + (gestionNoteMoy(ue3s1, tailleUe3s1) + gestionNoteMoy(ue3s2, tailleUe3s2));
        if (compteur >= 2 && moyenneAnnée >= 10) {
            System.out.println("L'année est validée");
        } else {
            System.out.println("Année non validée pour le moment");
        }

    }

    /**
     * Affiche les notes des étudiants ainsi que leur absence et la moyenne de
     * chaque UE
     *
     * @param ue une matrice de note
     * @param absUe une matrice d'absence
     */
    static void afficherInformationGeneral(double[][] ue, boolean[][] absUe) {
        double moyUe1 = 0.;
        double moyUe2 = 0.;
        double moyUe3 = 0.;
        for (int compteur = 1; compteur <= 2; compteur++) {
            if (compteur == 1) {
                System.out.println("************************Notes Des Etudiant***************************");
            } else {
                System.out.println("************************Absences Des Etudiants***************************");
            }
            for (int etu = 1; etu <= NB_ETU; etu++) {
                System.out.print("Etudiant numéro " + etu);
                if (compteur == 1) {
                    moyUe1 += ue[etu - 1][0];
                    moyUe2 += ue[etu - 1][1];
                    moyUe3 += ue[etu - 1][2];
                }
                for (int ueS = 1; ueS <= 3; ueS++) {
                    if (compteur == 1) {
                        System.out.printf("\tUE%1d : %05.2f", ueS, (ue[etu - 1][ueS - 1]));
                    } else {
                        System.out.printf("\tUE%1d : ", ueS);
                        if (absUe[etu - 1][ueS - 1]) {
                            System.out.print("X\t");
                        } else {
                            System.out.print("0\t");
                        }
                    }
                }
                System.out.println("");

            }

        }
        System.out.println("************************Moyennes Des UE***************************");
        System.out.printf("moyenne de l'UE1 : %05.2f", (moyUe1 / NB_ETU));
        System.out.println("");
        System.out.printf("moyenne de l'UE2 : %05.2f", (moyUe2 / NB_ETU));
        System.out.println("");
        System.out.printf("moyenne de l'UE3 : %05.2f", (moyUe3 / NB_ETU));
        System.out.println("");

    }

    /**
     * Fonction qui modifie une valeur dans une matrice
     *
     * @param ue une matrice de note
     *
     */
    static void nouvelleNote(double[][] ue) {
        System.out.println("Quelle est le numéro de l'étudiant qui a rattraper ?");
        int numEtu = gestionDeSaisieNombreIntervalle(1, NB_ETU) - 1;
        System.out.println("Quelle Ue ?");
        int numUe = gestionDeSaisieNombreIntervalle(1, 3) - 1;
        System.out.println("Quelle est sa nouvelle note ?");
        Scanner sc = new Scanner(System.in);
        double newNoteObtenu = sc.nextDouble();
        modifNoteUe(ue, numEtu, numUe, newNoteObtenu);
    }

    /**
     * Fonction qui modifie une valeur dans une matrice
     *
     * @param ue une matrice de note
     * @param numEtu numéro étudiant
     * @param numUe numéro de l'UE
     * @param newNoteObtenu nouvelle note a entrer
     */
    static void modifNoteUe(double[][] ue, int numEtu, int numUe, double newNoteObtenu) {
        if (Double.compare(newNoteObtenu, (ue[numEtu][numUe])) == 0) {
            System.out.println("note inchanger");
        } else if (Double.compare(newNoteObtenu, ue[numEtu][numUe]) < 0) {
            System.out.println("La note est inférieur donc il garde son ancienne note");
        } else {
            System.out.print("Cette note est plus élever que la précédente");
            if (Double.compare(newNoteObtenu, gestionMoyMax(ue, numEtu)) < 0) {
                System.out.println(" et ne dépace pas sa meilleur note ");
                System.out.println("note modifier");
                ue[numEtu][numUe] = newNoteObtenu;
            } else {
                System.out.println(" mais dépaces toutes ces précédentes notes");
                System.out.println("note maximum dupliqué");
                ue[numEtu][numUe] = gestionMoyMax(ue, numEtu);
            }
        }
    }

    /**
     * fonction qui cherche la valeur maximal dans une matrice pour un étudiant
     *
     * @param ue un matrice de note
     * @param numEtu un numéro d'étudiant
     * @return la note maximal
     */
    static double gestionMoyMax(double ue[][], int numEtu) {
        double maximum = ue[numEtu][0];
        for (int i = 1; i < ue[0].length; i++) {
            if (ue[numEtu][i] > maximum) {
                maximum = ue[numEtu][i];
            }
        }
        return maximum;

    }

    /**
     * Fonction qui détermine si l'étudiant peut être convoquer au rattrapage
     * d'une épreuve
     *
     * @param ue une matrice de note
     * @param absUe une matrice d'absence
     */
    static void rattrapageUE(double ue[][], boolean absUe[][]) {
        int e = 0;
        boolean rattra = false;
        for (int i = 0; i < ue.length; i++) {
            boolean statue = verifAbsence(absUe, i);
            if (statue == true) {
                System.out.println("Pas de rattrapage pour l'étudiant numéro " + (i + 1));
            } else {
                while (e < ue[0].length && rattra == false) {
                    if (ue[i][e] < 10) {
                        System.out.println("Il faut convoquer l'étudiant " + (i + 1));
                        rattra = true;
                    }
                    e++;
                }
                if (rattra == false) {
                    System.out.println("Pas de rattrapage pour l'étudiant numéro " + (i + 1));
                }
            }
        }

    }

    /**
     * Fonction qui vérifie si l'étudiant a était absence lors d'au moins un
     * devoir
     *
     * @param absUe matrice d'absence
     * @param numEtu numéro de l'étudiant
     * @return vrai si il a était absent sans justification sinon faux
     */
    static boolean verifAbsence(boolean absUe[][], int numEtu) {
        int i = 0;
        boolean statue = false;
        /* ici false signifie qu'il n'a pas eu d'absence du tout */
        while (i < absUe[0].length && statue == false) {
            if (absUe[numEtu][i] == true) {
                statue = true;
            }
            i++;
        }
        return statue;

    }
}
