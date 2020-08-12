import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Path to .csv file
        String pathToFile = "/home/bogdan/Programming/HomeWorkBigData/yellow_tripdata_2018-01.csv";
        File file = new File(pathToFile);
        System.out.println(file.canRead()); // checking readable of the file.

    }
}
