import org.junit.jupiter.api.Test;

class TestHumanCases {

    @Test
    void isAgeCorrectSuccess() throws Exception {
        Human human = new Human("Вася", 10);
        Validator.validate(human);
    }

    @Test
    void isAgeCorrectFailed() throws Exception {
        Human human = new Human("Старый Вася", 1000);
        Validator.validate(human);
    }

    @Test
    void isLenghtNameCorrectSuccess() throws Exception {
        Human human = new Human("Ваcилий", 10);
        Validator.validate(human);
    }

    @Test
    void isLenghtNameCorrectShortFailed() throws Exception {
        Human human = new Human("Ва", 10);
        Validator.validate(human);
    }

    @Test
    void isLenghtNameCorrectLongFailed() throws Exception {
        Human human = new Human("Ваааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааасилий", 10);
        Validator.validate(human);
    }
}