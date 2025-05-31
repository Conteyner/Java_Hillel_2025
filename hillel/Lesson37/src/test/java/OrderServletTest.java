import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServletTest {
    private OrderServlet orderServlet;
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        orderServlet = new OrderServlet();
        mapper = new ObjectMapper().findAndRegisterModules();
    }

    @Test
    void test() throws Exception {

    }
}
