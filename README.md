# Project

Base for storing the URL

Posting the for authentication
----------------------------------------------------------------
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


ouptput::

-----------------------------------------------------------
{
    "message": "Otp sent",
    "user": {
        "authentication_via": "via_any"
    },
    "verify_device": true
}
------------------------------------------------------------
using parameterization passing credentials

testnG.xml
<suite name="Suite">
  <test thread-count="5" name="Test">
      <parameter name="email" value="deepakdpk333@gmail.com" />
      <parameter name="password" value="Qwerty@1234" />
    <classes>
      <class name="Test.TC001_Authentication"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
