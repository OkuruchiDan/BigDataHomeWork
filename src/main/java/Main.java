import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Path to .csv file
        String pathToFile = "/home/bogdan/Programming/HomeWorkBigData/yellow_tripdata_2018-01.csv";
        try (FileReader fileReader = new FileReader(pathToFile)) { // this initialization will close Reader stream automatically
            // create CSVReader from OpenCSV lib
            CSVReader csvReader = new CSVReader(fileReader, ',', '"');
            // create ArrayList with 1500 capacity fore store all data
            List<String[]> allData = new ArrayList<>(1500);
            // Every next string will be printed and add to ArrayList
            String[] nextLine; // this array of string will be always redefined
            while((nextLine = csvReader.readNext()) != null){
                System.out.println(Arrays.toString(nextLine));
                allData.add(nextLine); // add to ArrayList
            }
        } catch (IOException e) { // Handling IO from FileReader
            e.printStackTrace();
        }
    }
}
