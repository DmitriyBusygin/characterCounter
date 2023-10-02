package my.characterCounter.controller;

import my.characterCounter.entity.CountDataRequest;
import my.characterCounter.entity.CountDataResponse;
import my.characterCounter.service.CountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountController {

    private final CountService countService;

    public CountController(CountService countService) {
        this.countService = countService;
    }

    @PostMapping("/count")
    public ResponseEntity<List<CountDataResponse>> countChars(@RequestBody CountDataRequest countDataRequest) {
        List<CountDataResponse> dataResponse = countService.getResultDataCount(countDataRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dataResponse);
    }
}
