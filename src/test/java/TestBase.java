import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.settings.WebSettings;
import org.example.dociaro.DociaroSite;
import org.example.dociaro.buttons.Buttons;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.StringUtils.toUpperSnakeCase;

@ContextConfiguration(classes = {AppConfig.class})
@ExtendWith(SpringExtension.class)
public class TestBase {

    @BeforeAll
    static void init() {
        WebSettings.SMART_SEARCH = el -> {
            UIElement element = $("//span[text()='" + Buttons.valueOf(toUpperSnakeCase(el.getName())).getText() + "']/parent::button", el.base().parent);
            element.setName(el.getName());
            return element.getWebElement();

            // Selenium like:
//            return WebDriverFactory.getDriver().findElement(By.xpath("//span[text()='" + Buttons.valueOf(toUpperSnakeCase(el.getName())).getText() + "']/parent::button"));
        };

        initSite(DociaroSite.class);
    }

    @AfterAll
    static void destroy() {
        killAllSeleniumDrivers();
    }
}
