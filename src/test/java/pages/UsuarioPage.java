package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.Test;

import static objects.UsuarioObject.*;
import static until.Variables.*;

public class UsuarioPage extends Base {
    private Menu menu = new Menu();

    @Test
    public void testInserirUsuario() {
        menu.acessarTelaInserirUsuario();
        new Steps()
                .escrever(idProntuario, prontuario)
                .escrever(idNome, nome)
                .escrever(idEmail, email)
                .clicarCombo(xpathMultiselect, xpathCombo)
                .escrever(idSenha, senhaUser)
                .escrever(idSenhaConfirmation, senhaUser)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoIncluir);
        status = "OK";
    }

    @Test
    public void testInserirComProntuarioRepetido() {
        menu.acessarTelaInserirUsuario();
        new Steps()
                .escrever(idProntuario, prontuarioRepetido)
                .escrever(idNome, nome)
                .escrever(idEmail, email)
                .clicarCombo(xpathMultiselect, xpathCombo)
                .escrever(idSenha, senhaUser)
                .escrever(idSenhaConfirmation, senhaUser)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro,msgProntuarioRepetido);
        status = "OK";
    }

    @Test
    public void testInserirComEmailRepetido() {
        menu.acessarTelaInserirUsuario();
        new Steps()
                .escrever(idProntuario, prontuario)
                .escrever(idNome, nome)
                .escrever(idEmail, emailRepetido)
                .clicarCombo(xpathMultiselect, xpathCombo)
                .escrever(idSenha, senhaUser)
                .escrever(idSenhaConfirmation, senhaUser)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgEmailRepetido);
        status = "OK";
    }


    @Test
    public void testEditarUsuarioNomeEmail() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioEditar)
                .clicarCelula(idColunaEditar,colunaBusca,prontuarioEditar,xpathTabela,xpathByClickEditar, xpathPagination)
                .substituirValor(idNome, nomeEditadar)
                .substituirValor(idEmail, emailEditadar)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemSucesso, msgSucessoEditar);
        status = "OK";
    }
    @Test
    public void testEditarUsuarioSemGrupo() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioAuxiliar)
                .clicarCelula(idColunaEditar,colunaBusca,prontuarioAuxiliar,xpathTabela,xpathByClickEditar, xpathPagination)
                .clicarCombo(xpathMultiselect, xpathCombo)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoGrupo, msgGrupoVazio);
        status = "OK";
    }

    @Test
    public void testEditarUsuarioVazio() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioAuxiliar)
                .clicarCelula(idColunaEditar,colunaBusca,prontuarioAuxiliar,xpathTabela,xpathByClickEditar, xpathPagination)
                .clicarBotao(idBtnLimpar)
                .removerFocus(idProntuario)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoNome, msgNomeVazio)
                .assertMSG(xpathErroCampoProntuario, msgProntuarioVazio)
                .assertMSG(xpathErroCampoEmail, msgEmailVazio)
                .assertMSG(xpathErroCampoGrupo, msgGrupoVazio);
        status = "OK";
    }

    @Test
    public void testEditarUsuarioSemProntuario() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioEditar)
                .clicarCelula(idColunaEditar,colunaBusca,prontuarioEditar,xpathTabela,xpathByClickEditar, xpathPagination)
                .substituirValor(idProntuario, "")
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathErroCampoProntuario, msgProntuarioVazio);
        status = "OK";
    }

    @Test
    public void testEditarUsuarioProntuarioRepetido() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioEditar)
                .clicarCelula(idColunaEditar,colunaBusca,prontuarioEditar,xpathTabela,xpathByClickEditar, xpathPagination)
                .substituirValor(idProntuario, prontuarioRepetido)
                .clicarBotao(idBtnSalvar)
                .assertMSG(xpathMensagemErro, msgProntuarioRepetido);
        status = "OK";
    }

    @Test
    public void testExcluirUsuario() throws InterruptedException {
        menu.acessarTelaUsuario();
        new Steps()
                .filtrar(xpathBusca,prontuarioExcluir)
                .clicarCelula(idColunaExcluir,colunaBusca,prontuarioExcluir,xpathTabela,xpathByClickExcluir, xpathPagination)
                .assertMSG(xpathMensagemSucesso,msgSucessoExcluir);
        status = "OK";
    }
}
