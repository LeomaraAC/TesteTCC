package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.Ignore;
import org.junit.Test;

import static objects.TiposAtendimentoObject.*;
import static until.Variables.*;

public class TiposAtendimentoPage extends Base {
    private Menu menu = new Menu();

    @Test
    public void testInserirTipo() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricao)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoIncluir);
        status = "OK";

    }

    @Test
    public void testInserirTipoRepetido() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricaoExistente)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgErroTipoRepetido);
        status = "OK";
    }

    @Test
    public void testInserirTipoVazio() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoVazio);
        status = "OK";
    }

    @Test
    public void testInserirTipoCaracteresEspeciais() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricaoCaracteresEspeciais)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoCaracteresEspeciais);
        status = "OK";
    }

    @Test
    public void testInserirTipoNumero() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricaoNumeros)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoNumero);
        status = "OK";
    }

    @Ignore
    public void testInserirTipoMaximoCaracteres() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricaoMaximo)
                .clicarBotao(idBtnSalvar);
        status = "OK";
    }

    @Test
    public void testInserirTipoMinimoCaracteres() {
        menu.acessarTelaInserirTipo();
        new Steps()
                .escrever(idDescricao, descricaoMinimo)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoMinimo);
        status = "OK";
    }

    @Test
    public void testEditarTipo() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoEditar)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoEditar, xpathTabela, xpathByClickEditar, xpathPagination)
                .limpar(idDescricao)
                .escrever(idDescricao, descricaoEditarAlterado)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoEditar);
        status = "OK";
    }

    @Test
    public void testEditarTipoVazio() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExistente)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoExistente, xpathTabela, xpathByClickEditar, xpathPagination)
                .clicarBotao(idBtnLimpar)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoVazio);
        status = "OK";
    }

    @Test
    public void testEditarTipoRepetido() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExistente)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoExistente, xpathTabela, xpathByClickEditar, xpathPagination)
                .limpar(idDescricao)
                .escrever(idDescricao, descricaoExistenteRepetido)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgErroTipoRepetido);
        status = "OK";
    }

    @Test
    public void testEditarTipoCaracteresEspeciais() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExistente)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoExistente, xpathTabela, xpathByClickEditar, xpathPagination)
                .limpar(idDescricao)
                .escrever(idDescricao, descricaoCaracteresEspeciais)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoCaracteresEspeciais);
        status = "OK";
    }

    @Test
    public void testEditarTipoNumero() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExistente)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoExistente, xpathTabela, xpathByClickEditar, xpathPagination)
                .limpar(idDescricao)
                .escrever(idDescricao, descricaoNumeros)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoNumero);
        status = "OK";
    }

    @Test
    public void testEditarTipoMinimoCaracteres() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExistente)
                .clicarCelula(idColunaEditar, colunaBusca, descricaoExistente, xpathTabela, xpathByClickEditar, xpathPagination)
                .limpar(idDescricao)
                .escrever(idDescricao, descricaoMinimo)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoDescricao, msgErroTipoMinimo);
        status = "OK";
    }

    @Test
    public void testExcluirTipo() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoExcluir)
                .clicarCelula(idColunaExcluir, colunaBusca, descricaoExcluir, xpathTabela, xpathByClickExcluir, xpathPagination)
                .assertMSG(xpathMensagemSucesso, msgSucessoExcluir);
        status = "OK";
    }

    @Test
    public void testListaTipoInexistente() throws InterruptedException {
        menu.acessarTelaAtendimento();
        new Steps()
                .filtrar(xpathBusca, descricaoInexistente)
                .esperar(600)
                .assertMSG(xpathMsgTabelaSemElemento, msgTabelaSemElemento);
        status = "OK";
    }
}
