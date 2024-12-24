package org.example;

import org.testng.annotations.Test;

import static org.example.Keyword.TELEFON_SEARCH_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void shouldSearchKeywordProperly() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.search("telefon");
        assertEquals(getDriver().getCurrentUrl(), TELEFON_SEARCH_URL);
        assertTrue(searchResultPage.hasProducts());
    }
}
