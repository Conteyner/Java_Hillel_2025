import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();
    private final AtomicInteger orderId = new AtomicInteger(1);
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order incoming = mapper.readValue(request.getReader(), Order.class);
        int id = orderId.getAndIncrement();
        double cost = incoming.getCost();

        Order order = new Order(id, incoming.getDate() != null ? incoming.getDate() : LocalDate.now(), cost, incoming.getProducts());

        orders.put(id, order);

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setContentType("application/json");
        mapper.writeValue(response.getOutputStream(), order);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String path = Optional.ofNullable(request.getPathInfo()).orElse("/");
        if ("/".equals(path)) {
            mapper.writeValue(response.getOutputStream(), orders.values());
        }

        int id = parseId(path, response);
        Order order = orders.get(id);
        if (order == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            mapper.writeValue(response.getOutputStream(), order);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = parseId(request.getPathInfo(), response);
        Order existing = orders.get(id);
        if (existing == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        Order incoming = mapper.readValue(request.getReader(), Order.class);
        incoming.setDate(LocalDate.now());
        incoming.setCost(existing.getCost());
        incoming.setProducts(existing.getProducts());
        orders.put(id, incoming);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        mapper.writeValue(response.getOutputStream(), incoming);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = parseId(request.getPathInfo(), response);
        Order removed = orders.remove(id);
        if (removed == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private int parseId(String pathInfo, HttpServletResponse response) throws IOException {
        if (pathInfo == null || pathInfo.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
        try {
            return Integer.parseInt(pathInfo.substring(1));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
    }

}
