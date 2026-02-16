package com.datadog.sap.sap_java_backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*") 
public class SapController {

    @GetMapping("/sap/opu/odata/orders")
    public Map<String, Object> getOrders() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> d = new HashMap<>();
        d.put("results", Arrays.asList(
            new Order("1001", 500.0, "USD"),
            new Order("1002", 1200.5, "EUR")
        ));
        response.put("d", d);
        return response;
    }

    @GetMapping("/sap/opu/odata/error")
    public ResponseEntity<String> getError() {
        // Esto generará un error 500 que Datadog capturará automáticamente
        throw new RuntimeException("SAP RFC Connection Failed: System busy");
    }

    // Clase interna simple para los datos
    class Order {
        public String ID;
        public Double Amount;
        public String Currency;
        public Order(String id, Double amt, String curr) {
            this.ID = id; this.Amount = amt; this.Currency = curr;
        }
    }
}