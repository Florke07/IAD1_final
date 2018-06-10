package inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDataFromTXT implements ReadData {
    public ArrayList<Integer> readInt(final String pathToFile) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        FileReader file;
        BufferedReader br;
        int readed;

        try {
            file = new FileReader(pathToFile);
            br = new BufferedReader(file);

            while ((readed = br.read()) != -1) {
                char rd = (char) readed;
                readed = Character.getNumericValue(rd);
                if (readed != -1) {
                    list.add(readed);
                    //System.out.println(readed);
                }
            }
            br.close();
        } catch (FileNotFoundException fnfex) {
            System.out.println("Unable to open file! File not found");
        } catch (IOException ioex) {
            System.out.println("Read file error");
        }

        return list;
    }

    public ArrayList<Double> readDouble(final String pathToFile) {
        ArrayList<Double> list = new ArrayList<>();
        Scanner scan;
        File file = new File("approximation_train_1.txt");
        try {
            scan = new Scanner(file);

            while(scan.hasNextDouble())
            {
                System.out.println("KURWA?");
                list.add( scan.nextDouble() );
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        return list;
    }

    public ArrayList<String> readStringLines(final String pathToFile) {
        ArrayList<String> list = new ArrayList<String>();
        FileReader file;
        BufferedReader br;
        String readed;

        try {
            file = new FileReader(pathToFile);
            br = new BufferedReader(file);

            while ((readed = br.readLine()) != null) {
                //System.out.println(readed);
                list.add(readed);
            }
            br.close();
        } catch (FileNotFoundException fnfEX) {
            System.out.println("File not found");
        } catch (IOException ioEX) {
            System.out.println("Error reading file");
        }

        return list;
    }
}
