package org.example;

import org.testng.annotations.Test;

import static org.example.Keyword.EMPTY_PASSWORD_WARNING;
import static org.example.Keyword.FALSE_LOGIN_WARNING;
import static org.example.UserPool.*;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginWithCorrectInfo() {
        User user = getValidUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(user.email(), user.password(), true);

        String currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/");

        String accountText = homePage.getTextOfAccountButton();
        assertEquals(accountText, "Hesabım");
    }

    @Test
    public void shouldNotLoginWithWrongPassword() {
        User user = getFalsePasswordUser();
        HomePage homePage = new HomePage();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.email(), user.password(), false);

        String warningText = loginPage.getWarningText();
        assertEquals(warningText, FALSE_LOGIN_WARNING);
    }

    @Test
    public void shouldNotLoginWithEmptyPassword() {
        User user = getEmptyPasswordUser();
        HomePage homePage = new HomePage();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.email(), user.password(), false);

        String warningText = loginPage.getWarningText();
        assertEquals(warningText, EMPTY_PASSWORD_WARNING);
    }
}
