package pl.mblarowska.voucherstore.sales.product;

import pl.mblarowska.voucherstore.productcatalog.Product;
import pl.mblarowska.voucherstore.productcatalog.ProductCatalogFacade;

public class ProductCatalogProductDetailsProvider implements ProductDetailsProvider {

    private final ProductCatalogFacade productCatalogFacade;

    public ProductCatalogProductDetailsProvider(ProductCatalogFacade productCatalogFacade) {
        this.productCatalogFacade = productCatalogFacade;
    }

    @Override
    public ProductDetails getByProductId(String productId) {
        Product product = productCatalogFacade.getById(productId);

        return new ProductDetails(productId, product.getDescription(), product.getPrice());
    }
}
