package app;

import app.config.ApplicationFactory;
import app.dao.TaskDAO;

public class Main {
    public static void main(String[] args)  {
        ApplicationFactory applicationFactory = new ApplicationFactory();
        applicationFactory.runApplication(new TaskDAO());
    }
}   