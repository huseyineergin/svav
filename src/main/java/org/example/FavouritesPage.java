package org.example;

import org.openqa.selenium.By;

public class FavouritesPage extends BasePage {
    By emptyFavourites = By.className("favorites-empty-state");
    By removeFavoredProductButton = By.className("icon-close");
    By favouredProductContainer = By.className("favorite-wrapper");

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
