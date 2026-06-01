import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MockDriverTest {

    @Test
    void mockDriver_is_StockBrokerDriver() {
        StockBrokerDriver driver = new MockDriver();
        assertNotNull(driver);
    }

    @Test
    void login_records_call_and_id() {
        MockDriver mock = new MockDriver();
        mock.login("david", "pw");
        assertTrue(mock.isLoginCalled());
        assertEquals("david", mock.getLoginId());
    }

    @Test
    void buy_records_arguments() {
        MockDriver mock = new MockDriver();
        mock.buy("005930", 7000, 3);
        assertEquals(1, mock.getBuyCallCount());
        assertEquals("005930", mock.getLastBuyStockCode());
        assertEquals(7000, mock.getLastBuyPrice());
        assertEquals(3, mock.getLastBuyCount());
    }

    @Test
    void sell_records_arguments() {
        MockDriver mock = new MockDriver();
        mock.sell("005930", 9000, 5);
        assertEquals(1, mock.getSellCallCount());
        assertEquals(9000, mock.getLastSellPrice());
        assertEquals(5, mock.getLastSellCount());
    }

    @Test
    void getPrice_returns_scripted_prices_in_FIFO_order() {
        MockDriver mock = new MockDriver();
        mock.addPrice(1000);
        mock.addPrice(2000);
        assertEquals(1000, mock.getPrice("005930"));
        assertEquals(2000, mock.getPrice("005930"));
    }

    @Test
    void getPrice_returns_getPriceCallCount() {
        MockDriver mock = new MockDriver();
        mock.addPrice(1000);
        mock.addPrice(2000);

        assertThat(mock.getPriceCallCount()).isEqualTo(2);
    }
}
