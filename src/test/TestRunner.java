package test;

import app.config.ApplicationFactory;
import test.mock.TaskDAOMock;

public class TestRunner {
    public static void main(String[] args) {
        ApplicationFactory applicationFactory = new ApplicationFactory();
        applicationFactory.runApplication(new TaskDAOMock());
    }
}