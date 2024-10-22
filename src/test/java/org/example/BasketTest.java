package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BasketTest extends BaseTest {

    @Test
    public void shouldSearchAndAddToBasket() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.search("telefon");

        ProductPage productPage = searchResultPage.clickFirstProduct();
        productPage.closeOnboardingPopup();
        productPage.addToBasket();

        assertTrue(productPage.isCounterVisibleFromBasket(), "Counter is not visible!");
    }
}