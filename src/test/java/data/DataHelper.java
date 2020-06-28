package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static CardInfo getValidCardInfo() {
        return new CardInfo("4444 4444 4444 4441", "21", "12", faker.name().fullName(), "564");
    }

    public static CardInfo getInvalidCardInfo() {
        return new CardInfo("4444 4444 4444 4442", "21", "12", faker.name().fullName(), "564");
    }

    public static CardInfo getCardInfoWithWrongNumber() {
        return new CardInfo("4444 4444", "21", "12", faker.name().fullName(), "564");
    }

    public static CardInfo getCardInfoWithWrongMonth() {
        return new CardInfo("4444 4444 4444 4441", "3", "4", faker.name().fullName(), "564");
    }

    public static CardInfo getCardInfoWithWrongCvc() {
        return new CardInfo("4444 4444 4444 4441", "21", "12", faker.name().fullName(), "56");
    }

    public static CardInfo getCardInfoWithWrongName() {
        return new CardInfo("4444 4444 4444 4441", "21", "12", "45453", "56");
    }

    public static CardInfo getCardInfoWithoutName() {
        return new CardInfo("4444 4444 4444 4441", "22", "12", " ", "56");
    }

    @Value
    public static class CardInfo {
        private String number, year, month, holder, cvc;
    }
}
