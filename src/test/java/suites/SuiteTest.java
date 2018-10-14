package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.UsuarioPage;
import until.DriverFactory;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UsuarioPage.class
})
public class SuiteTest {
    @AfterClass
    public static void finalizaTudo() {
        DriverFactory.killDriver();
    }
}
