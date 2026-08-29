public class LawyerHours {
    public static void main(String[] args) {
        // Make sure the lawyer bills at least 5 hours.
        int hours = 3;

        int billableHours;
        if (hours < 5){
            billableHours = 5;
        } else {
            billableHours = hours;
        }
        System.out.println(billableHours);

        // CONDITIONAL OPERATOR FORMULA
        //          booleanExpression ? valueIfTrue : valueIfFalse
        int billableHoursConditional = (hours < 5) ? 5 : hours;
        System.out.println(billableHoursConditional);
    }
}
