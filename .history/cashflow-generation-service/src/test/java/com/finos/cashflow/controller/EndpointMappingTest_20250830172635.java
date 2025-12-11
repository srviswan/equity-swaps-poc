package com.finos.cashflow.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test to verify that our CashflowController has the expected endpoint mappings
 * without requiring full application context loading.
 */
public class EndpointMappingTest {

    @Test
    public void testEndpointMappingsExist() {
        Class<CashflowController> controllerClass = CashflowController.class;
        Method[] methods = controllerClass.getDeclaredMethods();
        
        List<String> endpoints = new ArrayList<>();
        
        // Extract all endpoint mappings
        for (Method method : methods) {
            String endpoint = getEndpointFromMethod(method);
            if (endpoint != null) {
                endpoints.add(endpoint);
            }
        }
        
        // Verify key endpoints are present
        assertTrue(endpoints.contains("GET /health"), "Health endpoint should be present");
        assertTrue(endpoints.contains("GET /health/detailed"), "Detailed health endpoint should be present");
        
        assertTrue(endpoints.contains("POST /cashflows/generate"), "Basic cashflow generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/interest"), "Interest generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/dividend"), "Dividend generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/performance"), "Performance generation should be present");
        
        assertTrue(endpoints.contains("POST /cashflows/generate/actor"), "Actor-based generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/reactive"), "Reactive generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/stream"), "Streaming generation should be present");
        
        assertTrue(endpoints.contains("GET /cashflows"), "Cashflow search should be present");
        assertTrue(endpoints.contains("GET /cashflows/{cashflowId}"), "Individual cashflow retrieval should be present");
        
        assertTrue(endpoints.contains("POST /cashflows/accruals/daily"), "Daily accrual generation should be present");
        assertTrue(endpoints.contains("GET /cashflows/accruals/daily/{contractId}"), "Daily accrual retrieval should be present");
        
        assertTrue(endpoints.contains("PATCH /cashflows/{cashflowId}/status"), "Status update should be present");
        assertTrue(endpoints.contains("POST /cashflows/{cashflowId}/defer"), "Deferral should be present");
        assertTrue(endpoints.contains("POST /cashflows/{cashflowId}/realize"), "Realization should be present");
        assertTrue(endpoints.contains("POST /cashflows/{cashflowId}/settle"), "Settlement should be present");
        
        assertTrue(endpoints.contains("POST /cashflows/generate/batch"), "Batch generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/interest/batch"), "Batch interest generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/generate/equity/batch"), "Batch equity generation should be present");
        assertTrue(endpoints.contains("POST /cashflows/batch/status-update"), "Batch status update should be present");
        
        assertTrue(endpoints.contains("GET /actors/status"), "Actor status should be present");
        assertTrue(endpoints.contains("GET /actors/count"), "Actor count should be present");
        assertTrue(endpoints.contains("GET /actors/names"), "Actor names should be present");
        
        assertTrue(endpoints.contains("GET /threads/partitions"), "Thread partitions should be present");
        
        // Print all found endpoints for verification
        System.out.println("Found " + endpoints.size() + " endpoints:");
        endpoints.forEach(System.out::println);
        
        // Verify we have a reasonable number of endpoints
        assertTrue(endpoints.size() >= 20, "Should have at least 20 endpoints implemented");
    }
    
    private String getEndpointFromMethod(Method method) {
        String httpMethod = null;
        String path = null;
        
        // Check for HTTP method annotations
        if (method.isAnnotationPresent(GetMapping.class)) {
            httpMethod = "GET";
            GetMapping mapping = method.getAnnotation(GetMapping.class);
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            httpMethod = "POST";
            PostMapping mapping = method.getAnnotation(PostMapping.class);
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            httpMethod = "PUT";
            PutMapping mapping = method.getAnnotation(PutMapping.class);
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        } else if (method.isAnnotationPresent(PatchMapping.class)) {
            httpMethod = "PATCH";
            PatchMapping mapping = method.getAnnotation(PatchMapping.class);
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            httpMethod = "DELETE";
            DeleteMapping mapping = method.getAnnotation(DeleteMapping.class);
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        } else if (method.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping mapping = method.getAnnotation(RequestMapping.class);
            RequestMethod[] methods = mapping.method();
            if (methods.length > 0) {
                httpMethod = methods[0].name();
            } else {
                httpMethod = "GET"; // Default
            }
            path = mapping.value().length > 0 ? mapping.value()[0] : mapping.path().length > 0 ? mapping.path()[0] : "";
        }
        
        if (httpMethod != null && path != null) {
            return httpMethod + " " + path;
        }
        
        return null;
    }
    
    @Test
    public void testControllerAnnotations() {
        Class<CashflowController> controllerClass = CashflowController.class;
        
        // Verify controller has proper annotations
        assertTrue(controllerClass.isAnnotationPresent(RestController.class), 
                  "Controller should have @RestController annotation");
        assertTrue(controllerClass.isAnnotationPresent(RequestMapping.class), 
                  "Controller should have @RequestMapping annotation");
        assertTrue(controllerClass.isAnnotationPresent(CrossOrigin.class), 
                  "Controller should have @CrossOrigin annotation");
    }
}
