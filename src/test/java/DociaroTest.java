import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.example.dociaro.DociaroSite.dashboard;
import static org.example.dociaro.pages.Dashboard.*;

public class DociaroTest extends TestBase {

    // test spring @PropertySource
    @Value("${domain}") private String domain;

    @Test
    void testButtons() throws InterruptedException {
        System.out.println("URL: " + domain);

        dashboard.open();

        appButton.click();
        signButton.click();
        allButton.click();

        Thread.sleep(1000);
    }
}
