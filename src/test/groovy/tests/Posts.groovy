package tests

import common.Endpoints
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import static io.restassured.RestAssured.*

class Posts extends Base {

    @Test(description = "Verify that /posts is returning a 200 response", priority = 0)
    void checkPostsReturns200() {
        Response response = get(Endpoints.getEndpoint("posts"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + "posts-200.json"))
    }

    @Test(description = "Verify that /posts is returning the correct amount of items", priority = 1)
    void checkPostsReturnsCorrectAmountOfItems() {
        int expected = 100
        Response response = get(Endpoints.getEndpoint("posts"))
        int responseCode = response.then().extract().statusCode()
        Assert.assertEquals(200, responseCode)
        ArrayList<String> allPosts = response.path("id")
        Assert.assertTrue(allPosts.size() == expected, "Wrong amount of posts returned. Expected: ${expected} - Returned: ${allPosts.size()}")
    }

}
