package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC4_SeachProduct extends BaseClass{
	
	@Test(groups={"Master"})
	public void testProductSearch()
	{
		logger.info("***    Starting TC004_search Test ****");
		
		
		HomePage homePage = new HomePage(driver);
		
		String productToSearch="mac";
		homePage.enterProductName(productToSearch);
		logger.info("Entered product name in search field: " + productToSearch);
		
		
		SearchResultsPage searchResultsPage=homePage.clickSearch();
		//homePage.searchbtnclick();
		
		// Verify if the product is displayed in the search results
        Assert.assertTrue(searchResultsPage.isSearchResultsPageExists());
        logger.info("Navigated to the Search Results page.");
        
        // Check if the specific product exists in the search results
        String expectedProductName = "MacBook";
        boolean isProductDisplayed = searchResultsPage.isProductExist(expectedProductName);
        logger.info("Verifying if the product '" + expectedProductName + "' is displayed in the search results.");

        // Assertion to verify that the product exists in the search results
        Assert.assertTrue(isProductDisplayed, "Product '" + expectedProductName + "' not found in search results.");
        logger.info("Product '" + expectedProductName + "' found in search results. Test passed.");
		
	
	}

}
