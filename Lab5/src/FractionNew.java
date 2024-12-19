import java.util.HashMap;
import java.util.Map;

/*public class FractionNew extends Fraction implements FractionOperations{
    private double cache;

    public FractionNew(int numerator, int denominator){
        super(numerator, denominator);
        this.cache = calculateDoubleValue() ;
    }

    private double calculateDoubleValue() {
        return (double) getNumerator() / getDenominator();
    }

    @Override
    public void setValue(int numerator, int denominator) {
        super.setDenominator(denominator);
        super.setNumerator(numerator);
        cache = calculateDoubleValue();
    }

    @Override
    public double getDoubleValue() {
        return cache;
    }
}
*/
public class FractionNew<T extends Number> {
    private Map<String, Fraction> fractionMap = new HashMap<>();
    private Map<String, Double> doubleValueCache = new HashMap<>();

    public FractionNew(){}

    public Fraction getFraction(T numerator, T denominator) {
        String key = numerator + "/" + denominator;
        if (!fractionMap.containsKey(key)) {
            Fraction fraction = new Fraction((int)numerator, (int)denominator);
            fractionMap.put(key, fraction);
            doubleValueCache.put(key, fraction.getDoubleValue());
        }
        return fractionMap.get(key);
    }
    public double getDoubleValue(T numerator, T denominator) {
        String key = numerator + "/" + denominator;
        if (doubleValueCache.containsKey(key)) {
            return doubleValueCache.get(key);
        } else {
            Fraction fraction = getFraction(numerator, denominator);
            return fraction.getDoubleValue();
        }
    }
}