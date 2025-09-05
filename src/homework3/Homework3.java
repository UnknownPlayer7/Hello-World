package homework3;

import java.util.List;

public class Homework3 {
    public static void showHomework() {
        Barracks barracks = new Barracks();
        barracks.playDices();
        List<Musketeer> musketeers = barracks.getMusketeers();
        barracks.fence(musketeers.getFirst(),musketeers.getLast());
        barracks.polishRapiers(musketeers.get(1));
        barracks.polishRapiers(musketeers.get(2));
        barracks.drinkBeer(musketeers.get(1));
    }
}
