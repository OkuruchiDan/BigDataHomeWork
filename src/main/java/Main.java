

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
            String[] header = csvReader.readNext();// read the header

            CSVParserBuilder csvParserBuilder = new CSVParserBuilder();
            // this array of string will be always redefined
            String[] nextLine = csvReader.readNext();// read empty field
            System.out.println(Arrays.toString(nextLine));

            int i = 0;
            List<InfoAboutOneAVGTIP> infoAboutOneAVGTIPSList = new ArrayList<>(1048576);
            while ((nextLine = csvReader.readNext()) != null && i < 1048576) {
                i++;
                InfoAboutOneAVGTIP infoAboutOneAVGTIP = new InfoAboutOneAVGTIP(nextLine[1], nextLine[4], nextLine[9], nextLine[13]);
                infoAboutOneAVGTIPSList.add(infoAboutOneAVGTIP);
            }
            infoAboutOneAVGTIPSList.forEach(System.out::println);
        } catch (IOException e) { // Handling IO from FileReader
            e.printStackTrace();
        }
    }
}
