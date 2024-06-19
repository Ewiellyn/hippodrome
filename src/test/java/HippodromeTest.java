import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void constructor_ArgumentNotNull_IllegalArgumentException(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void constructor_ArgumentListIsNotEmpty_IllegalArgumentException(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses_ReturnedListIsEqualToArgumentList_true(){
        List<Horse> horses = new ArrayList<>();
        for(int i =0;i<30;i++){
            horses.add(new Horse("Sam"+i,2+i,10+i));
        }
        assertEquals(horses,new Hippodrome(horses).getHorses());
    }

    @Test
    void move_MoveCalledForEachHorse_true(){
        List<Horse> horses = new ArrayList<>();
        for(int i =0;i<50;i++){
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for(Horse horse:horses){
            Mockito.verify(horse).move();
        }
    }

    @Test
    void getWinner_ReturnsObjectWithHighestDistance_true(){
        List<Horse> horses = new ArrayList<>();
        for(int i =0;i<30;i++){
            horses.add(new Horse("Sam"+i,2+i,i));
        }
        assertEquals(horses.get(29), new Hippodrome(horses).getWinner());
    }
}