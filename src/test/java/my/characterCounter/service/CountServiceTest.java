package my.characterCounter.service;

import my.characterCounter.entity.CountDataRequest;
import my.characterCounter.entity.CountDataResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountServiceTest {
    private final CountService countService = new CountService();
    private CountDataRequest countDataRequest;

    @Test
    public void testGetResultDataCount_EmptyRequest_ReturnsEmptyList() {
        countDataRequest = new CountDataRequest("");

        List<CountDataResponse> result = countService.getResultDataCount(countDataRequest);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetResultDataCount_NonEmptyRequest_CheckReturnSize() {
        countDataRequest = new CountDataRequest("aabbbc");

        List<CountDataResponse> result = countService.getResultDataCount(countDataRequest);

        assertEquals(3, result.size());
    }

    @Test
    public void testGetResultDataCount_NonEmptyRequest_CheckReturnSort() {
        countDataRequest = new CountDataRequest("aabbbc");

        List<CountDataResponse> result = countService.getResultDataCount(countDataRequest);

        assertEquals('b', result.get(0).getSymbol());
        assertEquals('a', result.get(1).getSymbol());
        assertEquals('c', result.get(2).getSymbol());
    }

    @Test
    public void testGetResultDataCount_NonEmptyRequest_CheckReturnValue() {
        countDataRequest = new CountDataRequest("aabbbc");

        List<CountDataResponse> result = countService.getResultDataCount(countDataRequest);

        assertEquals(3, result.get(0).getCount());
        assertEquals(2, result.get(1).getCount());
        assertEquals(1, result.get(2).getCount());
    }
}