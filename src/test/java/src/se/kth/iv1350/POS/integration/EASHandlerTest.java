package src.se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.model.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EASHandlerTest {
    private EASHandler instanceToTest;
    private PaymentDTO payment;
    private Sale sale;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        instanceToTest = new EASHandler();
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRegisterPayement() {
        payment = new PaymentDTO(200, "SEK");
        sale = new Sale();
        instanceToTest.registerPayment(payment, sale);
        String printOut = printoutBuffer.toString();
        assertTrue(printOut.contains("200"), "registerPayment does not work correctly.");


    }

}