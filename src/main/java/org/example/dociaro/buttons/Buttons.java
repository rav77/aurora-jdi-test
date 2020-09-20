package org.example.dociaro.buttons;

public class Buttons {

    public enum Name {
        ALL_BUTTON("Все"),
        SIGN_BUTTON("На подпись"),
        APP_BUTTON("Заявки на продукт");

        private final String text;

        Name(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public static String getLocator(String text) {
        return "//span[text()='" + text + "']/parent::button";
    }
}
