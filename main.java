/*_________________________________________________________________________________________________
L2T11:Object-Oriented Programming: Inheritance, Interfaces and Static Methods
Task: Compulsory Task 2
Code Description: Refactoring the code for Food Delivery System (Foodquick)
__________________________________________________________________________________________________*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class main {

    public static void main(String[] args) {

        //Create the restaurants and put them into an array list.
    	   Restaurant Raja = new Restaurant("Raja Pizza", "Cape Town", "012 471 4479",
                   "Large Pizza", 99.00, "Medium Pzza",65.99,
                   "Crammed Pizza", 145.00);

           Restaurant Sibos = new Restaurant("Sibo's African dish", "Johannesburg", "011 471 4942",
                   "Mogodu", 45.63, "Maqina (cow heels)", 55.00,
                   "Maotwana (Chicken feet)", 69.00);

           Restaurant Honchos = new Restaurant("Honchos", "Port Elizabeth", "041 177 8471",
                   "Cheese Burger", 86.50, "Dagwood", 89.45,
                   "Chicken wings", 69.00);
           
        //Create a few customers
        //to be outputed as sample list of customers later as well as the user
   
        Customer lolo = new Customer("Lolo", "084 123 4567", "23 Magnum Road",
                "Cape Town", "lolo@icloud.com", "No peanuts", (int) (4 + (Math.random() * 6)));
        Customer siwe = new Customer("Siwe", "082 950 5252", "mhlanga Road",
                "Witbank", "siwe@gamil.com", "Please don't hoot", (int) (4 + (Math.random() * 6)));
        Customer kwanele = new Customer("Kwanele", "083 123 4568", "Albert Road",
                "Port Elizabeth", "kwanele@yahoo.co.za", "non", (int) (4 + (Math.random() * 6)));


        //Create an array list to hold the restaurants
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        restaurantList.add(Raja);
        restaurantList.add(Sibos);
        restaurantList.add(Honchos);
        
        //Create an array list which holds each customer
        ArrayList<Customer> customerArray = new ArrayList<>();

        //Add each customer to the arrayList
        customerArray.add(lolo);
        customerArray.add(siwe);
        customerArray.add(kwanele);


        //Prompt the user to order
        order(restaurantList, customerArray);


    }

    //Method that pulls the drivers from the txt documents and creates an array of objects
    public static ArrayList<Driver> getDriverInfo() {

        //Create an array list to hold the driver objects
        ArrayList<Driver> list = new ArrayList<>();

        try {

            File input = new File("src\\driver-info.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {

                //Splits each line in the drivers.txt file
                String currentLine = sc.nextLine();
                String[] currentLineSplit = currentLine.split(", ");

                String nameFromString = currentLineSplit[0];
                String areaFromString = currentLineSplit[1];
                int loadFromString = Integer.parseInt(currentLineSplit[2]);

                //Creates driver objects and adds them to the array
                Driver d = new Driver(nameFromString, areaFromString, loadFromString);
                list.add(d);

            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error pulling drivers from file");
        }

        return list;
    }

    //Method that allows the user to order
    public static void order(ArrayList<Restaurant> restaurantList, ArrayList<Customer> customerArray) {

        //User chooses a restaurant
        System.out.println("Hi! Please choose a restaurant!\n");

        System.out.println("1. " + restaurantList.get(0).restaurantName
                + "\n2. " + restaurantList.get(1).restaurantName
                + "\n3. " + restaurantList.get(2).restaurantName + "\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of your choice: ");
        int restaurantChoiceInput = sc.nextInt();

        //Subtract 1 from the user input to the array list index of the restaurant
        int restaurantChoiceIndex = restaurantChoiceInput - 1;

        //Prompt the user to order
        int mealChoiceInput = 0;

        //Array lists to hold the ordered items, quantities, and prices

        ArrayList<String> orderArray = new ArrayList<String>();
        ArrayList<Integer> orderQuantityArray = new ArrayList<Integer>();
        ArrayList<Double> orderPriceArray = new ArrayList<Double>();


        while (mealChoiceInput != 4) {

            System.out.println("What would you lke to order from " + restaurantList.get(restaurantChoiceIndex).restaurantName + "?");
            System.out.println("Again, type the corresponding number of what you'd like!");
            System.out.println("Type 4 when you're done!");

            System.out.println("1. " + restaurantList.get(restaurantChoiceIndex).meal1 + " - " + restaurantList.get(restaurantChoiceIndex).meal1Price
                    + "\n2. " + restaurantList.get(restaurantChoiceIndex).meal2 + " - " + restaurantList.get(restaurantChoiceIndex).meal2Price
                    + "\n3. " + restaurantList.get(restaurantChoiceIndex).meal3 + " - " + restaurantList.get(restaurantChoiceIndex).meal3Price
                    + "\n4. Done ordering!");

            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            mealChoiceInput = sc2.nextInt();

            //This if-statement adds the correct meals and quantities to their respective array lists
            if (mealChoiceInput == 4) {
                break;
            }

            System.out.println("How many of those would you like?: ");
            int mealChoiceQuantity = sc2.nextInt();

            if (mealChoiceInput == 1) {

                orderArray.add(restaurantList.get(restaurantChoiceIndex).meal1);
                orderQuantityArray.add(mealChoiceQuantity);
                orderPriceArray.add(restaurantList.get(restaurantChoiceIndex).meal1Price);

            } else if (mealChoiceInput == 2) {

                orderArray.add(restaurantList.get(restaurantChoiceIndex).meal2);
                orderQuantityArray.add(mealChoiceQuantity);
                orderPriceArray.add(restaurantList.get(restaurantChoiceIndex).meal2Price);

            } else if (mealChoiceInput == 3) {

                orderArray.add(restaurantList.get(restaurantChoiceIndex).meal3);
                orderQuantityArray.add(mealChoiceQuantity);
                orderPriceArray.add(restaurantList.get(restaurantChoiceIndex).meal3Price);

            }

        }

        //Collect information from customer
        System.out.println("\n\n");
        System.out.println("Please enter you info:\n");

        Scanner sc3 = new Scanner(System.in);

        System.out.println("Name: ");
        String customerName = sc3.nextLine();

        System.out.println("Number: ");
        String customerNumber = sc3.nextLine();

        System.out.println("Street Address: ");
        String customerAddress = sc3.nextLine();

        System.out.println("City: ");
        String customerArea = sc3.nextLine();

        System.out.println("Email: ");
        String customerEmail = sc3.nextLine();

        System.out.println("Special prep instructions: ");
        String customerInstructions = sc3.nextLine();

        int customerOrderNumber = (int) (4 + (Math.random() * 6));

        Customer currentCustomer = new Customer(customerName, customerNumber, customerAddress, customerArea, customerEmail,
                customerInstructions, customerOrderNumber);

        //Add the current customer to the customerArray
        customerArray.add(currentCustomer);

        //Now that the new customer is created, call the method that outputs the list of customers
        outputAllCustomers(customerArray);

        String restaurantArea = restaurantList.get(restaurantChoiceIndex).restaurantArea.toUpperCase();

        //If the restaurant area is equal to the customer area, choose the best driver
        if (restaurantArea.equals(customerArea.toUpperCase())) {
        	
            //Call the method that decides which driver to use
            chooseDriver(currentCustomer, orderArray, orderQuantityArray, orderPriceArray, restaurantList.get(restaurantChoiceIndex));

        } else {

            String output = "Sorry! The restaurant is too far away from you to be able to deliver to your location!";

            try {
                Formatter f = new Formatter("Compulsory Task 1\\invoice.txt");
                f.format(output);
                f.close();
            } catch (Exception e) {
                System.out.println("Error saving invoice");
            }

        }


    }

    //This method choose a driver in the same area, with the lowest load
    public static void chooseDriver(Customer currentCustomer, ArrayList orderArray, ArrayList orderQuantityArray, ArrayList orderPriceArray,
                                    Restaurant currentRestaurant) {

        String customerArea = currentCustomer.customerArea.toUpperCase();

        //Array lists to hold the drivers and their areas
        ArrayList<Driver> driverInfoList = getDriverInfo();
        ArrayList<Driver> driversCorrectArea = new ArrayList<Driver>();

        for (int i = 0; i < driverInfoList.size(); i++) {

            String currentArea = driverInfoList.get(i).area.toUpperCase();


            if (currentArea.equals(customerArea)) {

                driversCorrectArea.add(driverInfoList.get(i));

            } else {

                String output = "Sorry! Our drivers are too far away from you to be able to deliver to your location!";
                try {
                    Formatter f = new Formatter("Compulsory Task 1\\invoice.txt");
                    f.format(output);
                    f.close();
                } catch (Exception e) {
                    System.out.println("Error saving invoice");
                }

            }

        }

        String lowestName = "";
        String lowestArea = "";
        int lowestLoad = 100;


        for (int i = 0; i < driversCorrectArea.size(); i++) {


            if (driversCorrectArea.get(i).load < lowestLoad) {

                lowestLoad = driversCorrectArea.get(i).load;
                lowestName = driversCorrectArea.get(i).name;
                lowestArea = driversCorrectArea.get(i).area;


            }

        }

        //Create a new driver, which holds the information for the best driver
        Driver bestDriver = new Driver(lowestName, lowestArea, lowestLoad);


        //Update the driver with it's new load

        //Override the driver object in the driverInfoList
        String output = "";

        for (int i = 0; i < driverInfoList.size(); i++) {

            if (bestDriver.name.equals(driverInfoList.get(i).name)) {

                driverInfoList.set(i, new Driver(lowestName, lowestArea, lowestLoad + 1));

            }

            output += driverInfoList.get(i).name + ", " + driverInfoList.get(i).area + ", " + driverInfoList.get(i).load + "\n";

        }

        //Override the drivers.txt file with the new information

        try {
            Formatter f = new Formatter("Compulsory Task 1\\drivers.txt");
            f.format(output);
            f.close();
        } catch (Exception e) {
            System.out.println("Error saving customer list");
        }


        //Call the method to output the invoice
        outputInvoiceCorrect(bestDriver, orderArray, orderQuantityArray, orderPriceArray, currentCustomer, currentRestaurant);

    }

    //This method outputs the invoice

    public static void outputInvoiceCorrect(Driver bestDriver, ArrayList orderArray, ArrayList
            orderQuantityArray, ArrayList orderPriceArray,
                                            Customer currentCustomer, Restaurant currentRestaurant) {


        String output = "Order Number: " + currentCustomer.customerOrderNumber;
        output += "\nCustomer Name: " + currentCustomer.customerName;
        output += "\nCustomer Email: " + currentCustomer.customerEmail;
        output += "\nCustomer Phone Number: " + currentCustomer.customerNumber;
        output += "\nCustomer Address: " + currentCustomer.customerAddress;
        output += "\nCustomer City: " + currentCustomer.customerArea;
        output += "\n\n";
        output += "Here is you order from " + currentRestaurant.restaurantName;
        output += "\n";

        double total = 0;

        for (int i = 0; i < orderArray.size(); i++) {

            double totalPerLine = (int) orderQuantityArray.get(i) * (double) orderPriceArray.get(i);
            total += totalPerLine;
            output += orderQuantityArray.get(i) + " x " + orderArray.get(i) + "  (R" + totalPerLine + ")\n";


        }
        output += "Special Instructions: " + currentCustomer.customerInstructions;
        output += "\n";
        output += "Total: " + total;
        output += "\n\n";

        output += bestDriver.name + " is nearest to the restaurant and so he will be delivering your order";
        output += "\n";
        output += "If you need to contact the restaurant, their number is " + currentRestaurant.restaurantNumber;

        try {
            Formatter f = new Formatter("Compulsory Task 1\\invoice.txt");
            f.format(output);
            f.close();
        } catch (Exception e) {
            System.out.println("Error saving invoice");
        }


    }

    //This method outputs all the customers to a file, in different orders and grouping
    public static void outputAllCustomers(ArrayList<Customer> customerArrayList) {


        //Convert arrayList to array
        Customer[] unorderedCustomerArray = customerArrayList.toArray(new Customer[0]);

        //Create a new arrayList of just the customer names
        ArrayList<String> unorderedCustomerNamesListArray = new ArrayList<String>();

        //Loop through the unorderedCustomerArray and add each name to unorderedCustomerNames
        for (int i = 0; i < unorderedCustomerArray.length; i++) {

            unorderedCustomerNamesListArray.add(unorderedCustomerArray[i].customerName.toUpperCase());

        }

        //Convert unorderedCustomerNamesListArray to an array
        String[] customerNames = new String[unorderedCustomerNamesListArray.size()];
        unorderedCustomerNamesListArray.toArray(customerNames);

        //Sort customerNames alphabetically
        Arrays.sort(customerNames);

        //Create a listArray to hold the ordered customer objects
        ArrayList<Customer> orderedCustomers = new ArrayList<Customer>();

        //Add the customer to orderedCustomers based off customerNames
        for (int i = 0; i < customerNames.length; i++) {

            String currentName = customerNames[i];

            for (int j = 0; j < unorderedCustomerArray.length; j++) {

                if (currentName.equalsIgnoreCase(unorderedCustomerArray[j].customerName)) {

                    orderedCustomers.add(unorderedCustomerArray[j]);

                }

            }

        }

        //Output the information to the user
        String output = "Here's a list of customer names and order numbers! \n";

        for (int i = 0; i < orderedCustomers.size(); i++) {

            output += orderedCustomers.get(i).customerName + " : " + orderedCustomers.get(i).customerOrderNumber + "\n";

        }

        try {
            Formatter f = new Formatter("Compulsory Task 1\\customerList.txt");
            f.format(output);
            f.close();
        } catch (Exception e) {
            System.out.println("Error saving customer list");
        }

        //Output all customers grouped by location, sorting the customerArea alphabetically

        //Convert arrayList to array
        //customer[] unorderedCustomerArrayForArea = customerArrayList.toArray(new customer[0]);

        //Create a new arrayList of just the customer areas
        ArrayList<String> unorderedCustomerAreaListArray = new ArrayList<String>();

        //Loop through the unorderedCustomerArray and add each name to unorderedCustomerAreaListArray
        for (int i = 0; i < customerArrayList.size(); i++) {

            unorderedCustomerAreaListArray.add(customerArrayList.get(i).customerArea.toUpperCase());

        }

        //Convert unorderedCustomerAreaListArray to an array
        String[] customerAreas = new String[unorderedCustomerAreaListArray.size()];
        unorderedCustomerAreaListArray.toArray(customerAreas);

        //Sort customerNames alphabetically
        Arrays.sort(customerAreas);


        //Create a listArray to hold the ordered customer objects
        ArrayList<Customer> orderedCustomersArea = new ArrayList<Customer>();

        //Add the customers to orderedCustomersArea based off customerAreas
        for (int i = 0; i < customerAreas.length; i++) {

            String currentArea = customerAreas[i];

            for (int j = 0; j < customerArrayList.size(); j++) {

                if (currentArea.equalsIgnoreCase(customerArrayList.get(j).customerArea)) {

                    orderedCustomersArea.add(customerArrayList.get(j));
                    customerArrayList.remove(j);

                }

            }

        }

        //Output the information
        String outputForArea = "Here are the customers grouped by area \n\n";

        for (int i = 0; i < customerAreas.length; i++) {

            outputForArea += orderedCustomersArea.get(i).customerName + " : " + orderedCustomersArea.get(i).customerArea + "\n";

        }


        try {
            Formatter f = new Formatter("Compulsory Task 1\\customerListArea.txt");
            f.format(outputForArea);
            f.close();
        } catch (Exception e) {
            System.out.println("Error saving customer list");
        }

    }
}

/*________________________________________________________________________________________________________________
Reference: 
1.Student Notes 2021 HyperionDev: reading under task L2T11; 
2.https://google.github.io/styleguide/javaguide.html#s4-formatting
__________________________________________________________________________________________________________________*/

