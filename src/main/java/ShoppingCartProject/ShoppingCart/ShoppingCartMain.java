package ShoppingCartProject.ShoppingCart;

import java.util.Scanner;
public class ShoppingCartMain {

    /*Shopping cart system: Write a java program to check whether selected product has been choosen correctly.
     For ex. if one customer choose to buy 1 kg suger then price will be decided based on the rate of product and the quantity.

    [
        Hints: Consider one array of the product rate, mark this as static inside main class (the class will be having main methods) the aray structure will be like
               float[] productRate = {$30/kg, $50/items, $35/litre}
               items of these array there rate will be 3 type of the product: 'grocery', 'cosmatics', 'dairyproduct'.
        For ex. if customer choose 1 kg suger/wheat/Rice that means this will come uder 'grocery' type product and the price will be calculated based
        on the rate ($30 * 1) =  $30 will be the price
        Similarly, if customer choose 2 items of Facewash/Soap/detergent that means this will come uder 'cosmatics' type product and the price will
        be calculated based on the rate ($50 * 2) =  $100 will be the product price
        Similarly, if customer choose 1/2 litre items of milk/Panner/butter that means this will come uder 'dairyproduct' type product and the price will be
        calculated based on the rate ($35 * 1/2) =  $17.5 will be the product price

        create a class name 'ShoppingCart' with attribute / class variables as 'productId', 'ProductName', 'productQuantity', 'costOfTheProduct', 'custId',
        'custName', 'custEmail', 'custMobile',
        take input of 'productId', 'ProductName', 'productQuantity', 'custId', 'custName', 'custEmail', 'custMobile'.
        While taking input need to put few validation. Find below the validation rules:
        1. ProductId should be in the format of 'P01'
        2. Customer id should be in the format of 'C01'
        3. Customer phone number should be length of 10 not more than that.

        if any of the condition fail will exit from the program. (Using System.exit(0))

        once all the validation sucessfull then calcaulate the price of the product applying above rules := 'productQuantity' * rate
        (static array, to access elements of the array use array[0], array[1], array[2]. No need to iterate)

        Product quantity need to store DB in below format,
                if the productQuantity is 1 and the product is dairyproduct then it should display 1 lt, likewise for othercases.
                if the productQuantity is 1 and the product is grocery then it should display 1 kg, likewise for othercases.
                if the productQuantity is 1 and the product is cosmatics then it should display 1 piece, likewise for othercases.


        using Hibernate store all the required information to Database table named as 'customer_shopping_cart' with the columns like custId
        (primary key), custName, custEmail, custMobile, ProductId, ProductName, productQuantity, finalProductPrice.

        Finally once record saved then show a message that data has been save successfully.

        Once record save to database fetch all the record and display in the console.
    ]
    * */
    private static float[] productRate = {30, 50, 35};
    private static String [] groceries = {"rice", "wheat", "sugar"};
    private static String[] cosmetics = {"facewash", "soap", "detergent"};
    private static String[] dairy  = { "milk", "panner","butter"};
    private static String [] ProductType = {"groceries", "cosmetics","dairy"};

    public static void main(String[] args) {

        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Customer ID");
        String customerID = sc.next();

        if (customerID.charAt(0)=='c') {
            customer.setCustId(customerID);
        }else {
            System.exit(1);
        }

        System.out.println("Enter Customer Name:");
        String customerName= sc.next();
        customer.setCustName(customerName);

        System.out.println("Enter Customer Email:");
        String customerEmail = sc.next();
        customer.setCustEmail(customerEmail);

        System.out.println("Enter Customer Mobile No");
        String mobile = sc.next();

        if (mobile.length()==10) {
            customer.setCustMobile(mobile);
        }else {
            System.exit(1);
        }

        System.out.println("Enter Product ID:");
        String productID = sc.next();
        if (productID.charAt(0)=='p') {
            customer.setProductId(productID);
        }else {
            System.exit(1);
        }
        System.out.println("Enter the Quantity:");
        float quantity = sc.nextFloat();

        System.out.println("Enter Product Name:");
        String productName = sc.next();
        customer.setProductName(productName);

        for (int i=0; i<3; i++){
            if (productName.equalsIgnoreCase(groceries[i])){
            customer.setTotalCostOfProducts(quantity*productRate[0]);
            customer.setProductQuantity(quantity+"kg");
            }else if (productName.equalsIgnoreCase(cosmetics[i])){
            customer.setTotalCostOfProducts(quantity*productRate[1]);
            customer.setProductQuantity(quantity+"pcs");
            } else if (productName.equalsIgnoreCase(dairy[i])){
            customer.setTotalCostOfProducts(quantity*productRate[2]);
            customer.setProductQuantity(quantity+"ltr");
            }
        }
        System.out.println(customer.toString());

    }

}
