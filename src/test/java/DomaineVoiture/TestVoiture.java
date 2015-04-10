package DomaineVoiture;

import static org.junit.Assert.*;

import DomaineRoute.Route;
import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
    private Route maRoute;
	
	@Before
	public void setUp(){
		maRoute = new Route(100,300,10,500);
        maVoiture = new Voiture (10, maRoute, 10,2);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(100, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(590, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(100, maVoiture.getX());
		
	}

    @Test
    public void testgetY() {
        assertEquals(306,maVoiture.getY());
    }

    @Test
    public void testLongueur() {
        assertEquals(10, maVoiture.getLongueur());
    }

    @Test
    public void testLargeur() {
        assertEquals(2, maVoiture.getLargeur());
    }
}
