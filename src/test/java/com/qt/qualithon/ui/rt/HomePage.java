package com.qt.qualithon.ui.rt;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

/**
 * represents IMDb Web Home Page elements and ui actions (page object)
 **/
public class HomePage extends Page {

    public HomePage(TestSession testSession){
        super(testSession);
    }

    /**
     * perform a search for movie title and return the resultlist page
     *
     * @param     movieTitle    movie name
     * @return    IMDb Results Page page object
     **/
    public ResultsPage search(String movieTitle){
        WebElement searchInput = this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input.search-text")
            )
        );

        WebElement searchSubmit = this.testSession.driverWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a.search-submit")
                )
            );
        
        searchInput.sendKeys(movieTitle);
        //searchInput.submit();
        searchSubmit.click();
        
        
        return new ResultsPage(this.testSession);
    }
}
