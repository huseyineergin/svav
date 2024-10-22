package org.example;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    By addToBasketButton = By.className("add-to-basket");
    By basketCounterBadge = By.cssSelector(".basket-item-count-container.visible");
    By onboardingPopup = By.className("onboarding-popover__default-renderer-primary-button");

    public void addToBasket() {
        click(addToBasketButton);
    }

    public void closeOnboardingPopup() {
        click(onboardingPopup);
    }

    public boolean isCounterVisibleFromBasket() {
        return findElement(basketCounterBadge).isDisplayed();
    }
}
