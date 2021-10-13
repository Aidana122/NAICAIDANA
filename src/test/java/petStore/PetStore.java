package petStore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStore {

    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void init() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io").
                setBasePath("/v2").
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);

        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                log(LogDetail.ALL);

        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void check_elements_more_than_one() {

        List<Object> list = given(requestSpecification).
                when().
                queryParam("status", "available").
                get("/pet/findByStatus").
                then().
                assertThat().
                statusCode(200).
                extract().jsonPath().getList("");

        assertThat(list.size(),greaterThan(1));

        System.out.println(list.size());
    }

}
