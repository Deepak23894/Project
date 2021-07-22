package Test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Authentication implements Base
{
@Test
@Parameters ({"email", "password"})
public void authentication(String mail, String pass)
{
RestAssured.baseURI=Base.URI;
RequestSpecification httpRequest=RestAssured.given();
JSONObject jso= new JSONObject();
jso.put("email",mail);
jso.put("password", pass);
httpRequest.header("Content-Type", "application/json");
httpRequest.body(jso.toJSONString());
Response resp=httpRequest.post(authentic);
int statuscode=resp.getStatusCode();
String message=resp.asPrettyString();
System.out.println(message);
Assert.assertEquals(200, statuscode);


}
}
