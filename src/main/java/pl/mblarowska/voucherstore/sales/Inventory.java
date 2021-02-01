package pl.mblarowska.voucherstore.sales;

public interface Inventory {
    boolean isAvailable(String productId);
}
