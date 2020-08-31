package bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DAOFactory {
    private MyFactory myFactory;
    public DAOFactory() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        try {
            Properties prop = new Properties();
// load the properties file
            prop.load(new FileInputStream(rootPath + "/config.properties"));
// get the property value
            String environment = prop.getProperty("environment");
            if (environment.equals("production")) {
                myFactory = new ProductionFactory();
            } else if (environment.equals("test")) {
                myFactory = new MockFactory();
            } else {
                System.out.println("environment property not set correctly");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFactory getFactoryInstance() {
        return myFactory;
    }
}
