package core;

import error.SimpleOnFailed;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static until.DriverFactory.killDriver;
import static until.Propriedades.FecharBrowser;

public class Base {
    private Login loginPage = new Login();
    protected String status = "";

    @Rule
    public SimpleOnFailed failed = new SimpleOnFailed();


    @Before
    public void inicializa() {
        loginPage.logar();
    }

    @After
    public void finaliza() {

        if (status.equalsIgnoreCase("OK")) {
            if (FecharBrowser)
                killDriver();
            else
                loginPage.logout();
        }
    }

}
