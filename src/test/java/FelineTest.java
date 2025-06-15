import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тесты класса Feline")
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    @DisplayName("метод eatMeat() возвращает список еды для хищника")
    void eatMeat_ReturnedFoodForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    @DisplayName("метод eatMeat() вызывает getFood('Хищник')")
    void eatMeat_CalledGetFoodForPredator() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of());
        feline.eatMeat();
        Mockito.verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    @DisplayName("метод getFamily() всегда возвращает 'Кошачьи'")
    void getFamily_ReturnFeline() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    @DisplayName("метод getKittens(3) возвращает 3 котенка")
    void getKittens_WithParam3_Return3() {
        int actualKittensCount = feline.getKittens(3);
        assertEquals(3, actualKittensCount);
    }

    @Test
    @DisplayName("метод getKittens() без параметров возвращает 1 котенка")
    void getKittens_NoParam_Return1() {
        int actualKittensCount = feline.getKittens();
        assertEquals(1, actualKittensCount);
    }

}
