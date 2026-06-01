import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoTradingSystemTest {

    @Test
    void buyNiceTiming_buys_max_quantity_when_3_consecutive_rises() {
        MockDriver mock = new MockDriver();
        mock.addPrice(1000); mock.addPrice(2000); mock.addPrice(3000); mock.addPrice(4000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(mock);

        ats.buyNiceTiming("005930", 12000); // 12000 / 4000 = 3주

        assertEquals(1, mock.getBuyCallCount());
        assertEquals("005930", mock.getLastBuyStockCode());
        assertEquals(4000, mock.getLastBuyPrice());
        assertEquals(3, mock.getLastBuyCount());
    }

    @Test
    void buyNiceTiming_does_not_buy_when_not_uptrend() {
        MockDriver mock = new MockDriver();
        mock.addPrice(1000); mock.addPrice(2000); mock.addPrice(1500); mock.addPrice(3000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(mock);

        ats.buyNiceTiming("005930", 12000);

        assertEquals(0, mock.getBuyCallCount());
    }

    @Test
    void sellNiceTiming_sells_all_when_3_consecutive_drops() {
        MockDriver mock = new MockDriver();
        mock.addPrice(4000); mock.addPrice(3000); mock.addPrice(2000); mock.addPrice(1000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(mock);

        ats.sellNiceTiming("005930", 10);

        assertEquals(1, mock.getSellCallCount());
        assertEquals(1000, mock.getLastSellPrice());
        assertEquals(10, mock.getLastSellCount());
    }

    @Test
    void sellNiceTiming_does_not_sell_when_not_downtrend() {
        MockDriver mock = new MockDriver();
        mock.addPrice(4000); mock.addPrice(3000); mock.addPrice(3500); mock.addPrice(1000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(mock);

        ats.sellNiceTiming("005930", 10);

        assertEquals(0, mock.getSellCallCount());
    }
}
