package restApi;

import data.DataHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApi {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String paymentFormByDebitCard(DataHelper.CardInfo cardInfo) {
        String response = given() // -P:profile=test
                .spec(requestSpec)
                .body(cardInfo)
                .when()
                .post("/api/v1/pay")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
        return response;
    }

    public static String paymentFormByCreditCard(DataHelper.CardInfo cardInfo) {
        String response = given() // -P:profile=test
                .spec(requestSpec)
                .body(cardInfo)
                .when()
                .post("/api/v1/credit")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
        return response;
    }
}
