package pl.mblarowska.voucherstore.sales.payment;

import pl.mblarowska.payu.exceptions.PayUException;

public class PaymentException extends IllegalStateException {
    public PaymentException(PayUException e) {
        super(e);
    }
}
