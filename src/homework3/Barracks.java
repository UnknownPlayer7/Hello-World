package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Barracks {
    private ArrayList<Musketeer> musketeers = new ArrayList<>();
    private ArrayList<Rapier> arsenal = new ArrayList<>();

    Barracks() {
        addMusketeerIntoBarracks(new Musketeer("Д'Артаньян", Trait.CARDSHARP));
        addMusketeerIntoBarracks(new Musketeer("Атос", Trait.DRUNKARD));
        addMusketeerIntoBarracks(new Musketeer("Арамис", Trait.ACCOMPLISHED_DUELIST));
        addMusketeerIntoBarracks(new Musketeer("Партос", Trait.VAIN));
    }

    void addMusketeerIntoBarracks(Musketeer musketeer) {
        musketeers.add(musketeer);
        arsenal.add(musketeer.putOutRapier());
    }

    void playDices() {
        int roundCounter = 1;
        Musketeer[] competitors = musketeers.toArray(new Musketeer[0]);
        System.out.print("\nМушкетеры собрались за столом для игры в кости!");

        while (competitors.length > 1) {
            System.out.printf("\n%d РАУНД!", roundCounter);

            competitors = getWinner(competitors);
            roundCounter++;
        }
        System.out.printf("\n%s - абсолютный победитель игры в кости!", competitors[0].getName());
    }

    private Musketeer[] getWinner(Musketeer[] competitors) {

        Musketeer[][] table = writeScoreResultIntoTable(competitors);

        return writeWinnerList(table).toArray(new Musketeer[0]);
    }

    private Musketeer[][] writeScoreResultIntoTable(Musketeer[] competitors) {
        Musketeer[][] table = new Musketeer[19][competitors.length];
        for (Musketeer musketeer : competitors) {
            int score = musketeer.throughDices();

            for (int i = 0; i < table[score].length; i++) {
                if(table[score][i] == null) {
                    table[score][i] = musketeer;
                    break;
                }
            }
        }
      return table;
    }

    private ArrayList<Musketeer> writeWinnerList(Musketeer[][] results) {
        ArrayList<Musketeer> winnerList = new ArrayList<>();
        for (int score = results.length - 1; score > 0 ; score--) {
            if(results[score][0] != null) {
                for (int i = 0; i < results[score].length; i++) {
                    if (results[score][i] != null) {
                        winnerList.add(results[score][i]);
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return winnerList;
    }

    void polishRapiers(Musketeer musketeer) {
        System.out.println();

        if (musketeer.canEngage()) {
            musketeer.polish(arsenal);
        }
    }

    void fence(Musketeer firstMusketeer, Musketeer secondMusketeer) {
        System.out.printf("\n\n%s и %s готовяться к дуэли!", firstMusketeer.getName(),
                                                                secondMusketeer.getName());

        if (firstMusketeer.canEngage() && secondMusketeer.canEngage()) {
            firstMusketeer.takeRapierFromArsenal(arsenal);
            secondMusketeer.takeRapierFromArsenal(arsenal);

            while (!firstMusketeer.isWounded() && !secondMusketeer.isWounded()) {
                firstMusketeer.attack(secondMusketeer);
                secondMusketeer.attack(firstMusketeer);
            }

            arsenal.add(firstMusketeer.putOutRapier());
            arsenal.add(secondMusketeer.putOutRapier());
        }
    }

    void drinkBeer(Musketeer musketeer) {
        System.out.println();

        if (!musketeer.isSleep()) {
            musketeer.drinkBeer();
        }
    }

    List<Musketeer> getMusketeers() {
        return Collections.unmodifiableList(musketeers);
    }
}
