package my.characterCounter.service;

import my.characterCounter.entity.CountDataRequest;
import my.characterCounter.entity.CountDataResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountService {

    /**
     * Возвращает отсортированный список объектов, содержащий информацию о символе и количестве встреч.
     *
     * @param countDataRequest сущность, в которой находится строка для подсчета
     * @return список отсортированных объектов
     */
    public List<CountDataResponse> getResultDataCount(CountDataRequest countDataRequest) {
        Map<Character, Integer> frequencyMap = countCharacters(countDataRequest);

        List<CountDataResponse> resultSet = new ArrayList<>();
        frequencyMap.forEach((symbol, count) -> resultSet.add(new CountDataResponse(symbol, count)));
        Collections.sort(resultSet);

        return resultSet;
    }

    /**
     * Подсчитывает частоту встречи символов.
     *
     * @param countDataRequest сущность, в которой находится строка для подсчета
     * @return map, где ключ - символ, значение - количество вхождений
     */
    private Map<Character, Integer> countCharacters(CountDataRequest countDataRequest) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char oneChar : countDataRequest.getStringForCounting().toCharArray()) {
            frequencyMap.put(oneChar, frequencyMap.getOrDefault(oneChar, 0) + 1);
        }

        return frequencyMap;
    }
}
