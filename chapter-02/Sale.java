// This program demonstrates the double data type.

public class Sale {
   public static void main(String[] args) {
      double price, tax, total;
      //float myFloat;

      double grossPay;
      //grossPay = 1_478_000.00;
      grossPay = 4.729823E4;
      System.out.println("Gross pay: " + grossPay);

      price = 29.75;
      tax = 1.76;
      total = 31.51;
      System.out.println("The price of the item " +
                         "is " + price);
      System.out.println("The tax is " + tax);
      System.out.println("The total is " + total);
   }
}
