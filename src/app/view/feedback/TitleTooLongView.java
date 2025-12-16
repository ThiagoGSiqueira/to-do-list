package app.view.feedback;

import app.view.Colors;

public class TitleTooLongView {
    public void render() {
        System.out.println(Colors.ANSI_YELLOW + "Seu título é muito longo. Por favor, use menos de 30 caracteres." + Colors.ANSI_RESET);
    }
}
