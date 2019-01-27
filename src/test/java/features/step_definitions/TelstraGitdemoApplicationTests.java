package features.step_definitions;

import com.gitfetch.telstra_gitdemo.Utills.ErrorResourse;
import com.gitfetch.telstra_gitdemo.domain.GitData;

import com.gitfetch.telstra_gitdemo.domain.GitResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public abstract class TelstraGitdemoApplicationTests {

    private final String SERVER_URL = "http://localhost:7777";
    private final String GITDATA_ENDPOINT_WITH_INT = "/rest/v1/gitrepo/2";
    private final String GITDATA_ENDPOINT_WITH_STRING = "/rest/v1/gitrepo/gg";

    public RestTemplate restTemplate;

    @Autowired
    public TelstraGitdemoApplicationTests() {
        restTemplate = new RestTemplate();
    }

    public String gitEndPointWith_validData() {
        return SERVER_URL +  GITDATA_ENDPOINT_WITH_INT;
    }

    public String gitEndPointWith_invalidData() {
        return SERVER_URL +  GITDATA_ENDPOINT_WITH_STRING;
    }


    ResponseEntity<GitResult> getDataWithValidData() {

        return restTemplate.getForEntity(gitEndPointWith_validData(), GitResult.class);
    }

    ResponseEntity<ErrorResourse> getDataWithInvalidData() {
        return restTemplate.getForEntity(gitEndPointWith_invalidData(), ErrorResourse.class);
    }

}

