public class Customer {

    //Attributes
    String customerName;
    String customerNumber;
    String customerAddress;
    String customerArea;
    String customerEmail;
    String customerInstructions;
    int customerOrderNumber;


    //Constructor
    public Customer(String customerName, String customerNumber, String customerAddress, String customerArea,
                    String customerEmail, String customerInstructions, int customerOrderNumber) {

        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.customerArea = customerArea;
        this.customerEmail = customerEmail;
        this.customerInstructions = customerInstructions;
        this.customerOrderNumber = customerOrderNumber;

    }
}
