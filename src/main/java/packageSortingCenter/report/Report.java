package packageSortingCenter.report;

import packagingElements.packages.PackageType;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

public class Report {

    private Date date;
    private int dispatchedLKWs;
    private EnumMap<PackageType, Integer> numberPackagesGrouped;
    private int numberDangerousPackages;

    private Report(Report.Builder builder) {
        this.dispatchedLKWs = builder.dispatchedLKWs;
        this.date = builder.date;
        this.numberPackagesGrouped = builder.numberPackagesGrouped;
        this.numberDangerousPackages = builder.numberDangerousPackages;
    }

    public void writeToLog() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Date and Time: ");
        sb.append(date.toString());
        sb.append("\nNumber of dispatched LKW: ");
        sb.append(dispatchedLKWs);
        sb.append("\nGrouped Categories & Amount:\n");

        for (Map.Entry<PackageType, Integer> entry : numberPackagesGrouped.entrySet()) {
            PackageType packageType = entry.getKey();
            Integer number = entry.getValue();
            sb.append(packageType).append(": ").append(number).append("\n");
        }

        sb.append("Number of dangerous Packages: ");
        sb.append(numberDangerousPackages);
        FileWriter fileWriter = new FileWriter("report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(sb.toString());
        printWriter.close();
    }


    public static final class Builder {
        private Date date;
        private int dispatchedLKWs;
        private EnumMap<PackageType, Integer> numberPackagesGrouped;
        private int numberDangerousPackages;



        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder dispatchedLKWs(int dispatchedLKWs) {
            this.dispatchedLKWs = dispatchedLKWs;
            return this;
        }

        public Builder numberPackagesGrouped(EnumMap<PackageType, Integer> numberPackagesGrouped) {
            this.numberPackagesGrouped = numberPackagesGrouped;
            return this;
        }

        public Builder numberDangerousPackages(int numberDangerousPackages) {
            this.numberDangerousPackages = numberDangerousPackages;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}
