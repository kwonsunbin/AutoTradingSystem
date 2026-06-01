import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutoTradingSystemTest {

    @Mock
    StockBrokerDriver driver;

    @Test
    void buyNiceTiming_buys_max_quantity_when_3_consecutive_rises() {
        when(driver.getPrice("005930")).thenReturn(1000, 2000, 3000, 4000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(driver);

        ats.buyNiceTiming("005930", 12000);

        verify(driver).buy("005930", 4000, 3);
    }

    @Test
    void buyNiceTiming_does_not_buy_when_not_uptrend() {
        when(driver.getPrice("005930")).thenReturn(1000, 2000, 1500, 3000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(driver);

        ats.buyNiceTiming("005930", 12000);

        verify(driver, never()).buy(any(), anyInt(), anyInt());
    }

    @Test
    void sellNiceTiming_sells_all_when_3_consecutive_drops() {
        when(driver.getPrice("005930")).thenReturn(4000, 3000, 2000, 1000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(driver);

        ats.sellNiceTiming("005930", 10);

        verify(driver).sell("005930", 1000, 10);
    }

    @Test
    void sellNiceTiming_does_not_sell_when_not_downtrend() {
        when(driver.getPrice("005930")).thenReturn(4000, 3000, 3500, 1000);
        AutoTradingSystem ats = new AutoTradingSystem();
        ats.selectStockBroker(driver);

        ats.sellNiceTiming("005930", 10);

        verify(driver, never()).sell(any(), anyInt(), anyInt());
    }
}
