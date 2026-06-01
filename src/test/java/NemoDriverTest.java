import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class NemoDriverTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    @BeforeEach
    void redirectStdout() { out = new ByteArrayOutputStream(); System.setOut(new PrintStream(out)); }

    @AfterEach
    void restoreStdout() { System.setOut(originalOut); }

//    @Test
//    void nemoDriver_is_StockBrokerDriver() {
//        StockBrokerDriver driver = new NemoDriver();
//        assertNotNull(driver);
//    }
//
//    @Test
//    void login_delegates_to_certification() {
//        new NemoDriver().login("david", "pw");
//        assertTrue(out.toString().contains("[네모]david님 로그인 성공"));
//    }
//
//    @Test
//    void buy_maps_to_purchasingStock_with_price() {
//        // buy(code, price, count) -> NemoAPI.purchasingStock(code, price, count)
//        new NemoDriver().buy("005930", 7000, 3);
//        assertTrue(out.toString().contains("[네모]005930를 7000가격에 매수하였음"));
//    }
//
//    @Test
//    void sell_maps_to_sellingStock_with_price() {
//        new NemoDriver().sell("005930", 9000, 2);
//        assertTrue(out.toString().contains("[네모]005930를 9000가격에 매도하였음"));
//    }
//
//    @Test
//    void getPrice_handles_InterruptedException_and_returns_value_in_range() {
//        int price = new NemoDriver().getPrice("005930");
//        assertTrue(price >= 4100 && price <= 5900, "actual=" + price);
//    }
}
