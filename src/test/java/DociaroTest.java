import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.example.dociaro.DociaroSite.dashboard;
import static org.example.dociaro.pages.Dashboard.*;

public class DociaroTest extends TestBase {

    // test spring @PropertySource
    @Value("${domain}") private String domain;

    @Test
    void testButtons() {
        System.out.println("URL: " + domain);

        dashboard.open();

        allButton.click();
        forSignatureButton.click();
        appButton.click();
    }
}
