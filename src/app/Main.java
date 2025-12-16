package app;

import app.config.ApplicationFactory;
import app.dao.TaskDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationFactory applicationFactory = new ApplicationFactory();
        applicationFactory.runApplication(new TaskDAO());
    }
}