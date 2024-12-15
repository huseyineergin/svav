package org.example;

import org.openqa.selenium.By;

import java.util.Set;

import static org.example.BaseTest.getDriver;

public class SearchResultPage extends BasePage {

    By productCard = By.className("p-card-wrppr");
    By addToFavouritesButton = By.className("fvrt-btn");
    By favouritesButton = By.xpath("//*[text()='Favorilerim']");

    public boolean hasProducts() {
        return findElement(productCard).isDisplayed();
    }

    public ProductPage clickFirstProduct() {
        changeWindow(productCard);
        return new ProductPage();
    }

    public FavouritesPage clickFavourites() {
        click(favouritesButton);
        return new FavouritesPage();
    }

    public void clickAddToFavouritesButton() {
        click(addToFavouritesButton);
    }

    private void changeWindow(By by) {
        click(by, 0);

        String currentWindow = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!currentWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
