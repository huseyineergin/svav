package org.example;

import org.openqa.selenium.By;

public class FavouritesPage extends BasePage {
    By removeFavoredProductButton = By.className("i-close");
    By emptyFavourites = By.className("empty-favorites");
    By favouredProductContainer = By.className("favored-product-container");

    public boolean hasAnyFavouriteProduct() {
        return findElement(favouredProductContainer).isDisplayed();
    }

    public boolean hasEmptyFavourites() {
        return findElement(emptyFavourites).isDisplayed();
    }

    public void clickRemoveFavouriteProduct() {
        click(removeFavoredProductButton);
    }
}
