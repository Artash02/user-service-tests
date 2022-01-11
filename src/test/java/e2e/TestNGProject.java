package e2e;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;;
import utils.APIClient;
import utils.APIException;
import utils.TestRails;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class TestNGProject {
    String PROJECT_ID = "15";
    APIClient client = null;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        client = new APIClient("https://estateguru.testrail.io/");
        client.setUser("hayk.harutyunyan@estateguru.co");
        client.setPassword("Aa123456");
        JSONObject c = (JSONObject) client.sendGet("get_suite/1");
        System.out.println(c.get("title"));
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = TestNGProject.class.getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId", ta.id());
        }
    }

    @TestRails(id = "1")
    @Test
    public void validLogin() {
        Assert.assertTrue(true);
    }

    @TestRails(id = "2")
    @Test
    public void invalidLogin() {
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx) throws IOException, APIException {
        Map data = new HashMap();
        if (result.isSuccess()) {
            data.put("status_id", 1);
        } else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
        }

        String caseId = (String) ctx.getAttribute("caseId");
        Long suiteId = (Long) ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/" + suiteId + "/" + caseId, data);

    }
}