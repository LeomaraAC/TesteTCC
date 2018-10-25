package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.ComparisonFailure;
import org.junit.Test;

import static objects.UsuarioObject.*;
import static until.Variables.*;

public class UsuarioPage extends Base {
    private Menu menu = new Menu();

    @Test
    public void testInserirUsuario() {
        try {
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
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }

    }

    @Test
    public void testInserirComProntuarioRepetido() {
        try {
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
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }

    }

    @Test
    public void testInserirComEmailRepetido() {
        try {
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
        } catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "Fail";
            getLog(ex);
        }
    }


    @Test
    public void testEditarUsuarioNomeEmail() {
        try {
            menu.acessarTelaUsuario();
            new Steps()
                    .filtrar(xpathBusca,prontuarioEditar,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,prontuarioEditar,xpathTabela,xpathByClickEditar)
                    .substituirValor(idNome, nomeEditadar)
                    .substituirValor(idEmail, emailEditadar)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathMensagemSucesso, msgSucessoEditar);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }

    }
    @Test
    public void testEditarUsuarioSemGrupo() {
        try {
            menu.acessarTelaUsuario();
            new Steps()
                    .filtrar(xpathBusca,prontuarioAuxiliar,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,prontuarioAuxiliar,xpathTabela,xpathByClickEditar)
                    .clicarCombo(xpathMultiselect, xpathCombo)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoGrupo, msgGrupoVazio);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }

    }

    @Test
    public void testEditarUsuarioVazio() {
        try {
            menu.acessarTelaUsuario();
            new Steps()
                    .filtrar(xpathBusca,prontuarioAuxiliar,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,prontuarioAuxiliar,xpathTabela,xpathByClickEditar)
                    .clicarBotao(idBtnLimpar)
                    .removerFocus(idProntuario)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoNome, msgNomeVazio)
                    .assertMSG(xpathErroCampoProntuario, msgProntuarioVazio)
                    .assertMSG(xpathErroCampoEmail, msgEmailVazio)
                    .assertMSG(xpathErroCampoGrupo, msgGrupoVazio);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }
    }

    @Test
    public void testEditarUsuarioSemProntuario() {
        try {
            menu.acessarTelaUsuario();
            new Steps()
                    .filtrar(xpathBusca,prontuarioEditar,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,prontuarioEditar,xpathTabela,xpathByClickEditar)
                    .substituirValor(idProntuario, "")
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoProntuario, msgProntuarioVazio);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }
    }
    @Test
    public void testExcluirUsuario() {
        try {
            menu.acessarTelaUsuario();
            new Steps()
                    .filtrar(xpathBusca,prontuarioExcluir, idBtnFiltrar)
                    .clicarCelula(idColunaExcluir,colunaBusca,prontuarioExcluir,xpathTabela,xpathByClickExcluir)
                    .assertMSG(xpathMensagemSucesso,msgSucessoExcluir);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            getLog(ex);
        } catch (Exception ex) {
            status = "FAIL";
            getLog(ex);
        }

    }
}
