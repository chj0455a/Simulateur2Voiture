package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonGauche;
    private JButton boutonDroite;
	private Voiture maVoiture;
	
	
	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonGauche = new JButton("Tourner Gauche");
        boutonGauche.addActionListener(this);
        this.add(boutonGauche);

        boutonDroite = new JButton("Tourner Droite");
        boutonDroite.addActionListener(this);
        this.add(boutonDroite);
		
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
		else if(bouton == boutonInverserDirection)
			maVoiture.inverserDirection();
        else if (bouton == boutonGauche)
            maVoiture.tournerGauche();
        else
            maVoiture.tournerDroite();
	}
	

}
