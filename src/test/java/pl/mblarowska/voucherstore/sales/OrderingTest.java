package pl.mblarowska.voucherstore.sales;

import org.junit.Before;
import org.junit.Test;
import pl.mblarowska.voucherstore.sales.offer.Offer;

import static org.assertj.core.api.Assertions.*;

public class OrderingTest extends SalesTestCase {
    @Before
    public void setUp() {
        productCatalog = thereIsProductCatalog();
        basketStorage = thereIsBasketStorage();
        inventory = therIsInventory();
        currentCustomerContext = thereIsCurrentCustomerContext();
        offerMaker = thereIsOfferMaker();
    }

    @Test
    public void itCreatesReservationBasedOnCurrentOffer() {
        //Arrange
        SalesFacade salesFacade = thereIsSalesModule();
        var productId1 = thereIsProductAvailable();
        var productId2 = thereIsProductAvailable();

        //Act
        var customerId1 = thereIsCustomerWhoIsDoingSomeShoping();
        salesFacade.addProduct(productId1);

        salesFacade.addProduct(productId2);
        Offer seenOffer = salesFacade.getCurrentOffer();

        String reservationId = salesFacade.acceptOffer(seenOffer);

        thereIsPendingReservationWithId(reservationId);
    }

    private void thereIsPendingReservationWithId(String reservationId) {
        assertThat(true).isFalse();
    }
}
