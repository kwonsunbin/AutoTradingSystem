import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class KiwerDriverTest {
//
//    private final PrintStream originalOut = System.out;
//    private ByteArrayOutputStream out;
//
//    @BeforeEach
//    void redirectStdout() { out = new ByteArrayOutputStream(); System.setOut(new PrintStream(out)); }
//
//    @AfterEach
//    void restoreStdout() { System.setOut(originalOut); }
//
//    @Test
//    void kiwerDriver_is_StockBrokerDriver() {
//        StockBrokerDriver driver = new KiwerDriver();
//        assertNotNull(driver);
//    }
//
//    @Test
//    void login_delegates_to_KiwerAPI() {
//        new KiwerDriver().login("david", "pw");
//        assertTrue(out.toString().contains("david님 로그인 성공"));
//    }
//
//    @Test
//    void buy_maps_price_correctly_to_KiwerAPI() {
//        // buy(code, price, count) -> KiwerAPI.buy(code, count, price)
//        new KiwerDriver().buy("005930", 7000, 3);
//        assertTrue(out.toString().contains("005930를 7000가격에 매수하였음"));
//    }
//
//    @Test
//    void sell_maps_price_correctly_to_KiwerAPI() {
//        new KiwerDriver().sell("005930", 9000, 2);
//        assertTrue(out.toString().contains("005930를 9000가격에 매도하였음"));
//    }
//
//    @Test
//    void getPrice_returns_value_in_KiwerAPI_range() {
//        int price = new KiwerDriver().getPrice("005930");
//        assertTrue(price >= 4100 && price <= 5900, "actual=" + price);
//    }
}
