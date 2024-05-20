package hello.core.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    
    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl(null, null);
        orderService.createOrder(1L, "itemA", 10000);
    }
}