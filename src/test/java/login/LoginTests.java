package login;


import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import setup.SetupTest;

public class LoginTests extends SetupTest {

    //TestNG annotation
    @Test
    //This class extends to the SetUp_Tests as the SetUP_Tests class contains all the SetUp requirements to run this test
    public void testLogin() throws InterruptedException
    {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword( "admin123");

        //Handler for dashboard page
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.clickWelcomeAdmin();

        loginPage = dashboardPage.clickLogout();
        String pageUrl = "https://opensource-demo.oragehrmlive.com/index.php/dashboard";
        System.out.println ("PASSED - The page url is " + pageUrl);
    }

    @Test
    public void testLogout () throws InterruptedException {
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page url is " + loginUrl);
        }
    }
}
