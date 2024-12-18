public class FractionNew extends Fraction implements FractionOperations{
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
