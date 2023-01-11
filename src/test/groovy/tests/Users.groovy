package tests

import common.Endpoints
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import static io.restassured.RestAssured.*

class Users extends Base {

    @Test(description = "Verify that /users is returning a 200 response", priority = 0)
    void checkUsersReturns200() {
        Response response = get(Endpoints.getEndpoint("users"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + "users-200.json"))
    }

    @Test(description = "Verify that /users is returning the correct amount of items", priority = 1)
    void checkUsersReturnsCorrectAmountOfItems() {
        int expected = 10
        Response response = get(Endpoints.getEndpoint("users"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        ArrayList<String> allUsers = response.path("username")
        Assert.assertTrue(allUsers.size() == expected, "Wrong amount of users returned. Expected: ${expected} - Returned: ${allUsers.size()}")
    }

}
