package utillity.csvTools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements ICSVReader {
    @Override
    public List<String[]> readLKW() {
        int count = 0;
        String file = "base_lkw.csv";
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
