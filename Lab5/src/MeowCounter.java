public class MeowCounter implements Meowable {
    private Meowable meowable;
    private int meowCount;

    public MeowCounter(Meowable meowable) {
        this.meowable = meowable;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        meowable.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
