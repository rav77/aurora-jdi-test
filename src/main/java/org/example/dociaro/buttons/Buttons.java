package org.example.dociaro.buttons;

public enum Buttons {
    ALL_BUTTON("Все"),
    FOR_SIGNATURE_BUTTON("На подпись"),
    APP_BUTTON("Заявки на продукт");

    private final String text;

    Buttons(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
