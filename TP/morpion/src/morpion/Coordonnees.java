package morpion;

import java.util.Arrays;

/**
 * Coordonnées d'une case du plateau.
 */
class Coordonnees {

    /**
     * Numéro de la ligne.
     */
    int ligne;

    /**
     * Numéro de la colonne.
     */
    int colonne;

    /**
     * Constructeur prenant les numéros de ligne/colonne en paramètre.
     *
     * @param numLigne numéro de la ligne
     * @param numColonne numéro de la colonne
     */
    Coordonnees(int numLigne, int numColonne) {
        ligne = numLigne;
        colonne = numColonne;
    }

    /**
     * Renvoie les coordonnées de la case suivante, en suivant une direction
     * donnée.
     *
     * @param d la direction à suivre
     * @return les coordonnées de la case suivante
     */
    static Coordonnees suivante(Coordonnees c, Direction d) {
        return new Coordonnees(c.ligne + Direction.mvtVertic(d), 
                c.colonne + Direction.mvtHoriz(d));
    }

    /**
     * Indique si ces coordonnées sont dans le plateau.
     *
     * @param coord coordonnées à tester
     * @param taille taille du plateau (carré)
     * @return vrai ssi ces coordonnées sont dans le plateau
     */
    static boolean estDansPlateau(Coordonnees coord, int taille) {
        return coord.ligne<taille && coord.ligne>=0 && coord.colonne<taille && coord.colonne>=0; // TODO
    }

    /**
     * Retourne les coordonnées de toutes les cases voisines.
     * 
     * @param coord coordonnées de la case considérée
     * @param taille taille du plateau (carré)
     * @return les coordonnées de toutes les cases voisines
     */
    static Coordonnees[] voisines(Coordonnees coord, int taille) {
        Coordonnees[] voisines = new Coordonnees[8];
        int nbVoisines = 0;
        for(Direction d : Direction.values()){
              if (estDansPlateau(suivante(coord, d), taille)){
                  voisines[nbVoisines]=suivante(coord, d);
                  nbVoisines+=1;
              }
        }
        return Arrays.copyOf(voisines, nbVoisines);
    }
    
    @Override
    public String toString() {
        return "(" + ligne + "," + colonne + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnees other = (Coordonnees) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.ligne;
        hash = 53 * hash + this.colonne;
        return hash;
    }
    
    
}
