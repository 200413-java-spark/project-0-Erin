package com.github.ettynan.mort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Java class to read in csv file and put information from it into a hashmap
 */
public class ReadIn {

    private Integer zipTemp = 0;
    private Double costTemp = 0.0;
    private HashMap<Integer, Double> houseCost = new HashMap<Integer, Double>();
    private BufferedReader file = null;
    private String pathToCsv = "/Users/user/Desktop/Revature/project-0/src/main/java/com/github/ettynan/mort/data.csv";
    private String line = "";

    /**
     * read in csv file to hashmap
     * @returns hashmap of average house cost in each zipcode
     */ 
    public HashMap<Integer, Double> getHouseCost(){
        try {
            file = new BufferedReader(new FileReader(pathToCsv));
            // Create hashmap of zipcodes and average house cost in that zipcode
            while((this.line = this.file.readLine()) != null) {
                String arr[] = this.line.split(",");
                this.zipTemp = Integer.parseInt(arr[0]);
                this.costTemp = Double.parseDouble(arr[1]);
                this.houseCost.put(this.zipTemp, this.costTemp);
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
        return this.houseCost;
    }
}