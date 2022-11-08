/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cycle1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author qartigala
 */
public class Cycle1 {

    /**
     * Niveau de difficulté minimum.
     */
    final static int DIFFICULTE_MIN = 1;
    /**
     * Niveau de difficulté maximum.
     */
    final static int DIFFICULTE_MAX = 3;
    /**
     * Niveau de passager minimum.
     */
    final static int PASSAGER_MIN = 1;
    /**
     * Taille de la course.
     */
    final static int TAILLE_COURSE = 10;

    /**
     * execute la fonction principal du jeux
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        jeuAventure_menuPrincipal();
    }

    /**
     * La fonction est le bloc principal du code où on initisialise toute les
     * fonctions principales du jeux. Elle sert aussi de compteur de partie
     * jouer et aussi celle gagner. l'affichage du menu ainsi que l'affichage de
     * la page de game over, sont afficher par cette fonction
     */
    static void jeuAventure_menuPrincipal() {
        int partiesGagnees = 0;
        int partiesJouees = 0;
        boolean jeuTermine = false;
        int reponse = 0;
        do {
            boolean etatJeu = false;
            affichermenu();
            reponse = jeuAventure_saisirNombreIntervalle(1, 5);
            partiesJouees += 1;
            switch (reponse) {
                case 1:
                    etatJeu = jeuSuite_principal();
                    break;
                case 2:
                    etatJeu = jeuTrain_principal();
                    break;
                case 3:
                    etatJeu = jeuCourse_principal();
                    break;
                case 4:
                    etatJeu = jeuDevin_principal();
                    break;
            }
            if (etatJeu == true) {
                partiesGagnees += 1;
            }
        } while (reponse != 5);
        partiesJouees -= 1;
        jeuTermine = true;
        jeuAventure_partieTerminer(partiesGagnees, partiesJouees);

    }

    /**
     * Gestion de l'affichage du menu de début du jeu
     *
     * @return le menu du jeu
     */
    static void affichermenu() {
        System.out.println("           \\\\\\||||||////\n"
                + "            \\\\  ~ ~  //\n"
                + "             (  @ @  )\n"
                + "    ______ oOOo-(_)-oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (1) trouver la suite " + "\n"
                + "\t (2) jeu du train " + "\n"
                + "\t (3) course en ligne " + "\n"
                + "\t (4) le devin " + "\n"
                + "\t (5) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)");

    }

    /**
     * cette fonction montre l'écran de fin avec le nombre de partie jouer et
     * gagner
     *
     * @param partieGagnee le nombre de partie gagner
     * @param partieJouee le nombtre total de partie jouer
     */
    static void jeuAventure_partieTerminer(int partieGagnee, int partieJouee) {
        System.out.println("   .____________________.\n"
                + "   |.------------------.|\n"
                + "   ||                  ||\n"
                + "   ||    GAME OVER     ||\n"
                + "   ||Parties jouées: " + partieJouee + " ||\n"
                + "   ||                  ||\n"
                + "   ||Parties gagnées: " + partieGagnee + "||\n"
                + "   ||__________________||\n"
                + "   /.-.-.-.-.-.-.-.-.-.-\\\n"
                + "  /.-.-.-.-.-.-.-.-.-.-.-\\\n"
                + " /.-.-.-.-.-.-.-.-.-.-.-.-\\\n"
                + "/______/__________\\___o____\\    \n"
                + "\\__________________________"
                + "/");
    }

    /**
     * Fonction qui permet a l'utilisateur de selectionner un nombre dans un
     * intervalle donné
     *
     * @param min le plus petit nombre de l'intervalle
     * @param max le plus grand nombre de l'intervalle
     * @return renvoie le choix de l'utilisateur
     */
    static int jeuAventure_saisirNombreIntervalle(int min, int max) {
        int saisie = 0;
        do {
            System.out.println("choisi un nombre entre " + min + " et " + max);
            saisie = jeuAventure_nombreChoisi();
            if (saisie < min || saisie > max) {
                System.out.println("erreur hors intervalle reesaye");
            }
        } while (saisie < min || saisie > max);
        return saisie;
    }

