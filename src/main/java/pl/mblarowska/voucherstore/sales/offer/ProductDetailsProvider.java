package pl.mblarowska.voucherstore.sales.offer;

public interface ProductDetailsProvider {
    ProductDetails getByProductId(String productId);
}
