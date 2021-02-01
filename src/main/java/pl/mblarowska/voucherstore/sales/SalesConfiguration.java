package pl.mblarowska.voucherstore.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mblarowska.voucherstore.productcatalog.ProductCatalogFacade;
import pl.mblarowska.voucherstore.sales.basket.InMemoryBasketStorage;
import pl.mblarowska.voucherstore.sales.offer.OfferMaker;
import pl.mblarowska.voucherstore.sales.product.ProductCatalogProductDetailsProvider;
import pl.mblarowska.voucherstore.sales.product.ProductDetailsProvider;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(ProductCatalogFacade productCatalogFacade, OfferMaker offerMaker) {
        return new SalesFacade(
                productCatalogFacade,
                new InMemoryBasketStorage(),
                () -> "customer_1",
                (productId) -> true,
                offerMaker
        );
    }

    @Bean
    OfferMaker offerMaker(ProductDetailsProvider productDetailsProvider) {
        return new OfferMaker(productDetailsProvider);
    }

    @Bean
    ProductDetailsProvider productDetailsProvider(ProductCatalogFacade productCatalogFacade) {
        return new ProductCatalogProductDetailsProvider(productCatalogFacade);
    }
}
