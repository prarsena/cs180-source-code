//   The CellPhone class holds data about a cell phone.
public class CellPhone {
   private String manufact;    // Manufacturer
   private String model;       // Model
   private double retailPrice; // Retail price
   
   public CellPhone(String man, String mod, double price) {
      manufact = man;
      model = mod;
      retailPrice = price;
   }
   
   public void setManufact(String man) {
      manufact = man;
   }
   
   public void setMod(String mod) {
      model = mod;
   }

   public void setRetailPrice(double price) {
      retailPrice = price;
   }

   public String getManufact() {
      return manufact;
   }
   
   public String getModel() {
      return model;
   }
   
   public double getRetailPrice() {
      return retailPrice;
   }
}