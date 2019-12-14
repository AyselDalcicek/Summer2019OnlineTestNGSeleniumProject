package tests.day_22_review;

import org.testng.annotations.Test;
import utils.ExcelUtil;

public class ReadTestDataFromExcelFile {

    @Test
    public void test1() {
        ExcelUtil cars = new ExcelUtil("cars.xlsx", "cars");
        System.out.println(cars.getDataList());
        //get(0) means get data from first row
        //get("Color") means get value of Color column, from first row
        String color = cars.getDataList().get(0).get("Color");
        String driverName = cars.getDataList().get(0).get("Driver");
        System.out.println(color);
        System.out.println(driverName);


    }
}