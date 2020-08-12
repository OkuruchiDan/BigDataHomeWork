

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Path to .csv file
        String pathToFile = "/home/bogdan/Programming/HomeWorkBigData/yellow_tripdata_2018-01.csv";
        try (FileReader fileReader = new FileReader(pathToFile)) { // this initialization will close Reader stream automatically
            // create CSVReader from OpenCSV lib

            CSVReader csvReader = new CSVReader(fileReader);
            String[] header = csvReader.readNext();

            CSVParserBuilder csvParserBuilder = new CSVParserBuilder();

            // Every next string will be printed and add to ArrayList
            String[] nextLine = csvReader.readNext(); // this array of string will be always redefined
            System.out.println(Arrays.toString(nextLine));


            List<InfoAboutOneAVGTIP> infoAboutOneAVGTIPSList = new ArrayList<>(1048576);
            while((nextLine = csvReader.readNext()) != null ){

                InfoAboutOneAVGTIP infoAboutOneAVGTIP = new InfoAboutOneAVGTIP(nextLine[1], nextLine[4], nextLine[9], nextLine[13]);
                infoAboutOneAVGTIPSList.add(infoAboutOneAVGTIP);
            }
            infoAboutOneAVGTIPSList.forEach(System.out::println);
        } catch (IOException e) { // Handling IO from FileReader
            e.printStackTrace();
        }
    }
}
