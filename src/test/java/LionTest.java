import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тесты класса Lion")
public class LionTest {
    @Mock
    Feline feline;

    @Test
    @DisplayName("метод getKittens() вызывает getKittens() у Feline")
    void getKittens_CalledGetKittensFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    @DisplayName("метод getKittens() возвращает значение от Feline")
    void getKittens_ReturnValueFromFeline() throws Exception{
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion(feline, "Самец");
        int actualKittensCount = lion.getKittens();
        assertEquals(3, actualKittensCount);
    }

    @Test
    @DisplayName("метод doesHaveMane() возвращает true для самца")
    void doesHaveMane_ForMale_ReturnTrue() throws Exception{
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    @DisplayName("метод doesHaveMane() возвращает false для самки")
    void doesHaveMane_ForFemale_ReturnFalse() throws Exception{
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    @DisplayName("метод getFood() возвращает список еды для хищника")
    void getFood_ReturnedFoodForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(feline, "Самец");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Возвращается список еды для хищника");
    }

    @Test
    @DisplayName("метод getFood() вызывает getFood() у Feline с аргументом 'Хищник'")
    void getFood_CalledGetFoodFelineWithPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of());
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline, times(1)).getFood("Хищник");
    }
}
