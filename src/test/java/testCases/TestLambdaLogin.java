package testCases;

import commonUtils.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LambdaLoginPage;

public class TestLambdaLogin extends BaseTest {

    @Test
    private void testLogin() throws Exception {
        CommonUtils utils = new CommonUtils(this.driver);
        LambdaLoginPage lambdaLoginPage = new LambdaLoginPage(utils);
        lambdaLoginPage.enterEmail("test@test.com");
        lambdaLoginPage.enterPassword("password");
        String actualTitle = utils.getTitle("Log in");
        String expectedTitle = "Log in";
        Assert.assertEquals(actualTitle, expectedTitle, "[-] Titles do not match!");
    }
}
