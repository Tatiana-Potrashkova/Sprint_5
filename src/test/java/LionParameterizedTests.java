import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTests {
    @Mock
    Feline feline;

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    @DisplayName("Конструктор класса Lion корректно обрабатывает допустимые значения пола")
    void constuctorLion_ValidSex_CreateLion(String validSex) throws Exception{
        Lion lion = new Lion(feline, validSex);
        assertNotNull(lion);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Кобель", "Female", "111", "  ", "", "@#$%"})
    @DisplayName("Конструктор класса Lion выбрасывает исключение - некорректный пол животного")
    void constructorLion_InvalidSex_ThrowsException(String invalidSex){
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, invalidSex));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("Конструктор создает льва-самца с гривой или львицу-самку без гривы")
    void constructorLion_WithParamsCsv(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane, "Для пола '" + sex + "' ожидалось hasMane=" + expectedHasMane);
    }
}
