package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	static double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private Route maRoute;
    private Route maRoute2;
	private CommandeVoiture maCommandeVoiture;

	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, Route maRoute) {
		super();
        this.maRoute = maRoute;
        this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

    public IHMVoiture(Voiture maVoiture, Route maRoute,Route maRoute2) {
        super();
        this.maRoute = maRoute;
        this.maRoute2 = maRoute2;
        this.maVoiture = maVoiture;
        maVoiture.addObserver(this);
        initGraphique();
    }

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
        dessinerRouteHorizontale(contexteGraphique,maRoute);
        if(maRoute2 != null)
            dessinerRouteVerticale(contexteGraphique,maRoute2);
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        int yPixel = calculerPositionPixels(maVoiture.getY());
        int longueurPixelVoiture = this.calculerPositionPixels(maVoiture.getLongueur());
        int largeurPixelVoiture = this.calculerPositionPixels(maVoiture.getLargeur());
		contexteGraphique.fillRect(xPixel,yPixel, longueurPixelVoiture, largeurPixelVoiture);
	}

    private void dessinerRouteHorizontale(Graphics contexteGraphique,Route maRoute) {
        int XpixelDebutRoute = this.calculerPositionPixels(maRoute.getX());
        int YpixelDebutRoute = this.calculerPositionPixels(maRoute.getY());
        int xPixelFinRoute = XpixelDebutRoute + this.calculerPositionPixels(maRoute.getLongueur());
        contexteGraphique.drawLine(XpixelDebutRoute, YpixelDebutRoute, xPixelFinRoute,YpixelDebutRoute );

        int pixelFinRoute = YpixelDebutRoute + this.calculerPositionPixels(maRoute.getLargeur());
        int XFinRoute = XpixelDebutRoute + this.calculerPositionPixels(maRoute.getLongueur());
        contexteGraphique.drawLine(XpixelDebutRoute, pixelFinRoute,XFinRoute , pixelFinRoute);
    }

    private void dessinerRouteVerticale(Graphics contexteGraphique,Route maRoute) {
        int XpixelDebutRoute = this.calculerPositionPixels(maRoute.getX());
        int YpixelDebutRoute = this.calculerPositionPixels(maRoute.getY());
        int yPixelFinRoute = YpixelDebutRoute + this.calculerPositionPixels(maRoute.getLongueur());
        contexteGraphique.drawLine(XpixelDebutRoute, YpixelDebutRoute, XpixelDebutRoute,yPixelFinRoute );

        int XpixelFinRoute = XpixelDebutRoute + this.calculerPositionPixels(maRoute.getLargeur());
        int XFinRoute = XpixelDebutRoute + this.calculerPositionPixels(maRoute.getLongueur());
        contexteGraphique.drawLine(XpixelFinRoute, YpixelDebutRoute,XpixelFinRoute , yPixelFinRoute);
    }
}
