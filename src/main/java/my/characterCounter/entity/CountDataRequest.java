package my.characterCounter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность, в которой нужно подсчитать символы.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountDataRequest {
    private String stringForCounting;
}
