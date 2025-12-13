package view.feedback;

import model.Task;
import view.Colors;

public class TitleTooLongView {
    public void render() {
        System.out.println(Colors.ANSI_YELLOW + "Seu título é muito longo. Por favor, use menos de 30 caracteres." + Colors.ANSI_RESET);
    }
}
