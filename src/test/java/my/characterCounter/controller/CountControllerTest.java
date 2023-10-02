package my.characterCounter.controller;

import my.characterCounter.entity.CountDataRequest;
import my.characterCounter.entity.CountDataResponse;
import my.characterCounter.service.CountService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CountControllerTest {
    private final CountService countService = new CountService();
    private final CountController countController = new CountController(countService);
    private CountDataRequest countDataRequest;

    @Test
    public void testCountChars_EmptyRequest_ReturnsEmptyList() {
        countDataRequest = new CountDataRequest("");

        ResponseEntity<List<CountDataResponse>> response = countController.countChars(countDataRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).isEmpty());
    }

    @Test
    public void testCountChars_NonEmptyRequest_ReturnsCountDataResponseList() {
        countDataRequest = new CountDataRequest("aabbbc");
        List<CountDataResponse> expectedResult = new ArrayList<>();
        expectedResult.add(new CountDataResponse('b', 3));
        expectedResult.add(new CountDataResponse('a', 2));
        expectedResult.add(new CountDataResponse('c', 1));

        ResponseEntity<List<CountDataResponse>> response = countController.countChars(countDataRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }
}