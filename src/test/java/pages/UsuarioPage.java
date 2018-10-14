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
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "FAIL";
            error = ex.getMessage();
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
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "FAIL";
            error = ex.getMessage();
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
        } catch (
                ComparisonFailure ex) {
            status = "NOK";
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "Fail";
            error = ex.getMessage();
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
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "FAIL";
            error = ex.getMessage();
        }

    }
}
