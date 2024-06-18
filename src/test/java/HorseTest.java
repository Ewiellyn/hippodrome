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
}