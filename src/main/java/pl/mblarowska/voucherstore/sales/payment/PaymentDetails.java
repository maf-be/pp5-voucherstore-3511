package pl.mblarowska.voucherstore.sales.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDetails {
    String reservationId;
    String paymentUrl;
}