    /**
     * Permet au joueur de choisir un nombre
     *
     * @return le nombre choisi
     */
    static int jeuAventure_nombreChoisi() {
        Scanner sc = new Scanner(System.in);
        int saisie = sc.nextInt();
        return saisie;
    }

    /**
     * Permet au joueur de choisir un caractère
     *
     * @return le caractère choisi
     */
    static char jeuAventure_caractereChoisi() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char caract = str.charAt(0);
        return caract;
    }

    /**
     * C'est une fonction qui utilise la fonction
     * jeuAventure_saisirNombreIntervalle() avec sont propres intervalle de
     * nombre détérminer par deux constante: DIFFICULTE_MIN et DIFFICULTE_MAX
     *
     * @return renvoie la reponse de l'utilisateur
     */
    static int jeuAventure_saisirNiveauDifficulte() {
        System.out.println("selection un niveau de difficulté entre 1 et 3");
        return jeuAventure_saisirNombreIntervalle(DIFFICULTE_MIN, DIFFICULTE_MAX);
    }

    /**
     * renvoie les règles du jeu de Suite
     *
     * @return le texte de la règle
     */
    static void jeuSuite_afficherRegles() {
        System.out.println("Voici une suite de caractère répétitif à 3 niveau de difficulte: saurait vous trouver le prochain symbole ?");
    }

    /**
     * renvoie les règles du jeu du Train
     *
     * @return le texte de la règle
     */
    static void jeuTrain_afficherRegles() {
        System.out.println("On a un certain nombre de passager par niveau de difficulté et on doit déterminer combien il faut de wagon (1 wagon = 1 personne)");
    }

    /**
     * renvoie les règles du jeu de course
     *
     * @return le texte de la règle
     */
    static void jeuCourse_afficherRegles() {
        System.out.println("On a trois pistes de course avec trois symbole qui représente les coureures. Le but est de les faire avancer d'un certain nombre de case (entre 1 et 3) et être le premier a arriver a la dernière ligne. Attention les symboles ne peuvent pas être sur la même ligne ");
    }

    /**
     * renvoie les règles du jeu du Devin
     *
     * @return le texte de la règle
     */
    static void jeuDevin_afficherRegles() {
        System.out.println("Le but du jeu est simple. Tu dois trouver un nombre compris dans un intervalle qui varie selon la difficulté ");
        System.out.println("difficulté 1: tirage facile en moins de 5 coup, d'un nombre entre 0 et 10");
        System.out.println("difficulté 2: tirage facile en moins de 10 coup, d'un nombre entre 0 et 50");
        System.out.println("difficulté 3: tirage facile en moins de 10 coup, d'un nombre entre 0 et 100");
    }

    /**
     * Fonction qui annonce au joueur la difficulte du jeu
     *
     * @param niveauDifficulte la difficulte choisi
     */
    static void jeuAventure_annonceDifficulté(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 1:
                System.out.println("difficulté 1");
                break;
            case 2:
                System.out.println("difficulté 2");
                break;
            case 3:
                System.out.println("difficulté 3");
                break;
            default:
                System.out.println("erreur de saisie");
                break;
        }
    }

    /**
     * execute le jeu des suite
     *
     * @return si le jeu est gagné il revoie true si c'est perdu il renvoie
     * false
     */
    static boolean jeuSuite_principal() {
        jeuSuite_afficherRegles();
        int niveauDifficulte = jeuAventure_saisirNiveauDifficulte();
        jeuAventure_annonceDifficulté(niveauDifficulte);
        return jeuSuite_partie(niveauDifficulte);

    }

    /**
     * Fonction qui execute la partie du jeu de suite dans une difficulté donnée
     * Cela affiche les suites prédéfini et permet au joueur de les compléter
     * selon l'attendu de la suite
     *
     * @param niveauDifficulte utilise les niveaux de Difficulte pour choisir la
     * suite
     * @return renvoie vrai si la partie a était gagnée sinon faux
     */
    static boolean jeuSuite_partie(int niveauDifficulte) {
        boolean resultat = false;
        switch (niveauDifficulte) {
            case 1:
                jeuSuite_afficherFormes('♣', '♥', '♣', '♥', ' ');
                break;
            case 2:
                jeuSuite_afficherFormes('♥', '♥', '♣', '♣', ' ');
                break;
            case 3:
                jeuSuite_afficherFormes('♣', '♥', '♠', '♣', ' ');
                break;

        }
        char saisie = jeuSuite_saisirForme();
        char reponse = jeuSuite_formeCorrecte(niveauDifficulte);
        if (saisie == reponse) {
            System.out.println("bravo vous avez gagnée");
            resultat = true;

        } else {
            System.out.println("vous avez perdu");

        }
        return resultat;
    }

    /**
     * Fonction qui créer un paterne d'une suite avec les formes a prédéfinir
     *
     * @param c1 la première forme
     * @param c2 la deuxième forme
     * @param c3 la troisième forme
     * @param c4 la quatrième forme
     * @param c5 la cinquième forme
     */
    static void jeuSuite_afficherFormes(char c1, char c2, char c3, char c4, char c5) {
        System.out.println("  - - - - -\n "
                + "|" + c1 + "|" + c2 + "|" + c3 + "|" + c4 + "|" + c5 + "|" + "\n" + "  - - - - -");
    }

    /**
     * Permet a l'utilisateur de saisir une forme grâce a des lettres
     *
     * @return cela retourne la forme choisi par le joueur
     */
    static char jeuSuite_saisirForme() {
        char saisieForme = ' ';
        char symbole = ' ';
        System.out.println("Choisi une forme entre les caractères 'c' ♥ ou 't' ♣ ou 'p' ♠ ");
        char caract = jeuAventure_caractereChoisi();
        saisieForme = caract;
        switch (saisieForme) {
            case 'c':
                symbole = '♥';
                break;

            case 't':
                symbole = '♣';
                break;

            case 'p':
                symbole = '♠';
                break;

            default:
                System.out.println("erreur caractère inconnu");
                symbole = jeuSuite_saisirForme();
                break;
        }
        return symbole;
    }

    /**
     * Permet a l'ordi de savoir quelle symbole est attendu selon le niveau de
     * difficulté
     *
     * @param niveauDifficulte le niveau de difficulté
     * @return retourne une forme selon le niveau
     */
    static char jeuSuite_formeCorrecte(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 1:
                return '♣';
            case 2:
                return '♥';
            case 3:
                return '♥';

        }
        return ' ';
    }

    /**
     * execute le jeu des Train
     *
     * @return si le jeu est gagné il revoie true si c'est perdu il renvoie
     * false
     */
    static boolean jeuTrain_principal() {
        jeuTrain_afficherRegles();
        int niveauDifficulte = jeuAventure_saisirNiveauDifficulte();
        jeuAventure_annonceDifficulté(niveauDifficulte);
        return jeuTrain_partie(niveauDifficulte);
    }

    /**
     * Execute la partie du jeux du train
     *
     * @param niveauDifficulte le niveau de difficulte du jeu
     * @return retourne vrai si la partie est réussi sinon faux
     */
    static boolean jeuTrain_partie(int niveauDifficulte) {
        int nbUsager = 0;
        int nbWagon = 0;
        int max = 0;
        int tmp = 0;
        char smiley = '☺';
        boolean resultat = false;
        switch (niveauDifficulte) {
            case 1:
                max = 2;
                break;
            case 2:
                max = 3;
                break;
            case 3:
                max = 4;
                break;
        }
        Random random = new Random();
        nbUsager = random.nextInt(max - PASSAGER_MIN + 1) + PASSAGER_MIN;
        for (int i = 0; i < nbUsager; i++) {
            System.out.print('☺');
        }
        System.out.println("");
        System.out.println("Combien il faut de wagon ?");
        nbWagon = jeuAventure_nombreChoisi();
        tmp = nbUsager;
        for (int i = 0; i < nbWagon; i++) {
            System.out.println(""
                    + "  —————\n"
                    + "  |   |");
            if (nbUsager > 0) {
                System.out.println("  | ☺ |");
                nbUsager -= 1;
            } else {
                System.out.println("  |   |");
            }
            System.out.println(""
                    + "  |   |\n"
                    + "  —————\n"
                    + "    |  ");
        }
        System.out.println("    |\n"
                + "   |||\n"
                + " .-----.\n"
                + " |o< >o|\n"
                + "//// \\\\\\\\\n"
                + "  /---\\ \n"
                + " /-----\\"
        );
        if (nbUsager != 0) {
            System.out.print("Perdu pas assez de wagon, des passagers sont rester a quai: ");
            for (int e = 0; e < nbUsager; e++) {
                System.out.print(smiley);
            }
            System.out.println("");
        } else if (nbWagon == tmp) {
            System.out.println("Vous avez gagnée");
            resultat = true;
        } else {
            System.out.println("Vous avez perdu. Trop de wagon");

        }
        return resultat;
    }

    /**
     * execute le jeu des Course
     *
     * @return si le jeu est gagné il revoie true si c'est perdu il renvoie
     * false
     */
    static boolean jeuCourse_principal() {
        jeuCourse_afficherRegles();
        return jeuCourse_partie();
    }

    /**
     * Fonction qui permet d'afficher la course a chaque changement
     *
     * @param posJ1 la position du premier courreur
     * @param posJ2 la position du deuxième courreur
     * @param posJ3 la position du troisième courreur
     */
    static void jeuCourse_afficherCourse(int posJ1, int posJ2, int posJ3) {
        String J1 = "|♥";
        String J2 = "|♣";
        String J3 = "|♠";
        System.out.println(" - - - - - - - - - ARRIVEE");
        jeuCourse_afficherLigne(J1, posJ1);
        jeuCourse_afficherLigne(J2, posJ2);
        jeuCourse_afficherLigne(J3, posJ3);
        System.out.println(" - - - - - - - - - ARRIVEE");
    }

    /**
     * Fonction qui dessine la ligne selon le symbole du joueur et la position
     * voulu
     *
     * @param J le symbole du joueur
     * @param posJ la position voulu du joueur
     */
    static void jeuCourse_afficherLigne(String J, int posJ) {
        String defaut = "| ";
        int i = 0;
        for (int e = i; i < posJ; i++) {
            System.out.print(defaut);
        }
        System.out.print(J);
        for (int y = i; y < TAILLE_COURSE; y++) {
            System.out.print(defaut);
        }
        System.out.println("");

    }

    /**
     * Fonction qui execute l'entiereter d'une partie avec joueur 1 et joueur 2
     *
     * @return si joueur 1 gagne alors retourne vrai sinon retourne faux
     */
    static boolean jeuCourse_partie() {
        int posJ1 = 0;
        int posJ2 = 0;
        int posJ3 = 0;
        int joueur = 2;
        int ligne = 0;
        int deplacement = 0;
        boolean statue = false;
        boolean resultat = false;
        do {
            jeuCourse_afficherCourse(posJ1, posJ2, posJ3);
            joueur = jeuCourse_joueurSuivant(joueur);
            System.out.print("Pour la ligne, ");
            ligne = jeuAventure_saisirNombreIntervalle(1, 3);
            do {
                statue = true;
                System.out.print("Pour savoir combien de case, ");
                deplacement = jeuAventure_saisirNombreIntervalle(1, 3);
                System.out.print("la colonne ne doit pas être occuper sinon rechoisie un chiffe");
                System.out.println("");
                switch (ligne) {
                    case 1:
                        posJ1 += deplacement;
                        if (posJ2 == posJ1 || posJ3 == posJ1) {
                            posJ1 -= deplacement;
                            statue = false;
                        }
                        break;
                    case 2:
                        posJ2 += deplacement;
                        if (posJ1 == posJ2 || posJ3 == posJ2) {
                            posJ2 -= deplacement;
                            statue = false;
                        }
                        break;
                    case 3:
                        posJ3 += deplacement;
                        if (posJ2 == posJ3 || posJ1 == posJ3) {
                            posJ3 -= deplacement;
                            statue = false;
                        }
                        break;
                }

            } while (statue != true);

        } while (posJ1 < TAILLE_COURSE && posJ2 < TAILLE_COURSE && posJ3 < TAILLE_COURSE);
        System.out.println("Le joueur " + joueur + " a gagnée");
        if (joueur == 1) {
            resultat = true;
        }
        jeuCourse_afficherCourse(posJ1, posJ2, posJ3);
        return resultat;

    }

    /**
     * Fonction qui indique quelle joueur joue
     *
     * @param joueurActif le joueur qui a jouer précédement
     * @return le joueur suivant
     */
    static int jeuCourse_joueurSuivant(int joueurActif) {
        if (joueurActif == 1) {
            System.out.println("joueur 2 a toi");
            return 2;
        } else {
            System.out.println("joueur 1 a toi");
            return 1;
        }

    }

    /**
     * execute le jeu des Devin
     *
     * @return si le jeu est gagné il revoie true si c'est perdu il renvoie
     * false
     */
    static boolean jeuDevin_principal() {
        int tirage = 0;
        int coup = 0;
        jeuDevin_afficherRegles();
        int niveauDifficulte = jeuAventure_saisirNiveauDifficulte();
        switch (niveauDifficulte) {
            case 1:
                System.out.println("difficulté 1");
                System.out.println("vous devez trouver un nombre entre 0 et 10");
                break;
            case 2:
                System.out.println("difficulté 2");
                System.out.println("vous devez trouver un nombre entre 0 et 50");
                break;
            case 3:
                System.out.println("difficulté 3");
                System.out.println("vous devez trouver un nombre entre 0 et 100");
                break;
            default:
                System.out.println("erreur de saisie");
                break;
        }
        tirage = jeuDevin_tirage(niveauDifficulte);
        coup = jeuDevin_coupAJouer(niveauDifficulte);
        return jeuDevin_partie(niveauDifficulte, tirage, coup);
    }

    /**
     * Fonction qui fait un tirage random d'un nombre dans un intervalle donné
     *
     * @param niveauDifficulte la difficulte du jeu
     * @return un nombre aléatoire d'un intervalle
     */
    static int jeuDevin_tirage(int niveauDifficulte) {
        int min = 0;
        int max = 0;
        switch (niveauDifficulte) {
            case 1:
                max = 10;
                break;
            case 2:
                max = 50;
                break;
            case 3:
                max = 100;
                break;

        }
        Random random = new Random();
        int tirage = random.nextInt(max - min + 1) + min;
        return tirage;

    }

    /**
     * Définie le nombre de coup selon la difficulté
     *
     * @param niveauDifficulte la difficulté du jeu
     * @return le nombre de coup possible
     */
    static int jeuDevin_coupAJouer(int niveauDifficulte) {
        int coup = 0;
        if (niveauDifficulte == 1) {
            coup = 4;
        } else {
            coup = 9;
        }
        return coup;
    }

    /**
     * Laisse qui donne l'intervalle selon la difficulté du jeu
     *
     * @param niveauDifficulte la difficulté du jeu
     * @return un nombre
     */
    static int jeuDevin_choixDuJoueur(int niveauDifficulte) {
        int choix = 0;
        switch (niveauDifficulte) {
            case 1:
                choix = jeuAventure_saisirNombreIntervalle(0, 10);
                break;
            case 2:
                choix = jeuAventure_saisirNombreIntervalle(0, 50);
                break;
            case 3:
                choix = jeuAventure_saisirNombreIntervalle(0, 100);
                break;

        }
        return choix;
    }

    /**
     * execute une seul partie du jeu du Devin est détermine si la partie est
     * gagnée dans les règles
     *
     * @param niveauDifficulte la difficulté du jeu
     * @param tirage le nombre a atteindre
     * @param coup le nombre de coup possible
     * @return retourne vrai si le nombre de coup est respecté ainsi que
     * l'équalité sinon renvoie faux
     */
    static boolean jeuDevin_partie(int niveauDifficulte, int tirage, int coup) {
        boolean resultat = false;
        int saisie = 0;
        do {
            System.out.println("Vous avez " + coup + " coup a jouer");
            System.out.println("");
            saisie = jeuDevin_choixDuJoueur(niveauDifficulte);
            if (saisie > tirage) {
                System.out.println("nombre trop grand");

            } else if (saisie < tirage) {
                System.out.println("nombre trop petit");
            }
            coup -= 1;
        } while (coup != 0 && tirage != saisie);
        if (coup == 0 && tirage != saisie) {
            System.out.println("Vous avez Perdu");
            resultat = false;

        } else {
            System.out.println("Vous avez Gagné");
            resultat = true;
        }
        return resultat;
    }
}
