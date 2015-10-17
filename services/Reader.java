import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader((new FileReader("2007-2.csv")));
        File csvFolder = new File("/Users/spejs/Documents/Resportsee");
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if(nextLine[2].contains("DALLAS, TX")){
                //TODO: DATABASE CONNECTION, DATA INSERTION
                System.out.printf("%s %s %s %s %s \n",nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[6]);
            }

        }
    }
}
