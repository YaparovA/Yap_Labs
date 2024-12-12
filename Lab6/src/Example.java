
@Validate(value =Human.class)
@Two(first = "Example", second = 42)
@Cache(value = {"Cache1", "Cache2"})
@ToString(value = ToStringValue.YES)
public class Example {

    private Object myField;


    @Invoke
    public void myMethod() {
        System.out.println("Метод myMethod вызван.");
    }
}
