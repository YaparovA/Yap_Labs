public class MeowCounter<T extends Meowable> {
    private Meowable meowable;
    private int meowCount;

    public MeowCounter(T meowable) {
        this.meowable = meowable;
        this.meowCount = 0;
    }

    public void meow() {
        meowable.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
