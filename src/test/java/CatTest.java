import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)

public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getCatSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals("Некорректный результат вызова метода", expected, actual);
        System.out.println("Ожидаемый результат: " + expected);
        System.out.println("Фактический результат: " + actual);
    }

    @Test
    public void eatMeatCalledOneTimes() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
