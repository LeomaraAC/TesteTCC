package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.Ignore;
import org.junit.Test;

import static objects.GrupoObject.*;
import static until.Variables.idBtnSalvar;
import static until.Variables.xpathMensagemErro;

public class GrupoPage extends Base {
    private Menu menu = new Menu();

    @Ignore
    public void testInserirGrupo() throws InterruptedException {
        menu.acessarTelaInserirGrupo();
        new Steps()
                .escrever(idNome, nome)
                .clicarBotao(idBtnAdicionar)
                .esperar(500)
                .escrever(idBuscaPermissoes, permissaoApagarUsuario)
                .clicarBotao(idBtnFecharModal);
    }

    @Test
    public void testInserirGrupoSemPermissoes() {
        menu.acessarTelaInserirGrupo();
        new Steps()
                .escrever(idNome, nome)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgSemPermissoes);
        status = "OK";
    }
}
