package ru.netology.rest;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldFirstTest() {

        given()
                .baseUri("https://postman-echo.com")
                .body("some data")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("some value"))
        ;
    }

    @Test
    void shouldSecondTest() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Добрового времени суток!")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Привет!"))
        ;
    }
}
