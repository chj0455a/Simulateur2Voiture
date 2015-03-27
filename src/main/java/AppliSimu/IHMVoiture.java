package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	static double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private Route maRoute;
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
        dessinerRoute(contexteGraphique);
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, this.maRoute.getLargeur() / 5);
	}

    private void dessinerRoute(Graphics contexteGraphique) {
        int pixelDebutRoute = this.calculerPositionPixels(this.maRoute.getX());
        contexteGraphique.drawLine(pixelDebutRoute, 300, pixelDebutRoute + maRoute.getLongueur(), 300);

        int pixelFinRoute = 300 + this.maRoute.getLargeur();
        contexteGraphique.drawLine(pixelDebutRoute, pixelFinRoute, pixelDebutRoute + maRoute.getLongueur(), pixelFinRoute);
    }
}
