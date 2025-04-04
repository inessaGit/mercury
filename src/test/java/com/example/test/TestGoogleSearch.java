package com.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.BaseTest;
import com.example.pages.GoogleSearch;
import com.example.pages.SearchResults;
import com.example.webdriver.DriverManager;

public class TestGoogleSearch extends BaseTest {

	@Test
	public void testGoogleSearch() {

		GoogleSearch search = new GoogleSearch(DriverManager.getWebDriver()).get();
		SearchResults results = search.search("educative");
		results.nextPage();
	}

	@Test
	public void testGoogleSearchFailure() {

		GoogleSearch search = new GoogleSearch(DriverManager.getWebDriver()).get();
		search.search("educative");
		Assert.fail("failing the test to take screenshot");
	}

}
