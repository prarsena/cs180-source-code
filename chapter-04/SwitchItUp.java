public class SwitchItUp {
    public static void main(String[] args) {
        // Choose a discount rate based on customer type.
        double discountRate;
        char custType = 'D';
        switch (custType) {
            case 'A' -> discountRate = 0.08;
            case 'B' -> discountRate = 0.06;
            case 'C' -> discountRate = 0.04;
            default -> discountRate = 0.0;
        };
        System.out.println(discountRate);
    }
}
