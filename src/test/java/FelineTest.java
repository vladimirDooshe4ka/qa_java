import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();

    @Test(expected = java.lang.Exception.class)
    public void getFoodWithoutParameterThrowException() throws Exception {
        feline.getFood("");
    }

    @Test
    public void getFamilyReturnFelineFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensReturnsOneKitten() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParameter() {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void eatMeatReturnPredatorsFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }



    @Test
    public void getFoodWhenReturnPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    public void getFoodWhenReturnVeganFood() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), feline.getFood("Травоядное"));
    }
}