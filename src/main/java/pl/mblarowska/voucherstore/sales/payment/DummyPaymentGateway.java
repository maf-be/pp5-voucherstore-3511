package pl.mblarowska.voucherstore.sales.payment;

import pl.mblarowska.voucherstore.sales.ordering.Reservation;

public class DummyPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails register(Reservation reservation) {
        return null;
    }

    @Override
    public boolean isTrusted(PaymentUpdateStatusRequest paymentUpdateStatusRequest) {
        return true;
    }
}
