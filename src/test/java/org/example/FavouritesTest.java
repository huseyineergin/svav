package org.example;

import org.testng.annotations.Test;

import static org.example.UserPool.getValidUser;
import static org.testng.Assert.assertTrue;

public class FavouritesTest extends BaseTest {

    @Test
    public void shouldAddProductToFavourites() {
        User user = getValidUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(user.email(), user.password(), true);

        SearchResultPage  searchResultPage = homePage.search("telefon");
        searchResultPage.clickAddToFavouritesButton();

        FavouritesPage favouritesPage = searchResultPage.clickFavourites();

        assertTrue(favouritesPage.hasAnyFavouriteProduct());
        favouritesPage.clickRemoveFavouriteProduct();
    }

    @Test
    public void shouldRemoveProductFromFavourites() {
        User user = getValidUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(user.email(), user.password(), true);

        SearchResultPage searchResultPage = homePage.search("telefon");
        searchResultPage.clickAddToFavouritesButton();

        FavouritesPage favouritesPage = searchResultPage.clickFavourites();
        favouritesPage.clickRemoveFavouriteProduct();

        assertTrue(favouritesPage.hasEmptyFavourites());
    }
}
