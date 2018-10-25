package core;

import org.openqa.selenium.By;
import until.DriverFactory;
import until.Propriedades;
import until.Variables;

import static until.Variables.*;

public class Login {
    private void acessarTelaInicial() {
        DriverFactory.getDriver().get(Propriedades.linkPagina);
    }

    public void logar() {
        acessarTelaInicial();
        new Steps()
                .escrever(campoLogin, login)
                .escrever(campoSenha, senha)
                .clicarBotao(btnEnviar);
    }

    public void logout() {
        new Steps()
                .clicarBotaoMenu(linkDropdown)
                .clicarBotaoMenu(linkSair);
    }
}
