package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import restApi.RestApi;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {

    @Test
    public void shouldCheckStatusAPIByDebitCardWithValidData() {
        val validCardInfo = DataHelper.getValidCardInfo();
        final String response = RestApi.paymentFormByDebitCard(validCardInfo);
        assertTrue(response.contains("APPROVED"), "Is true when status is approved");
    }

    @Test
    public void shouldCheckStatusAPIByDebitCardWithInvalidData() {
        val invalidCardInfo = DataHelper.getInvalidCardInfo();
        final String response = RestApi.paymentFormByDebitCard(invalidCardInfo);
        assertTrue(response.contains("DECLINED"),"Is true when status is declined" );
    }

    @Test
    public void shouldCheckStatusAPIByCreditCardWithValidData() {
        val validCardInfo = DataHelper.getValidCardInfo();
        final String response = RestApi.paymentFormByCreditCard(validCardInfo);
        assertTrue(response.contains("APPROVED"), "Is true when status is approved");
    }

    @Test
    public void shouldCheckStatusAPIByCreditCardWithInvalidData() {
        val invalidCardInfo = DataHelper.getInvalidCardInfo();
        final String response = RestApi.paymentFormByCreditCard(invalidCardInfo);
        assertTrue(response.contains("DECLINED"), "Is true when status is declined");
    }
}
