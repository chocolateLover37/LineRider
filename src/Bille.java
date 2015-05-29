import java.awt.Rectangle;

import java.util.ArrayList;

public class Bille extends Objet {

    public int rayon;
   

    public Bille(int x, int y, double dx, double dy, Rectangle aframe) {
        //dy=0 au debut, dx=cste (m*g) ; //??dx c'est la composante verticale :o??
        super(x, y, dx, dy, aframe, "BilleRouge.png");
        rayon = h; //rayon √©gal √† la hauteur de l'image

    }


    public ReturnCollision collision(ArrayList<Ligne> listeligne) {
        // La m√©thode retourne un ReturnCollision contenant un booleen col qui indique si il y a collision
        // et une ligne i egale a la ligne avec laquelle il y a collision, ou egale a null sinon
        boolean col = false;
        Ligne lignecollision;

        java.util.Iterator<Ligne> iterator = listeligne.iterator();
        // On regarde la distance entre le centre de la bille et chaques courbes
        while (iterator.hasNext()) {
            lignecollision = iterator.next();
            double distancecourbe = lignecollision.distance((int) x, (int) y);
            // Si cette distance est inf√©rieure au rayon : collision
            if (distancecourbe <= h) {
                col = true;
                ReturnCollision retour = new ReturnCollision(lignecollision, col);
                return retour;
            }
        }
        // si il n'y a pas eu de distance inf√©rieure au rayon, on retourne false et i =null
        ReturnCollision pasdechoc = new ReturnCollision(null, col);
        return pasdechoc;
    }

    public void move(ArrayList<Ligne> Listdeligne, long t) {
        //la methode modifie les coordonn√©es et les vitesses de la bille en fonction la gravite et de sa proximite avec une courbe

        double dt = 1; // temps de raffraichissement
        double g = 9.81; // la gravite
        double a = 1; //provisoire
        double ecmax = 10; // condition de rebond
        double coeff = 0.9; // facteur d'amortissement pour rebond
        double p=0;
        // enregistrement coordonnees avant l'appel de move
        int xt = x;
                int yt = y;

                //  calcule la prochaine position de l'objet en chute libre
                x = (int) (x + dx * dt);
                y = (int) (y - (-0.5) * g * Math.pow(dt, 2) + dy * dt);


                // check la collision  ? la prochaine position
                ReturnCollision k = collision(Listdeligne);

                // recuperation du boolean et de la pente de la courbe (pente = null si pas de collision)
                Ligne l = k.getLigne();
                if (l!= null){
                    p= l.pente();
                }
                boolean collision = k.getBol();

                if (collision == false) {
                    // Cas 0 : pas de collision
                    // si il n'y a pas de collision alors on garde les coordonnees calculees
                    // Calcul des  nouvelles vitesses, dx ne change pas
                    dy = g * dt + dy;
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
                        double ps = dx * Math.cos(p) + dy * Math.sin(p);
                        // La nouvelle vitesse est dirigee selon la pente pour pas que la bille entre en collision
                        // Sa norme est egale au produit scalaire d'avant
                        dx = ps * Math.cos(p);
                        dy = ps * Math.sin(p);
                        //Calcul de la position x et y du prochain point, avec prise en compte de la gravitÈ
                        x = (int) (x + (-0.5) * g * dt * 2 * Math.sin(p) + dx * dt)-10;
                        y = (int) (y - 0.5 * g * Math.pow(dt, 2) * (Math.cos(p) - 1) + dy * dt)+10;
                        //Calcul des nouvelles vitesses dx et dy
                        dx = -g * dt * Math.sin(p) + dx;
                        dy = g * dt * (Math.cos(p) - 1) + dy;
                    }

                    else {
                        // Cas 2 : collision avec rebond
                        // La vitesse colineaire a la courbe reste Ègale
                        // la vitesse normale a la courbe est inversee pour qu'il y ai "rebond"
                        // le coeff d'amortissement peut etre different pour la composante parallele si c'est pas rÈaliste comme Áa
                        dx =
                            coeff *
                            (Math.cos(p) * dx * Math.cos(p) - dy * Math.sin(p) - Math.sin(p) * dx * Math.sin(p) +
                             dy * Math.cos(p));
                        dy =
                            coeff *
                            (Math.sin(p) * dx * Math.cos(p) + dy * Math.sin(p) + Math.cos(p) * dx * Math.sin(p) -
                             dy * Math.cos(p));
                        // Calcul des nouvelles coordonnÈes x et y
                        x = (int) (x + dx * dt);
                        y = (int) (y + (-0.5) * g * Math.pow(dt, 2) + dy * dt);
                        // Calcul des nouvelles vitesses, dx ne change pas
                        dy = -g * dt + dy;
            }
        }
    }

}

