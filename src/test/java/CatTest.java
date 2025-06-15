import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тесты класса Cat")
public class CatTest {
    Cat cat;

    @Mock
    Feline feline;

    @BeforeEach
    void beforeEach() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("метод getSound() всегда возвращает 'Мяу'")
    void getSound_ReturnMeow(){
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    @DisplayName("метод getFood() возвращает список еды для хищника")
    void getFood_ReturnedFoodForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    @DisplayName("метод getFood() вызывает eatMeat() у Feline")
    void getFood_CalledEatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of());
        cat.getFood();
        Mockito.verify(feline, times(1)).eatMeat();
    }
}
