package tests

import common.Endpoints
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import static io.restassured.RestAssured.*


class Users extends Base {

    @Test(description = "Check /users is returning a 200 response", priority = 0)
    void checkUsers() {
        Response response = get(Endpoints.getEndpoint("users"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + "users-200.json"))
    }



}
