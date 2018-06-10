package inputoutput;

import java.util.ArrayList;

public interface ReadData {
    ArrayList<Integer> readInt(String pathToFile);
    ArrayList<Double> readDouble(String pathToFile);
    ArrayList<String> readStringLines(final String pathToFile);
}
