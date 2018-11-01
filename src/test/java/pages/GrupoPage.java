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

    @Test
    public void testDesmarcarNoModalPermissaoSelecionada() throws InterruptedException {
        menu.acessarTelaInserirGrupo();
        Steps steps = new Steps()
                .removerFocus(idNome)
                .clicarBotao(idBtnAdicionar)
                .esperar(500);
        for (String permissao : permissoesInserir) {
            steps.clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissao, xpathTabela, xpathCheckBox, xpathPagination);
        }
        steps
                .clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissoesInserir[indiceDesmarcar], xpathTabela, xpathCheckBox, xpathPagination)
                .clicarBotao(idBtnFecharModal);
        for (String permissao : permissoesInserir) {
            if (!permissao.equals(permissoesInserir[indiceDesmarcar]))
                steps.verificarElementoTabela(colunaBuscaPermissoes, permissao, xpathTabela, xpathPagination);
            else
                steps.verificarElementoTabela(colunaBuscaPermissoes, permissao, xpathTabela, xpathPagination, false);
        }
        status = "OK";
    }

    @Test
    public void testDesmarcarForaModalPermissaoSelecionada() throws InterruptedException {
        menu.acessarTelaInserirGrupo();
        Steps steps = new Steps()
                .removerFocus(idNome)
                .clicarBotao(idBtnAdicionar)
                .esperar(500);
        for (String permissao : permissoesInserir) {
            steps.clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissao, xpathTabela, xpathCheckBox, xpathPagination);
        }
        steps
                .clicarBotao(idBtnFecharModal)
                .clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissoesInserir[indiceDesmarcar], xpathTabela, xpathByClickExcluir, xpathPagination);
        for (String permissao : permissoesInserir) {
            if (!permissao.equals(permissoesInserir[indiceDesmarcar]))
                steps.verificarElementoTabela(colunaBuscaPermissoes, permissao, xpathTabela, xpathPagination);
            else
                steps.verificarElementoTabela(colunaBuscaPermissoes, permissao, xpathTabela, xpathPagination, false);
        }
        status = "OK";
    }

    @Test
    public void testInserirGrupo() throws InterruptedException {
        menu.acessarTelaInserirGrupo();
        Steps steps = new Steps()
                .escrever(idNome, nome)
                .removerFocus(idNome)
                .clicarBotao(idBtnAdicionar)
                .esperar(500);
        for (String permissao : permissoesInserir) {
            steps.clicarCelula(idColunaMarcarDesmarcar, colunaBuscaPermissoes, permissao, xpathTabela, xpathCheckBox, xpathPagination);
        }
        steps
                .clicarBotao(idBtnFecharModal)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoIncluir);
        status = "OK";
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

    @Test
    public void testInserirGrupoSemNome() {
        menu.acessarTelaInserirGrupo();
        new Steps()
                .removerFocus(idNome)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoNome, msgCampoObrigatorio);
        status = "OK";
    }

}
