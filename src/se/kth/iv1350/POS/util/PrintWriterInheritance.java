package src.se.kth.iv1350.POS.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * PrintWriterInheritance
 */
public class PrintWriterInheritance extends PrintWriter {
    /**
     * Creates a new instance of the PrintWriterInheritance class
     * @throws IOException if the named file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason
     */
    public PrintWriterInheritance() throws IOException {
        super(new FileWriter("total-revenue-inheritance.txt"), true);
    }

    @Override
    public void println(String message) {
        LocalTime timeOfWrite = LocalTime.now();
        LocalDate dateOfWrite = LocalDate.now();
        super.println("Print from " + dateOfWrite + " at " + timeOfWrite.getHour() + ":" + timeOfWrite.getMinute() + " \n" + message);
    }

}
