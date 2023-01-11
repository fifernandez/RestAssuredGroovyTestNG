package tests

import common.Endpoints
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import static io.restassured.RestAssured.*

class Todos extends Base {

    @Test(description = "Verify that /todos is returning a 200 response", priority = 0)
    void checkTodosReturns200() {
        Response response = get(Endpoints.getEndpoint("todos"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + "todos-200.json"))
    }

    @Test(description = "Verify that /todos is returning the correct amount of items", priority = 1)
    void checkTodosReturnsCorrectAmountOfItems() {
        int expected = 200
        Response response = get(Endpoints.getEndpoint("todos"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        ArrayList<String> allTodos = response.path("id")
        Assert.assertTrue(allTodos.size() == expected, "Wrong amount of todos returned. Expected: ${expected} - Returned: ${allTodos.size()}")
    }

}
