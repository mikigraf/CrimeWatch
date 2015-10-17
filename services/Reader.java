import com.opencsv.CSVReader;

import java.beans.Statement;
import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Reader {

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Test Excel Sheets");

        File cvsFolder = new File("/Users/spejs/Documents/Reportsee Database 2007-2010");
        File[] listOfSpreadsheets = cvsFolder.listFiles();
        int i = 0;
        int assault = 0;
        int arrest = 0;
        int burglary = 0;
        int robbery = 0;
        int shooting = 0;
        int theft = 0;
        int vandalism = 0;
        int other = 0;

        int Dallas = 0;
        int Gainesville = 0;
        int KansasCity = 0;
        int Miami = 0;
        int Atlanta = 0;
        int Washington = 0;
        for(File f : listOfSpreadsheets){
            System.out.println(f.toString());
            CSVReader csvReader = new CSVReader((new FileReader(f)));
            String[] nextLine;
            if(f.getName().equals(new String(".DS_Store"))){
            }else if(f.getName().contains("2007")){
                while((nextLine = csvReader.readNext()) != null){
                    //System.out.println(nextLine[1] + " CITY: " + nextLine[2]);
                    if(nextLine[2].contains("DALLAS, TX")){
                        System.out.println("INSERT INTO crimes (TYPE,CITY,X,Y,DETAILS) VALUES (\"" + nextLine[1] + "\",\"" + nextLine[2] + "\"," + nextLine[3] + "," + nextLine[4] + ",\"" + nextLine[6] + "\");");
                        //System.out.println("mMap.addCircle(new CircleOptions().center(new LatLng(" +  nextLine[3] + ","+ nextLine[4]+")).radius(1000));");
                        //System.out.println("mMap.addMarker(new MarkerOptions().position(new LatLng(" + nextLine[3] + "," + nextLine[4] + ")).title(\"" + nextLine[1] + "\").visible(false).snippet(\""+ nextLine[1] +"\"));");
                        Dallas++;
                    }else if(nextLine[2].contains("GAINESVILLE, FL")){
                        Gainesville++;
                    }else if(nextLine[2].contains("KANSAS CITY")){
                        KansasCity++;
                    }else if(nextLine[2].contains("MIAMI")){
                        Miami++;
                    }else if(nextLine[2].contains("ATLANTA")){
                        Atlanta++;
                    }else if(nextLine[2].contains("WASHINGTON")){
                        Washington++;
                    }
                    if(nextLine[1].equals(new String("Assault"))){
                        assault++;
                    }
                    if(nextLine[1].equals(new String("Arrest"))){
                        arrest++;
                    }
                    if(nextLine[1].equals(new String("Burglary"))){
                        burglary++;
                    }
                    if(nextLine[1].equals(new String("Robbery"))){
                        robbery++;
                    }
                    if(nextLine[1].equals(new String("Shooting"))){
                        shooting++;
                    }
                    if(nextLine[1].equals(new String("Theft"))){
                        theft++;
                    }
                    if(nextLine[1].equals(new String("Vandalism"))){
                        vandalism++;
                    }
                    if(nextLine[1].equals(new String("Other"))){
                        other++;
                    }

                    i++;
                }
            }else{
                while((nextLine = csvReader.readNext()) != null){
                    i++;

                }
            }

        }
        /*

        System.out.println("NUMBER OF RECORDS = " + i);
        System.out.println("Assaults: " + assault);
        System.out.println("Arrests: " + arrest);
        System.out.println("Burglaries: " + burglary);
        System.out.println("Robberies: " + robbery);
        System.out.println("Shootings: " + shooting);
        System.out.println("Thefts: " + theft);
        System.out.println("Vandalisms: " + vandalism);
        System.out.println("Other: " + other);
        int sum = assault+arrest+burglary+robbery+shooting+theft+vandalism+other;
        System.out.println("CONTROL OUTPUT: " + (i-sum));
        System.out.println("Crimes in Dallas in 2007: " + Dallas);
        System.out.println("Crimes in Gainesville in 2007: " + Gainesville);
        System.out.println("Crimes in Miami in 2007: " + Miami);
        System.out.println("Crimes in Kansas City in 2007: " + KansasCity);
        System.out.println("Crimes in Atlanta in 2007: " + Atlanta);
        System.out.println("Crimes in Washington in 2007: " + Washington);

*/

        //List myEntries = reader.readAll();
        /*
        while((nextLine = reader.readNext())!= null){
            System.out.println("Index: " + i + " REKORD: " + nextLine[0] + " " + nextLine[1] + " " + nextLine[3] + " " + nextLine[4]);
            i++;
        }
        */

        System.out.println("Sheet imported succesfully!");

        /*
    }
        int numberOfRecords = 0;
        CSVReader reader = new CSVReader((new FileReader("2007-2.csv")));
        File csvFolder = new File("/Users/spejs/Documents/Resportsee");
        String[] nextLine;
        /*
        while ((nextLine = reader.readNext()) != null) {
            if(nextLine[2].contains("DALLAS, TX")){
                //TODO: DATABASE CONNECTION, DATA INSERTION
                /*
                1 - type of crime
                2 - postal code
                3 - city
                4 - gps coordinates
                6 - details

                System.out.printf("%s %s %s %s %s \n",nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[6]);
                numberOfRecords++;
            }

        }

        String[] sheets = {"2007-1.csv","2007-3.csv","2007-4.csv"};
        for(String s : sheets){
            CSVReader sheetReader = new CSVReader((new FileReader(s)));
            String[] nextRow;
            while((nextRow  = sheetReader.readNext()) != null){
                System.out.println(nextRow[2]);
            }
        }
        */

    }


}
