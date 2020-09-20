import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.settings.WebSettings;
import org.example.dociaro.DociaroSite;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.StringUtils.toUpperSnakeCase;
import static org.example.dociaro.buttons.Buttons.Name;
import static org.example.dociaro.buttons.Buttons.getLocator;

@ContextConfiguration(classes = {AppConfig.class})
@ExtendWith(SpringExtension.class)
public class TestBase {

    @BeforeAll
    static void init() {
        WebSettings.SMART_SEARCH = el -> {
            UIElement element;
            String typeElement = el.base().typeName;
            switch (typeElement) {
                case "Button":
                    element = $(getLocator(Name.valueOf(toUpperSnakeCase(el.getName())).getText()), el.base().parent);
                    break;
                case "Other type":
                    element = $("other locator", el.base().parent);
                    break;
                default:
                    throw new IllegalStateException("Unexpected type of element: '" + typeElement + "' in SMART_SEARCH!");
            }
            element.setName(el.getName());
            return element.getWebElement();

            // Selenium like:
//            return WebDriverFactory.getDriver().findElement(By.xpath("//span[text()='" + Buttons.valueOf(toUpperSnakeCase(el.getName())).getText() + "']/parent::button"));
        };

        initSite(DociaroSite.class);
    }

    @AfterAll
    static void destroy() {
        WebDriver driver = WebDriverFactory.getDriver();
        if (driver != null) driver.quit();
    }
}
