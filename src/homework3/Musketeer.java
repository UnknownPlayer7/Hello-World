package homework3;

import java.util.ArrayList;

public class Musketeer {
    private final String name;
    private final Trait trait;
    private Rapier rapier;
    private boolean isWounded;
    private boolean isDrunk;
    private boolean isSleep;
    private int beerMugCount;

    Musketeer(String name, Trait trait) {
        this.name = name;
        this.trait = trait;
        rapier = new Rapier(name);
    }

    int throughDices() {
        int[] dices = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            dices[i] = getRandomDice();
            sum += dices[i];
        }

        System.out.printf("\n%s бросает кости...%d || %d || %d",name,dices[0],dices[1],dices[2]);
        return sum;
    }

    private int getRandomDice() {
        int dice;

        do {
            dice = trait == Trait.CARDSHARP ? (int)(Math.random() * 3 + 3) : (int)(Math.random() * 6 + 1);
        }while (dice < 1 || dice > 6);


        return dice;
    }

    void attack(Musketeer opponent) {
        int attackProbability =  trait == Trait.ACCOMPLISHED_DUELIST ? (int)(Math.random() * 50 + 50)
                                                                        : (int)(Math.random() * 70);
        if(attackProbability - opponent.parry() > 60) {
            opponent.getWounded();
            System.out.printf("\n%s исполняет виртуозный выпад. %s получил ранение.", name, opponent.name);
            System.out.println("\nДуэль оконьчена!");

            rapier.makeDirty();
            opponent.rapier.makeDirty();
        }
    }

    int parry() {

        return trait == Trait.ACCOMPLISHED_DUELIST ? (int)(Math.random() * 50 + 50)
                                                    : (int)(Math.random() * 70);
    }

    private void getWounded() {
        isWounded = true;
    }

    void drinkBeer() {
        recovery();
        isDrunk = true;
        beerMugCount++;
        if(beerMugCount > 3) {
            sleep();
            System.out.printf("\nОй-ёй! Кажется, %s сегодня выпил достаточно. Он идёт спать.", name);
        }
        if( !isSleep && trait == Trait.DRUNKARD) {
            drinkBeer();
        }
    }

    private void recovery() {
        isWounded = false;
        switch (beerMugCount) {
            case 0 -> System.out.printf("\n%s: \"Пивка для рывка!\" - пьет пиво", name);
            case 1 -> System.out.printf("\n%s: \"Еще по одной?\" - пьет пиво", name);
            case 2 -> System.out.printf("\n%s: \"Не дай себе засохнуть!\" - пьет пиво", name);
            case 3 -> System.out.printf("\n%s: \"Он меня не уважает?!\" - пьет пиво", name);
        }
    }

    private void sleep() {
        isSleep = true;
    }

    void polish(ArrayList<Rapier> arsenal) {
        if(trait == Trait.VAIN) {
            System.out.printf("\n%s: Да как Вы смеете мне приказывать! Что бы Я?! Да никогда!", name);
            return;
        } else if (!isWeaponSoiled(arsenal)) {
            System.out.printf("\n%s: В арсенале все шпаги в идеальном состоянии. Нечего чистить,командир.", name);
            return;
        }
        System.out.printf("\n%s открыл арсенал и осматривает шпаги...", name);

        for (Rapier rapier : arsenal) {
            if(!rapier.isClean()) {
                rapier.polish();
                System.out.printf("\n%s тщательно полирует шпагу %sа", name, rapier.getOwner());
            }
        }

    }

    private boolean isWeaponSoiled(ArrayList<Rapier> arsenal) {
        for (Rapier rapier : arsenal) {
            if(!rapier.isClean()) {
                return true;
            }
        }
        return false;
    }

    Rapier putOutRapier() {
        Rapier baredRapier = rapier;
        rapier = null;
        return baredRapier;
    }

    void takeRapierFromArsenal(ArrayList<Rapier> arsenal) {
        for (int i = 0; i < arsenal.size(); i++) {
            if(arsenal.get(i).getOwner().equals(name)) {
                this.rapier = arsenal.remove(i--);
            }

        }
    }

    boolean canEngage() {
        if (isWounded() || isSleep() || isDrunk()) {
            System.out.printf("\n%s не в состоянии что-либо сделать.", name);
            return false;
        }
        return true;
    }

    boolean isWounded() {
        if (isWounded) {
            System.out.printf("\n%s: Я ранен, командир. Мне бы чего-нибудь холодненького.", name);
            return true;
        }
        return false;
    }

    boolean isDrunk() {
        if (isDrunk) {
            System.out.printf("\n%s пьян. Вряд ли в таком виде от него будет прок.", name);
            return true;
        }
        return false;
    }

    boolean isSleep() {
        if (isSleep) {
            System.out.printf("\n%s:..Гррр-хррр...Хррр… пф-ф… хррр - храпит.", name);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
