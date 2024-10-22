package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void shouldSearchKeywordProperly() {
        HomePage homePage = new HomePage();
        SearchResultPage  searchResultPage = homePage.search("telefon");
        assertEquals(getDriver().getCurrentUrl(), "https://www.trendyol.com/sr?q=telefon&qt=telefon&st=telefon&os=1");
        assertTrue(searchResultPage.hasProducts());
    }
}
