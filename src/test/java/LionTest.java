import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensWithoutParameter() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals("Получено некорректное значение", expected, actual);
        System.out.println("Ожидаемый результат равен: " + expected);
        System.out.println("Фактический результат равен: " + actual);
    }


    @Test
    public void getLionFoodPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals("Получен некорректный список", expected, actual);
        System.out.println("Ожидаемый результат равен: " + expected);
        System.out.println("Фактический результат равен: " + actual);
    }

    @Test
    public void getKittensChecksCalledOneTime() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodChecksCalledOneTimeWithTheParamForPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}