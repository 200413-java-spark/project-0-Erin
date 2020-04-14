import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Mort {

    public static void main(String []args) {
        // declare variables
        int monthsPerYear = 12;
        int years = 0;
        double downPay = 0.0;
        double interest = 0.0;
        Integer zip = 0;
        HashMap<Integer, Double> houseCost = new HashMap<Integer, Double>();

        // read in file
        BufferedReader file = null;
        String pathToCsv = "/Users/user/Desktop/Revature/project-0/data.csv";
        String line = "";
        try {
            file = new BufferedReader(new FileReader(pathToCsv));
            // Create hashmap of zipcodes and average house cost in that zipcode
            while((line = file.readLine()) != null) {
                String arr[] = line.split(",");
                Integer zipTemp = Integer.parseInt(arr[0]);
                Double costTemp = Double.parseDouble(arr[1]);
                houseCost.put(zipTemp, costTemp);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException  e) {
            e.printStackTrace();
        }
        finally {
            try{
                file.close();
            } catch (Exception e) {
                System.out.println("Could not close file.\n");
            }
        }
        // parse input; parse interest rate, parse zipcode, down payment
        if (args.length > 0) {
            try{
                downPay = Double.parseDouble(args[0]);
                interest = Double.parseDouble(args[1]);
                years = Integer.parseInt(args[2]);
                zip = Integer.parseInt(args[3]);
            } // catch if non number entered 
            catch (NumberFormatException e) {
                System.out.print("Numbers only please");
                System.exit(1);
            } // catch if one piece of input missing
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Input all needed information please. \n");
                System.exit(1);
            }

            // calculate monthly payment
            float monthlyInterest = (float) ((interest / 100) / monthsPerYear);
            int numOfPayments = years * monthsPerYear;
            double raised = 1 - Math.pow((1 + monthlyInterest),(-1 * numOfPayments));
            float factor = (monthlyInterest)/((float) raised);

            // use zipcode to return the average house cost then use cost-downpayment to find payment
            double avgCost = houseCost.get(zip);
            double principle = avgCost-downPay;
            double monthlyPay = factor * principle;
            System.out.printf("%.2f\n", monthlyPay);
        }

    }
}