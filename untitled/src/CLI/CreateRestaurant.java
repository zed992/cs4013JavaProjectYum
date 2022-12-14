package CLI;

import People.Chef;
import People.Waiter;
import Restaurant.*;
import utils.DataStorage;

import java.util.Scanner;

public class CreateRestaurant {
    private Scanner input = new Scanner(System.in);

    public CreateRestaurant(Scanner input) {

        this.input = input;
    }

    public void run() {
        System.out.println("---> CREATE RESTAURANT");
        System.out.print("Enter number of tables: ");
        
        int numberOfTables;
        
        while (true) {
            try {
                numberOfTables = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception ex) {
                System.out.print("Please enter number of tables as an integer: ");
            }
        }
        
        boolean quit = true;
        Restaurant restaurant = new Restaurant(numberOfTables);

        while (quit) {
            System.out.println("Q) Add table, W) Add menu, E) Add chef, A) Add Waiter, B) Back");
            System.out.print("Enter your command: ");
            String command = input.nextLine().toUpperCase();

            switch (command) {
                case "Q" -> {
                    System.out.print("Enter number of seats: ");
                    int numberOfSeats;
                    
                    while (true) {
                        try {
                            numberOfSeats = Integer.parseInt(input.nextLine());
                            if (numberOfSeats > 0) {
                                break;
                            }
                        } catch (Exception ex) {
                            System.out.print("Please enter the number of seats: ");
                        }
                    }
                    
                    var table = new Table(restaurant.getTables().size(), numberOfSeats);
                    
                    try {
                        restaurant.addTable(table);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }

                case "W" -> {
                    var menu = new Menu();
                    
                    while (true) {
                        System.out.print("    Enter category name: ");
                        String categoryName = input.nextLine();
                        
                        while (categoryName.isBlank()) {
                            System.out.print("    Please enter the name of the category: ");
                            categoryName = input.nextLine();
                        }
                        
                        menu.addCategory(categoryName);
                        
                        while (true) {
                            System.out.print("    Enter meal name: ");

                            String mealName = input.nextLine();

                            while (mealName.isBlank()) {
                                System.out.print("    Please enter the name of the meal: ");
                                mealName = input.nextLine();
                            }
                            
                            System.out.print("    Enter meal price: ");

                            double mealPrice = -1;

                            try {
                                mealPrice = Double.parseDouble(input.nextLine());
                            } catch (Exception ex) {
                                mealPrice = -1;
                            }
                            
                            while (mealPrice <= 0) {
                                System.out.print("    Please enter meal price: ");
                                try {
                                    mealPrice = Double.parseDouble(input.nextLine());
                                } catch (Exception ex) {
                                    System.out.println("    PLEASE ENTER A NUMBER.");
                                }
                            }

                            Food food = new Food(mealName, mealPrice);
                            
                            menu.addFood(food, categoryName);

                            System.out.print("Do you want to add another meal to this category? Y)es or N)o: ");
                            
                            String addMoreFood = input.nextLine().toUpperCase();

                            while (!addMoreFood.equals("Y") && !addMoreFood.equals("N")) {
                                System.out.print("Please enter Y)es or N)o:");
                                addMoreFood = input.nextLine().toUpperCase();
                            }

                            if (addMoreFood.equals("N")) {
                                restaurant.addMenu(menu);
                                break;
                            }
                        }

                        System.out.print("Do you want to add another category to this menu? Y)es or N)o: ");

                        String addMoreCategories = input.nextLine().toUpperCase();

                        while (!addMoreCategories.equals("Y") && !addMoreCategories.equals("N")) {
                            System.out.print("Please enter Y)es or N)o:");
                            addMoreCategories = input.nextLine().toUpperCase();
                        }

                        if (addMoreCategories.equals("N")) {
                            break;
                        }
                    }

                    System.out.println();
                }

                case "E" -> {
                    System.out.println("ADD NEW CHEF");
                    System.out.print("    Enter chef's name: ");
                    String chefName = input.nextLine();

                    while (chefName.isBlank()) {
                        System.out.print("    Please enter chef's name: ");
                        chefName = input.nextLine();
                    }

                    System.out.print("    Enter chef's phone number: ");
                    String chefPhoneNumber = input.nextLine();

                    while (chefPhoneNumber.isBlank()) {
                        System.out.print("    Please enter chef's phone number: ");
                        chefPhoneNumber = input.nextLine();
                    }

                    System.out.print("    Enter chef's title: ");
                    String chefTitle = input.nextLine();

                    while (chefTitle.isBlank()) {
                        System.out.print("    Please enter chef's title: ");
                        chefTitle = input.nextLine();
                    }

                    System.out.print("    Enter password for chef: ");
                    String password = input.nextLine();

                    var chef = new Chef(chefName,chefPhoneNumber, chefTitle);

                    restaurant.addEmployee(chef, password);

                    System.out.println("Chef's user name: " + chef.getId());
                    System.out.println("Chef's password: " + chef.getPassword());
                }

                case "A" -> {
                    System.out.println("ADD NEW WAITER");

                    System.out.print("    Enter waiter's name: ");
                    String waiterName = input.nextLine();

                    while (waiterName.isBlank()) {
                        System.out.print("    Please enter waiter's name: ");
                        waiterName = input.nextLine();
                    }

                    System.out.print("    Enter waiter's phone number: ");
                    String waiterPhoneNumber = input.nextLine();

                    while (waiterPhoneNumber.isBlank()) {
                        System.out.print("    Please enter waiter's phone number: ");
                        waiterPhoneNumber = input.nextLine();
                    }

                    System.out.print("    Enter password for waiter: ");
                    String password = input.nextLine();

                    var waiter = new Waiter(waiterName, waiterPhoneNumber, "Waiter");

                    restaurant.addEmployee(waiter, password);

                    System.out.println("Waiter's user name: " + waiter.getId());
                    System.out.println("Waiter's password: " + waiter.getPassword());
                }

                case "B" -> {
                    if (restaurant.getTables().size() == numberOfTables &&
                        !restaurant.getChefs().isEmpty() &&
                        !restaurant.getWaiters().isEmpty() &&
                        !restaurant.getMenu().getCategories().isEmpty()) {
                        DataStorage.addRestaurant(restaurant);
                        quit = false;
                    } else {
                        System.out.println("You have not finish creating your restaurant");
                    }
                }
            }
        }
    }
}
