package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import commons.GlobalConstants;
import json_data.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ParseJsonHelper {

    private final static String pathToJsonTestData = GlobalConstants.getGlobalConstants().getPathToJsonTestData();

    public static LoginCredentials getLoginCredentials() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "login_credentials.json");
            return gson.fromJson(fileReader, LoginCredentials.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<SelectCar> getSelectCar() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "select_car.json");
            Type selectCarListType = new TypeToken<ArrayList<SelectCar>>(){}.getType();
            return gson.fromJson(fileReader, selectCarListType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SellDetails getSellDetails() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "sell_details.json");
            return gson.fromJson(fileReader, SellDetails.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SellFeatures getSellFeatures() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "sell_features.json");
            return gson.fromJson(fileReader, SellFeatures.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<CarDimension> getCarDimensionList() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "car_dimension.json");
            Type carDimensionListType = new TypeToken<ArrayList<CarDimension>>(){}.getType();
            return gson.fromJson(fileReader, carDimensionListType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AddToFavourite getAddToFavourite(){
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(pathToJsonTestData + "add_to_favourite.json");
            return gson.fromJson(fileReader, AddToFavourite.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        FavouritedCars favouritedCars = getFavouritedCars();
//        System.out.println(favouritedCars.getFeaturedSearches());
//    }
}
