package DomaineVoiture;

import static org.junit.Assert.*;

/**
 * Created by 21103468 on 27/03/2015.
 */
public class TestRoute {

    public void testCreationRoute() {
        Route maRoute = new Route(100,300,10,500);
        assertEquals(100,maRoute.getX());
        assertEquals(300,maRoute.getY());
        assertEquals(10,maRoute.getLargeur());
        assertEquals(500,maRoute.getLongueur());

    }
}
