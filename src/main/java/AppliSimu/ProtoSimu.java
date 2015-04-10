package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

        final Route maRoute = new Route(100,300,50,500);
        final Route maRoute2 = new Route(300,100,50,500);
		final Voiture maVoiture = new Voiture (10, maRoute, 30, 10);

		IHMVoiture monTriangle = new IHMVoiture(maVoiture, maRoute,maRoute2);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}

	}

}
