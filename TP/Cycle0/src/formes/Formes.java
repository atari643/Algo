/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formes;

/**
 *
 * @author qartigala
 */
public class Formes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        messageAccueil();
    }

    static char formeCorrecte(int niveau) {
        char forme = ' ';
        if (niveau == 1 || niveau == 2) {
            forme = 'c';
        } else {
            forme = 't';
        }
        return forme;
    }
    static int surfaceCorrect(int niveau){
        int surface = -1;
        if (niveau == 1){
            surface = 9;
        }else if (niveau == 2) {
            surface = 25;
        }else if (niveau == 3) {
            surface = 2;
        }else if (niveau == 4){
            surface = 14;
                   }
    }
            
        return surface
    }

    static void messageAccueil() {
        System.out.println("Bienvenue dans le jeu des formes") ;
    }
    
}
