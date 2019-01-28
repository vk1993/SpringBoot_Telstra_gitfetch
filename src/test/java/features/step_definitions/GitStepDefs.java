package features.step_definitions;

        import com.gitfetch.telstra_gitdemo.domain.GitData;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import lombok.extern.slf4j.Slf4j;
        import org.hamcrest.Matchers;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;

        import javax.validation.constraints.AssertTrue;
        import java.io.IOException;

        import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
        import static java.util.Arrays.*;
        import static junit.framework.TestCase.assertTrue;
        import static junit.framework.TestCase.fail;
        import static org.hamcrest.CoreMatchers.instanceOf;
        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.core.IsEqual.equalTo;

@Slf4j
public class GitStepDefs extends TelstraGitdemoApplicationTests {

    private ResponseEntity<GitData[]> response;

    @When("^client calls /rest/v1/gitrepo/2$")
    public void clientCallsRestVGitrepo() {
        response = getDataWithValidData();
    }

    @Then("^the client receives response status code of (\\d+)$")
    public void theClientReceivesResponseStatusCodeOf(int arg0) {
        assertThat(response.getStatusCodeValue() , equalTo(arg0));
    }

    @And("^the body has size of (\\d+)$")
    public void theBodyHasSizeOf(int size)throws Throwable  {
        assertThat(response.getBody().length , equalTo(size));
    }


    @And("^the content type is (json|any)$")
    public void theContentTypeIs(String contentType) {
        if ("json".equalsIgnoreCase(contentType)) {
            assertTrue(response.getHeaders().getContentType().includes(MediaType.APPLICATION_JSON));
        }
    }

   @And("^the body has json path (.*) of type (numeric|object|string)$")
    public void theBodyHasJsonPath$OfTypeObject(String path, String type) throws IOException {
        switch (type) {
            case "object":
                assertThat(response.getBody(), instanceOf(Object.class));
                break;
            case "string":
                assertThat(
                        stream(response.getBody()).findFirst().get().getHtml_url(), instanceOf(String.class));
                break;
            case "numeric":
                assertThat(
                        response.getBody(), hasJsonPath(path, Matchers.instanceOf(Number.class)));
                break;
            default:
                fail("Not a recognised type.");
        }
 }
//
//    @Then("^the service uri returns status code (\\d+)$")
//    public void theServiceUriReturnsStatusCode(int statusCode) {
//        assertThat(getDataWithValidData().getStatusCode().value() , equalTo(statusCode));
//       //assertThat(getDataWithInvalidData().getStatusCode().value(),equalTo(statusCode));
//    }
//
//
////    @And("^the body has json path (.+) that is equal to (.+)$")
////    public void theBodyHasJsonPathThatIsEqualTo(String path, String value) {
////        assertThat(
////                getDataWithInvalidData().getBody().getUrl(),equalTo(value));
////    }
//
//
//    @When("^I make a request to service uri$")
//    public void iMakeARequestToServiceUri() {
//        assertThat(getDataWithValidData().getBody().getItems().size(),equalTo(2));
//    }
//
//    @And("null")
//    public void theBodyHasJsonPath$UrlThatIsEqualTo(String arg0) {
//    }
//
////    @When("^I make a request to fault service uri$")
////    public void iMakeARequestToFaultServiceUri() {
////        assertThat(getDataWithInvalidData().getBody().getErrorStaus(),equalTo("400 BAD_REQUEST"));
////    }
}
