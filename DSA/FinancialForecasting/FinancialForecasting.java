package DSA.FinancialForecasting;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinancialForecasting {

    // Recursive Method
    public static double forecast(double currentValue,
                                  double growthRate,
                                  int years) {

        if (years == 0) {
            return currentValue;
        }

        return forecast(
                currentValue * (1 + growthRate / 100),
                growthRate,
                years - 1
        );
    }

    public static void displayData(ArrayList<Double> data) {

        if (data.isEmpty()) {
            System.out.println("No financial data available.");
            return;
        }

        System.out.println("\nFinancial Data:");

        for (int i = 0; i < data.size(); i++) {
            System.out.printf("Year %d : %.2f%n",
                    i + 1, data.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> financialData = new ArrayList<>();

        int choice = 0;

        do {

            try {

                System.out.println("\nFINANCIAL FORECASTING SYSTEM");
                System.out.println("1. Add Historical Data");
                System.out.println("2. Generate Forecast");
                System.out.println("3. Display Data");
                System.out.println("4. Exit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Financial Value: ");
                        double value = sc.nextDouble();

                        financialData.add(value);

                        System.out.println("Data Added Successfully.");
                        break;

                    case 2:

                        if (financialData.isEmpty()) {
                            System.out.println(
                                    "No historical data available for forecasting.");
                            break;
                        }

                        System.out.print("Enter Growth Rate (%): ");
                        double growthRate = sc.nextDouble();

                        System.out.print("Enter Number of Years: ");
                        int years = sc.nextInt();

                        double latestValue =
                                financialData.get(financialData.size() - 1);

                        double predictedValue =
                                forecast(latestValue,
                                        growthRate,
                                        years);

                        System.out.printf(
                                "Forecasted Value after %d year(s): %.2f%n",
                                years,
                                predictedValue);

                        // Store Forecast in ArrayList
                        financialData.add(predictedValue);

                        System.out.println(
                                "Forecast added to financial records.");

                        break;

                    case 3:

                        displayData(financialData);
                        break;

                    case 4:

                        System.out.println("Exiting...");
                        break;

                    default:

                        System.out.println("Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid Input. Please enter valid numeric values.");
                sc.nextLine();

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}