package pl.mblarowska.voucherstore.sales;

import pl.mblarowska.voucherstore.productcatalog.Product;
import pl.mblarowska.voucherstore.productcatalog.ProductCatalogFacade;
import pl.mblarowska.voucherstore.sales.basket.Basket;
import pl.mblarowska.voucherstore.sales.basket.InMemoryBasketStorage;
import pl.mblarowska.voucherstore.sales.offer.Offer;
import pl.mblarowska.voucherstore.sales.offer.OfferMaker;

public class SalesFacade {

    ProductCatalogFacade productCatalogFacade;
    InMemoryBasketStorage basketStorage;
    CurrentCustomerContext currentCustomerContext;
    Inventory inventory;
    private OfferMaker offerMaker;

    public SalesFacade(ProductCatalogFacade productCatalogFacade, InMemoryBasketStorage basketStorage, CurrentCustomerContext currentCustomerContext, Inventory inventory, OfferMaker offerMaker) {
        this.productCatalogFacade = productCatalogFacade;
        this.basketStorage = basketStorage;
        this.currentCustomerContext = currentCustomerContext;
        this.inventory = inventory;
        this.offerMaker = offerMaker;
    }

    public void addProduct(String productId1) {
        Product product = productCatalogFacade.getById(productId1);
        Basket basket = basketStorage.loadForCustomer(getCurrentCustomerId())
                .orElse(Basket.empty());

        basket.add(product, inventory);

        basketStorage.addForCustomer(getCurrentCustomerId(), basket);
    }

    private String getCurrentCustomerId() {
        return currentCustomerContext.getCurrentCustomerId();
    }

    public Offer getCurrentOffer() {
        Basket basket = basketStorage.loadForCustomer(getCurrentCustomerId())
                .orElse(Basket.empty());
        return offerMaker.calculateOffer(basket.getBasketItems());
    }

    public String acceptOffer(Offer seenOffer) {
        return null;
    }
}
