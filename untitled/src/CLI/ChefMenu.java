package CLI;

import People.Person;
import Restaurant.Table;
import utils.DataStorage;
import utils.UtilsMenu;
import java.util.Scanner;

public class ChefMenu extends UtilsMenu {
    private Scanner in;
    private Person user;

    public ChefMenu(Scanner in, Person user) {
        this.in = in;
        this.user = user;
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("Select a table you would like to view : ");
            var table = (Table) pick(DataStorage.getAllTables().values().toArray());
            //ToDo List all tables from tables class
            String command = in.nextLine().toUpperCase();

            //ToDo THIS PART IS A WORK IN PROGRESS
            switch (table.getTableNo()) {
                case 1 -> { //ToDo let chef choose via Number beside table (e.g. 1)table_1, 2)table_2..)
                    System.out.println("S)ee order, C)hange state of order, L)ogout");
                }

                case 2 -> {
                    System.out.println("These are the orders and their state : ");
                    //ToDo need to assign state from order class
                }
                case 3 -> { //ToDo make sure that after order is changed, the program goes back to case "T"
                    System.out.println("Select which order you want to change status : ");
                }

                case 4 -> { //Returns to Login page
                    quit = false;
                }
            }
        }
    }
}