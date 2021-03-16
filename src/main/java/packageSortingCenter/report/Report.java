package packageSortingCenter.report;

import packagingElements.packages.PackageType;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.EnumMap;

public class Report {

    private Date date;
    private int dispatchedLKWs;
    private String[] numberPackagesGrouped;
    private int numberDangerousPackages;

    private Report(Builder builder) {
        date = builder.date;
        dispatchedLKWs = builder.dispatchedLKWs;
        numberPackagesGrouped = builder.numberPackagesGrouped;
        numberDangerousPackages = builder.numberDangerousPackages;
    }

    public void writeToLog() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Date and Time: ");
        sb.append(date.toString());
        sb.append("\nNumber of dispatched LKW: ");
        sb.append(dispatchedLKWs);
        sb.append("Grouped Categories & Amount:\n");
        for (String s : numberPackagesGrouped) {
            sb.append(s);
        }
        sb.append("Number of dangerous Packages: ");
        sb.append(numberDangerousPackages);
        FileWriter fileWriter = new FileWriter("report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(sb.toString());
        printWriter.close();
    }

    public static class Builder {

        private Date date;
        private int dispatchedLKWs;
        private String[] numberPackagesGrouped;
        private int numberDangerousPackages;


        public Builder date() {
            this.date = new Date();
            return this;
        }

        public Builder dispatchedLKWs(int size) {
            this.dispatchedLKWs = size;
            return this;
        }

        public Builder setNumberPackagesGrouped(EnumMap<PackageType, Integer> packageType) {
            String[] numberPackagesGrouped = new String[3];
            StringBuilder sb = new StringBuilder();
            sb.append(PackageType.NORMAL.toString());
            sb.append(": ");
            sb.append(packageType.get(PackageType.NORMAL));
            sb.append(";\n");
            numberPackagesGrouped[0] = sb.toString();

            //clear stringbuilder
            sb.setLength(0);

            sb.append(PackageType.EXPRESS.toString());
            sb.append(": ");
            sb.append(packageType.get(PackageType.EXPRESS));
            sb.append(";\n");
            numberPackagesGrouped[1] = sb.toString();

            //clear stringbuilder
            sb.setLength(0);

            sb.append(PackageType.VALUE.toString());
            sb.append(": ");
            sb.append(packageType.get(PackageType.VALUE));
            sb.append(";\n");
            numberPackagesGrouped[2] = sb.toString();

            return this;
        }

        public Builder setNumberDangerousPackages(int amount) {
            this.numberDangerousPackages = amount;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}
