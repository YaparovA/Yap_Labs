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
public class FractionNew {
    private Map<String, Fraction> fractionMap = new HashMap<>();
    private Map<String, Double> doubleValueCache = new HashMap<>(); // Кэш для вещественных значений

    public Fraction getFraction(int numerator, int denominator) {
        String key = numerator + "/" + denominator;
        if (!fractionMap.containsKey(key)) {
            Fraction fraction = new Fraction(numerator, denominator);
            fractionMap.put(key, fraction);
            doubleValueCache.put(key, fraction.getDoubleValue()); // Кэшируем вещественное значение
        }
        return fractionMap.get(key);
    }
    public double getDoubleValue(int numerator, int denominator) {
        String key = numerator + "/" + denominator;
        if (doubleValueCache.containsKey(key)) {
            return doubleValueCache.get(key); // Возвращаем кэшированное значение
        } else {
            Fraction fraction = getFraction(numerator, denominator);
            return fraction.getDoubleValue(); // Вычисляем и кэшируем
        }
    }
}