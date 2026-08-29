public class CalculatePay {
   public static void main(String[] args) {
      // Hours worked and pay rate for the week.
      int hours = 40;
      double grossPay, payRate = 25.0;

      // Multiply hours by pay rate to get gross pay.
      grossPay = hours * payRate;
      System.out.println("Your gross pay is $" + grossPay);
   }
}