import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructor_HorseNameNotNull_ThrowsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 5));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"","\t","\n"," "})
    void constructor_NoProhibitedCharactersInHorseName_ThrowsIllegalArgumentException(String argument){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(argument, 5));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void constructor_SpeedCantBeNegative_ThrowsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Samantha", -1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void constructor_DistanceCantBeNegative_ThrowsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Samantha", 1, -5));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName_MethodReturnsName_true(){
        Horse horse = new Horse("Sam",5);
        assertEquals("Sam",horse.getName());
    }

    @Test
    void getSpeed_MethodReturnsSpeed_true(){
        Horse horse = new Horse("Sam",5);
        assertEquals(5,horse.getSpeed());
    }

    @Test
    void getDistance_MethodReturnsDistance_true(){
        Horse horse = new Horse("Sam",5,10);
        assertEquals(10,horse.getDistance());
    }

    @Test
    void getDistance_MethodReturnsNullWhenConstructorWithTwoParameters_true(){
        Horse horse = new Horse("Sam",5);
        assertEquals(0,horse.getDistance());
    }
}