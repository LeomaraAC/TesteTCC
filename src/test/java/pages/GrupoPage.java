package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.Ignore;
import org.junit.Test;

import static objects.GrupoObject.*;
import static until.Variables.*;

public class GrupoPage extends Base {
    private Menu menu = new Menu();

    @Test
    public void testSelecionarPermissoes() throws InterruptedException {
        menu.acessarTelaInserirGrupo();
        Steps steps = new Steps()
                .removerFocus(idNome)
                .clicarBotao(idBtnAdicionar)
                .esperar(500);
        for (String permissao : permissoesInserir) {
            steps.clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissao, xpathTabela, xpathCheckBox, xpathPagination);
        }
        steps
                .clicarBotao(idBtnFecharModal);
        for (String permissao : permissoesInserir) {
            steps.verificarElementoTabela(colunaBuscaPermissoes, permissao, xpathTabela, xpathPagination);
        }
        status = "OK";
    }
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
