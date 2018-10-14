package core;

import org.openqa.selenium.By;
import until.DriverFactory;
import until.Propriedades;
import until.Variables;

public class Login {
    private void acessarTelaInicial() {
        DriverFactory.getDriver().get(Propriedades.linkPagina);
    }

    public void logar() {
        acessarTelaInicial();
        new Steps()
                .escrever(By.xpath(Variables.campoLogin), Variables.login)
                .escrever(By.xpath(Variables.campoSenha), Variables.senha)
                .clicarBotao(By.xpath(Variables.btnEnviar));
    }

    public void logout() {
        new Steps()
                .clicarBotaoMenu(Variables.linkDropdown)
                .clicarBotaoMenu(Variables.linkSair);
    }
}
