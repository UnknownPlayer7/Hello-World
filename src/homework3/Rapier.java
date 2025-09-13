package homework3;

public class Rapier {
    private String owner;
    private boolean isClean;

    Rapier(String owner) {
        this.owner = owner;
        isClean = true;

    }

    void polish() {
        isClean = true;
    }

    void makeDirty() {
        isClean = false;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isClean() {
        return isClean;
    }

}
