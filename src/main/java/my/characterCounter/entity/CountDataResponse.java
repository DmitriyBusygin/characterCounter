package my.characterCounter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сущность, содержащая информацию о символе и частоте встречи.
 */
@Data
@AllArgsConstructor
public class CountDataResponse implements Comparable<CountDataResponse> {
    private char symbol;
    private int count;

    @Override
    public int compareTo(CountDataResponse anotherSymbol) {
        return Integer.compare(anotherSymbol.count, this.count);
    }
}
