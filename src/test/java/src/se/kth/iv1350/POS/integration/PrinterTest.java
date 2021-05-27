package src.se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    private Printer instanceToTest;
    private Receipt receipt;
    private Sale sale;
    private PaymentDTO payment;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        instanceToTest = new Printer();
        sale = new Sale();
        payment = new PaymentDTO(100, "SEK");
        receipt = new Receipt(sale, payment);
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
        instanceToTest = null;
        sale = null;
        payment = null;
        receipt = null;
    }

    @Test
    public void testIfPrintReceiptWorks() {
        instanceToTest.printReceipt(receipt, sale);
        String printOut = printoutBuffer.toString();
        assertTrue(printOut.contains("receipt"), "printReceipt does not print.");
    }
}