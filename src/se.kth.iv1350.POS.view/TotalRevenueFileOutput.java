package src.se.kth.iv1350.POS.view;

import src.se.kth.iv1350.POS.model.SaleObserver;
import src.se.kth.iv1350.POS.util.PrintWriterComposition;
import src.se.kth.iv1350.POS.util.PrintWriterInheritance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * TotalRevenueFileOutput This class writes the total income from the register since the program was started.
 */
class TotalRevenueFileOutput extends TotalRevenueDisplay {
    private PrintWriterComposition logFileComp;
    private PrintWriterInheritance logFileInherit;

    /**
     * Genreates a new instance of the TotalRevenueFileOutput class
     */
    TotalRevenueFileOutput() {
        try {
            logFileComp = new PrintWriterComposition();
            logFileInherit = new PrintWriterInheritance();
        } catch (IOException e) {
            System.out.println("[FOR DEVELOPER]: Could not create logger.");
            e.printStackTrace();
        }
    }

    @Override
    protected void doShowTotalIncome(double totalRevenue) throws Exception {
        logFileComp.println("Total revenue: " + totalRevenue);
        logFileInherit.println("Total revenue: " + totalRevenue);
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println("[FOR DEVELOPER]: Something went wrong when writing to the file " + e.getMessage());
        e.printStackTrace();
    }
}
