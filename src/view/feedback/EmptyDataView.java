package view.feedback;

import view.Colors;

public class EmptyDataView {

    public void render() {
        System.out.println(Colors.ANSI_RED + "Todos os campos tem que ser preenchidos." + Colors.ANSI_RESET);
    }
}
