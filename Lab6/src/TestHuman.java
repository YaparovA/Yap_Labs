

public class TestHuman {

    public TestHuman(){}


    public static String IsAgeCorrect(Human human){
        if (human.getAge() > 1 && human.getAge() < 200)
            return "true";
        else
            return "Возраст не в диапазоне от 1 до 200";
    }
    public static String IsLenghtNameCorrect(Human human){
        if(human.getName().length() > 2 && human.getName().length() < 40)
            return "true";
        else
            return "Длина имени не в диапазоне от 2 до 40 символов";
    }
}
