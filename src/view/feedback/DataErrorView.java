package view.feedback;

import view.Colors;

public class DataErrorView {
    public void render() {
        System.out.println(Colors.ANSI_RED + "Houve um erro ao se conectar com o banco de dados. Por favor, aguarde até que seja reestabelecido." + Colors.ANSI_RESET);
    }
}
