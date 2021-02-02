package pl.mblarowska.voucherstore.sales;

public interface PaymentGateway {
    ReservationPaymentDetails register(Reservation reservation);

    boolean isTrusted(PaymentUpdateStatusRequest paymentUpdateStatusRequest);
}
