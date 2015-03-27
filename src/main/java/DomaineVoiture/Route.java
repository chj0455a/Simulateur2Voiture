package DomaineVoiture;

/**
 * Created by 21103468 on 27/03/2015.
 */
public class Route {

    private int x;
    private int y;
    private int largeur;
    private int longueur;

    public Route(int x, int y, int largeur, int longueur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }
}
