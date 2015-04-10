package DomaineVoiture;

import DomaineRoute.Route;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
	private int y;
    private int longueur;
    private int largeur;
	private int vitesseMetreSeconde;
	private int directionEnDegres;
    private Route maRoute;

	public Voiture(int vitesse, Route maRoute, int longueur,int largeur) {
		this.longueur = longueur;
        this.maRoute = maRoute;
        this.largeur = largeur;
        this.x = maRoute.getX();
		this.y = maRoute.getY() + maRoute.getLargeur()*3/4 - this.largeur/2;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres == 0)
			x += vitesseMetreSeconde;
		else
			x -= vitesseMetreSeconde;
		
		if (x > (maRoute.getX() + maRoute.getLongueur() - this.longueur))
			x = maRoute.getX() + maRoute.getLongueur() - this.longueur;
		else if (x < maRoute.getX())
			x = maRoute.getX();
	}

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}

    public int getY() {
        return y;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = directionEnDegres % 360;
		
	}

    public void tournerGauche() {
        directionEnDegres += 270 ;
        directionEnDegres = directionEnDegres % 360;
    }

    public void tournerDroite() {
        directionEnDegres += 90 ;
        directionEnDegres = directionEnDegres % 360;
    }

	public Object getDirection() {
	return directionEnDegres;
	}

	
}
