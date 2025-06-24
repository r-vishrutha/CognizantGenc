public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }
}
public class Main {
    public static void main(String[] args) {
        double presentValue = 10000; // ₹10,000
        double annualRate = 0.05;    // 5% growth
        int years = 5;

        double futureValue = FinancialForecast.calculateFutureValue(presentValue, annualRate, years);
        System.out.printf("Future Value after %d years: ₹%.2f%n", years, futureValue);
    }
}

