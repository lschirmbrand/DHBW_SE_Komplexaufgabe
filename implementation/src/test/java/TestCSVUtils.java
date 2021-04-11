import configuration.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utillity.csvTools.CSVBuilder;
import utillity.csvTools.CSVReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCSVUtils {

    @Test
    @DisplayName("Test the build of the csv's")
    public void testCSVBuilding() {
        CSVBuilder.main();
    }

    @Test
    @DisplayName("Test the result of Packages")
    public void testCSVPackages() {
        CSVReader csvReader = new CSVReader();
        assertEquals(csvReader.readPackages().size(), Configuration.instance.numberOfPackages);
    }

    @Test
    @DisplayName("Test the result of Boxes")
    public void testCSVBoxes() {
        CSVReader csvReader = new CSVReader();
        assertEquals(csvReader.readBoxes().size(), Configuration.instance.numberOfBoxes);
    }

    @Test
    @DisplayName("Test the result of Pallets")
    public void testCSVPallets() {
        CSVReader csvReader = new CSVReader();
        assertEquals(csvReader.readPallets().size(), Configuration.instance.numberOfPallets);
    }

    @Test
    @DisplayName("Test the result of LKWs")
    public void testCSVLKWs() {
        CSVReader csvReader = new CSVReader();
        assertEquals(csvReader.readLKW().size(), Configuration.instance.numberOfLKWS);
    }
}