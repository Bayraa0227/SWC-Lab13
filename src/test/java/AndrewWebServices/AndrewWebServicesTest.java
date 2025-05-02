package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // Fake test:
        database = new InMemoryDatabase();

        // Mock test:
        recommender = mock(RecSys.class);
        promoService = mock(PromoService.class);

        // Stub test:
        when(recommender.getRecommendation(anyString())).thenReturn("Animal House");

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        String testEmail = "testmail@example.com";
        andrewWebService.sendPromoEmail(testEmail);
        verify(promoService).mailTo(testEmail);
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like
        // right after logging in)?
        andrewWebService.logIn("Scotty", 17214);
        verify(promoService, never()).mailTo(anyString());
    }
}
