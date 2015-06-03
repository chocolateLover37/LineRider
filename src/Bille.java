import java.awt.Rectangle;

import java.util.ArrayList;

public class Bille extends Objet {

    public int rayon;
    double cosp, sinp;
    boolean memoirecollisionprecedente;
    Ligne ligneprecedente;
    int memoire=0;
   

    public Bille(int x, int y, double dx, double dy, Rectangle aframe,String nomImage) {
        //dy=0 au debut, dx=cste (m*g) ; //??dx c'est la composante verticale :o??
        super(x, y, dx, dy, aframe, nomImage);
        rayon = h; //rayon égal à la hauteur de l'image
       

    }


    public ReturnCollision collision(ArrayList<Ligne> listeligne, int distancedecollision) {
        // La méthode retourne un ReturnCollision contenant un booleen col qui indique si il y a collision
        // et une ligne i egale a la ligne avec laquelle il y a collision, ou egale a null sinon
        boolean col = false;
        Ligne lignecollision;

        java.util.Iterator<Ligne> iterator = listeligne.iterator();
        // On regarde la distance entre le centre de la bille et chaques courbes
        while (iterator.hasNext()) {
            lignecollision = iterator.next();
            double distancecourbe = lignecollision.distance((int) x, (int) y);
            // Si cette distance est inférieure au rayon : collision
            if (distancecourbe <= distancedecollision) {
                col = true;
                ReturnCollision retour = new ReturnCollision(lignecollision, col);
                return retour;
            }
        }
        // si il n'y a pas eu de distance inférieure au rayon, on retourne false et i =null
        ReturnCollision pasdechoc = new ReturnCollision(null, col);
        return pasdechoc;
    }

    public void move(ArrayList<Ligne> Listdeligne, long t) {
        //la methode modifie les coordonnées et les vitesses de la bille en fonction la gravite et de sa proximite avec une courbe

        double dt = 0.15; // temps de raffraichissement
        double g = 9.81; // la gravite
        double a = 1; //provisoire
        double ecmax = 100000000; // condition de rebond
        double coeff = 0.1; // facteur d'amortissement pour rebond
        double p=0;
        // enregistrement coordonnees avant l'appel de move
        		int xt = x;
                int yt = y;
                

                //  calcule la prochaine position de l'objet en chute libre
                x = (int) (x + dx * dt);
                y = (int) (y - (-0.5) * g * Math.pow(dt, 2) + dy * dt);


                // check la collision  ? la prochaine position
                ReturnCollision k = collision(Listdeligne, h/2);

                // recuperation du boolean et de la pente de la courbe (pente = null si pas de collision)
                Ligne l = k.getLigne();
                if (l!= null){
                    cosp = l.cosPente();
                    sinp = l.sinPente();
                }
                boolean collision = k.getBol();

                if (collision == false) {
                    // Cas 0 : pas de collision
                    // si il n'y a pas de collision alors on garde les coordonnees calculees
                    // Calcul des  nouvelles vitesses, dx ne change pas
                    dy = g * dt + dy;
                    if (memoire >5){
                    memoirecollisionprecedente = false;
                    memoire = 0;}
                    memoire++;
                }


                // sinon
                else {

                    //on retourne ? la position d'avant, la ou il n'y a pas encore collision
                    x = xt;
                    y = yt;
                    // on verifie si la vitesse de collision entraine un rebond
                    if ((Math.pow(dx, 2) + Math.pow(dy, 2)) < ecmax) {
                        // Cas 1 : collision sans rebond
                        // on fait le produit scalaire entre le vecteur vitesse et le vecteur unitaire de la pente
                    	// sauf si il y avait déjà collision avec la même droite
                    	if (memoirecollisionprecedente == true && l== ligneprecedente){
                    		dx = dx -g* dt * sinp;
                    		dy = dy - g* dt * (cosp - 1);}
                    	else{
                    		double ps = dx * cosp + dy * sinp;
                    		// La nouvelle vitesse est dirigee selon la pente pour pas que la bille entre en collision
                    		// Sa norme est egale au produit scalaire d'avant
                    		
   /*ajouter des cas?*/         		dx = ps * cosp -g * dt * sinp;
                    		dy = -ps * sinp -g* dt * (cosp - 1);
                    		
                    	}
                    		
                    	//}
                        //Calcul de la position x et y du prochain point, avec prise en compte de la gravit�
    /*essai*/            x = (int) (x /*+ (-0.5) * g * dt * 2 * sinp*/ + dx * dt); 
                        y = (int) (y /*- 0.5 * g * Math.pow(dt, 2) * (cosp - 1)*/ + dy * dt);
                        //Calcul des nouvelles vitesses dx et dy
                        dx = -g*15 * dt * sinp + dx; //ici j'ai enlevé un moins et rajouté *15...
                        dy = g* dt * (cosp - 1) + dy;
                    }

                    else {
                        // Cas 2 : collision avec rebond
                        // La vitesse colineaire a la courbe reste �gale
                        // la vitesse normale a la courbe est inversee pour qu'il y ai "rebond"
                        // le coeff d'amortissement peut etre different pour la composante parallele si c'est pas r�aliste comme �a
                        dx =
                            coeff *
                            (cosp * dx * cosp - dy * sinp - sinp * dx * sinp +
                             dy * cosp);
                        dy =
                            coeff *
                            (sinp * dx * cosp + dy * sinp + cosp * dx * sinp -
                             dy * cosp);
                        // Calcul des nouvelles coordonn�es x et y
                        x = (int) (x + dx * dt);
                        y = (int) (y + (-0.5) * g * Math.pow(dt, 2) + dy * dt);
                        // Calcul des nouvelles vitesses, dx ne change pas
                        dy = -g * dt + dy;
            }
                    memoirecollisionprecedente = true;
                    ligneprecedente = l;
        }
    }

}

