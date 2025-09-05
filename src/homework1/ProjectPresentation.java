package homework1;

class ProjectPresentation {

    private static final String HOMEWORK_3_DESCRIPTION = """
                Object NAME: MUSKETEER
                GOAL: SHOW MUSKETEERS' ROUTINE
                    - Fencing;
                    - Gambling;
                    - Drinking beer;
                    - Keeping armory clean;
                PACKAGE CONSISTS OF:
                    1) Barracks - place where musketeers live;
                    2) Musketeers - action persons;
                    3) Rapier - soldiers' armory;
                    4) Trait - showing musketeer personality;
                DESCRIPTION:
                        Initially we have four musketeers: D'Artagnan, Athos, Aramis, and Porthos.
                    You may interact with them via a List returned by the Barracks' method \"getMusketeers\".
                    Also there is an opportunity to add your own musketeers by Barracks' method \"addMusketeerIntoBarracks\"
                        Some word about the Trait.
                    DRUNKARD - this fellow loves drinking and you wouldn't stop him if he started do it;
                    ACCOMPLISHED_DUELIST - give a bonus to fencing;
                    CARDSHARP - this guy plays a little better than others...why?
                    VAIN - never order him!
                """;

    static void show() {
        System.out.println(HOMEWORK_3_DESCRIPTION);
    }

}
