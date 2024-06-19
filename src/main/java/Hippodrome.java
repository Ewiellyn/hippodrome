import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.*;



import static java.util.Objects.isNull;

public class Hippodrome {

    private final List<Horse> horses;
    private static final Logger hippodromelogger = LogManager.getLogger(Hippodrome.class.getName());

    public Hippodrome(List<Horse> horses) {
        if (isNull(horses)) {
            hippodromelogger.error("Horses list is null");
            throw new IllegalArgumentException("Horses cannot be null.");
        } else if (horses.isEmpty()) {
            hippodromelogger.error("Horses list is empty");
            throw new IllegalArgumentException("Horses cannot be empty.");
        }

        this.horses = horses;
        hippodromelogger.debug("створення Hippodrome, коней ["+horses.size()+"]");
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
    }
}
