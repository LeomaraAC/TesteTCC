package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.ComparisonFailure;
import org.junit.Ignore;
import org.junit.Test;
import until.Variables;

import static objects.TiposAtendimentoObject.*;
import static until.Variables.*;

public class TiposAtendimentoPage extends Base {
    private Menu menu = new Menu();

    /*new Steps()
                    .escrever(idProntuario, prontuario)
                    .escrever(idNome, nome)
                    .escrever(idEmail, email)
                    .clicarCombo(xpathMultiselect, xpathCombo)
                    .escrever(idSenha, senhaUser)
                    .escrever(idSenhaConfirmation, senhaUser)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathMensagemSucesso, msgSucessoIncluir);*/
    @Test
    public void testInserirTipo() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricao)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathMensagemSucesso,msgSucessoIncluir);
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
    public void testInserirTipoRepetido() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricaoRepetida)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathMensagemErro, msgErroTipoRepetido);
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
    public void testInserirTipoVazio() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, "")
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoDescricao, msgErroTipoVazio);
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
    public void testInserirTipoCaracteresEspeciais() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricaoCaracteresEspeciais)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoDescricao, msgErroTipoCaracteresEspeciais);
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
    public void testInserirTipoNumero() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricaoNumeros)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoDescricao, msgErroTipoNumero);
            status = "OK";
        }catch (ComparisonFailure ex) {
            status = "NOK";
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "FAIL";
            error = ex.getMessage();
        }
    }

    @Ignore
    public void testInserirTipoMaximoCaracteres() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricaoMaximo)
                    .clicarBotao(idBtnSalvar);
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
    public void testInserirTipoMinimoCaracteres() {
        try {
            menu.acessarTelaInserirTipo();
            new Steps()
                    .escrever(idDescricao, descricaoMinimo)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathErroCampoDescricao, msgErroTipoMinimo);
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
