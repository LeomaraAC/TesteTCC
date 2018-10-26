package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.GrupoPage;
import pages.TiposAtendimentoPage;
import pages.UsuarioPage;
import until.DriverFactory;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UsuarioPage.class,
        TiposAtendimentoPage.class,
        GrupoPage.class
})
public class SuiteTest {
    @AfterClass
    public static void finalizaTudo() {
        DriverFactory.killDriver();
    }
}
