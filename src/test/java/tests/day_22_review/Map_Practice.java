package tests.day_22_review;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Map_Practice {

    @Test
    public void test1() {

        //instead of index we use key name
        //in list we use index, in map - key name
        //every value is referenced by key
        //key must be unique
        //we have to specify dat type of key and value
        //they can be different
        //same thing like with list: List<String>
        //map it's key=value
        //list it's index=value
        Map<String, String> row = new HashMap<>();
        row.put("License Plate", "777");
        row.put("Driver", "SDET Driver");
        System.out.println(row.get("Driver"));
        Map<Integer, String> values = new HashMap<>();
        values.put(1, "apple");
        //Country name, Country code
        Map<String, String> countryCodes = new HashMap<>();
        countryCodes.put("USA", "+1");
        countryCodes.put("Australia", "+036");
        countryCodes.put("China", "+85");
        countryCodes.put("Kazakhstan", "+7");
        countryCodes.put("Ukraine", "+380");
        countryCodes.put("South Korea", "+82");
        countryCodes.put("Turkey", "+90");
        countryCodes.put("Uzbekistan", "+998");
        countryCodes.put("Azerbaijan", "+993");
//        ####################################################
        System.out.println(countryCodes.get("USA"));
    }
}
