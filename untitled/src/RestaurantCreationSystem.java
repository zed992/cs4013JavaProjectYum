import CLI.CreateRestaurant;
import Restaurant.*;
import utils.UtilsCSV;
import utils.DataStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantCreationSystem {
    public static void main(String[] args) {
        new CreateRestaurant(new Scanner(System.in));

        File restCSV = new File("restaurant.csv");
        for (Restaurant restaurant: DataStorage.getAllRestaurants()) {

        }
    }
}
