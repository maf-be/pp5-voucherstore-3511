package pl.mblarowska.voucherstore.sales.ordering;

import pl.mblarowska.voucherstore.sales.offer.Offer;

import java.util.UUID;

public class Reservation {
    public static Reservation of(Offer currentOffer, ClientData clientData) {
        return new Reservation();
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }
}
