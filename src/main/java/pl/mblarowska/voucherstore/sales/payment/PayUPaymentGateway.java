package pl.mblarowska.voucherstore.sales.payment;

import pl.mblarowska.payu.PayU;
import pl.mblarowska.voucherstore.sales.ordering.Reservation;

public class PayUPaymentGateway implements PaymentGateway {
    private final PayU payU;
    public PayUPaymentGateway(PayU payU) {
        this.payU = payU;
    }

    @Override
    public PaymentDetails register(Reservation reservation) {
        return null;
    }

    @Override
    public boolean isTrusted(PaymentUpdateStatusRequest paymentUpdateStatusRequest) {
        return payU.isTrusted(paymentUpdateStatusRequest.getBody(), paymentUpdateStatusRequest.getSignature());
    }
}
