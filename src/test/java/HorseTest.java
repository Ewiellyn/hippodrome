import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructor_HorseNameNotNull_ThrowsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 5));
        assertEquals("Name cannot be null.", exception.getMessage());
    }
}