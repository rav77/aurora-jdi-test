package org.example.dociaro.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;

@Url("/dashboard")
public class Dashboard extends WebPage {

    public static Button allButton, signButton, appButton;
}
