package tests.vytrack;


import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;

public class CreateCarTests extends TestBase {

    @Test(description = "Create some random car")
    public void test1(){
        extentTest = extentReports.createTest("Create a new car");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Fleet", "Vehicles");

        loginPage.waitUntilLoaderMaskDisappear();

        vehiclesPage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();

        createCarPage.licensePlateElement.sendKeys("Random");
        createCarPage.selectTags("Compact");
        createCarPage.selectFuelType("Diesel");

        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.pass("New car was created");
    }
}

//        // Data Driven Testing --> If we Change data From Excel sheet we call it as Data Driven Testing.
//
//        //with many rows of data
//        for(Map<String, String> value: testData){
//            createCarPage.licensePlateElement.sendKeys(value.get("License Plate"));
//        }
//
//    }
//}