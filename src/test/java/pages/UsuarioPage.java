package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.ComparisonFailure;
import org.junit.Test;
import until.Variables;

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
                    .assertMSG(xpathMensagemSucesso,msgSucesso);
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
}
