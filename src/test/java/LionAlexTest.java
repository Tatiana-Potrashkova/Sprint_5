import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тесты класса LionAlex")
public class LionAlexTest {
    LionAlex lionAlex;

    @Mock
    Feline feline;

    @BeforeEach
    void beforeLionAlexTest() throws Exception{
        lionAlex = new LionAlex(feline);
    }

    @Test
    @DisplayName("Конструктор создает объект льва Алекса")
    void constructorLionAlex_CreateLionAlex() throws Exception {
        assertNotNull(new LionAlex(feline));
    }

    @Test
    @DisplayName("Алекс всегда самец")
    void alexIsAlwaysMale() {
        assertTrue(lionAlex.doesHaveMane());
    }

    @Test
    @DisplayName("метод getKittens() всегда возвращает 0")
    void getKittens_ReturnZero(){
        int actualKittensCount = lionAlex.getKittens();
        assertEquals(0, actualKittensCount);
    }

    @Test
    @DisplayName("метод getFriends() возвращает список друзей Алекса")
    void getFriends_ReturnListOfFriends(){
        List<String> expectedListOfFriends = List.of("Марти", "Глория", "Мелман");
        List<String> actualListOfFriends = lionAlex.getFriends();
        assertEquals(expectedListOfFriends, actualListOfFriends);
    }

    @Test
    @DisplayName("метод getPlaceOfLiving() возвращает место жительства Алекса")
    void getPlaceOfLiving_ReturnNewYorkZoo(){
        String expectedLivingPlace = "Нью-Йоркский зоопарк";
        String actualLivingPlace = lionAlex.getPlaceOfLiving();
        assertEquals(expectedLivingPlace,actualLivingPlace);
    }

}
