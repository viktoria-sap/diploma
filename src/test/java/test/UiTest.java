package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ProposalPage;
import sql.Sql;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UiTest {
    String wayOfPaymentPay = "pay";
    String wayOfPaymentByCredit = "credit";

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    public void shouldCheckIfSuccessWithValidInfoPaymentByDebitCard() throws SQLException {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByDebitCard();
        val validCardInfo = DataHelper.getValidCardInfo();
        cardData.cardInfoForSelectedWay(validCardInfo,  wayOfPaymentPay);
        cardData.checkIfPaymentSuccessful();
        val paymentId = Sql.getPaymentId();
        val statusForPaymentByDebitCard = Sql.getStatusForPaymentByDebitCard(paymentId);
        val paymentAmount = Sql.getPaymentAmount(paymentId);
        assertEquals("APPROVED", statusForPaymentByDebitCard);
        assertEquals("4500000", paymentAmount);

    }

    @Test
    public void shouldCheckIfSuccessWithValidInfoPaymentByCreditCard() throws SQLException {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val validCardInfo = DataHelper.getValidCardInfo();
        cardData.cardInfoForSelectedWay(validCardInfo, wayOfPaymentByCredit);
        cardData.checkIfPaymentSuccessful();
        val paymentId = Sql.getPaymentId();
        val statusForPaymentByCreditCard = Sql.getStatusForPaymentByCreditCard(paymentId);
        assertEquals("APPROVED", statusForPaymentByCreditCard);
    }

    @Test
    public void shouldCheckIfNotSuccessWithInvalidInfoPaymentByDebitCard() throws SQLException {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByDebitCard();
        val invalidCardInfo = DataHelper.getInvalidCardInfo();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData.checkIfPaymentNotSuccessful();  // баг
        val paymentId = Sql.getPaymentId();
        val statusForPaymentByDebitCard = Sql.getStatusForPaymentByDebitCard(paymentId);
        assertThat(statusForPaymentByDebitCard, equalTo("DECLINED"));
    }

    @Test
    public void shouldCheckIfNotSuccessWithInvalidInfoPaymentByCreditCard() throws SQLException {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val validCardInfo = DataHelper.getInvalidCardInfo();
        cardData.cardInfoForSelectedWay(validCardInfo, wayOfPaymentByCredit);
        cardData.checkIfPaymentNotSuccessful(); // баг
        val paymentId = Sql.getPaymentId();
        val statusForPaymentByCreditCard = Sql.getStatusForPaymentByCreditCard(paymentId);
        assertThat(statusForPaymentByCreditCard, equalTo("DECLINED"));
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongCardNumber() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongNumber();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongMonth() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongMonth();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongYearMoreThan30() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongMonth();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongYearFromOneNumber() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongMonth();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongCVC() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongCvc();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithWrongName() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithWrongName();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    public void shouldCheckIfNotSuccessWithoutName() {
        val proposalPage = new ProposalPage();
        val cardData = proposalPage.selectBuyByCreditCard();
        val invalidCardInfo = DataHelper.getCardInfoWithoutName();
        cardData.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentByCredit);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = proposalPage.selectBuyByDebitCard();
        cardData2.cardInfoForSelectedWay(invalidCardInfo, wayOfPaymentPay);
        cardData2.checkIfWrongFormatOfField();
    }
}
