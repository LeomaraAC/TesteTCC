package pages;

import core.Base;
import core.Menu;
import core.Steps;
import org.junit.ComparisonFailure;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

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
                    .escrever(idDescricao, descricaoExistente)
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

    @Test
    public void testEditarTipo() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoEditar,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoEditar,xpathTabela,xpathByClickEditar)
                    .limpar(By.id(idDescricao))
                    .escrever(idDescricao, descricaoEditarAlterado)
                    .clicarBotao(idBtnSalvar)
                    .assertMSG(xpathMensagemSucesso, msgSucessoEditar);
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
    public void testEditarTipoVazio() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExistente,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoExistente,xpathTabela,xpathByClickEditar)
                    .clicarBotao(idBtnLimpar)
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
    public void testEditarTipoRepetido() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExistente,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoExistente,xpathTabela,xpathByClickEditar)
                    .limpar(By.id(idDescricao))
                    .escrever(idDescricao, descricaoExistenteRepetido)
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
    public void testEditarTipoCaracteresEspeciais() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExistente,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoExistente,xpathTabela,xpathByClickEditar)
                    .limpar(By.id(idDescricao))
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
    public void testEditarTipoNumero() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExistente,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoExistente,xpathTabela,xpathByClickEditar)
                    .limpar(By.id(idDescricao))
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

    @Test
    public void testEditarTipoMinimoCaracteres() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExistente,idBtnFiltrar)
                    .clicarCelula(idColunaEditar,colunaBusca,descricaoExistente,xpathTabela,xpathByClickEditar)
                    .limpar(By.id(idDescricao))
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

    @Test
    public void testExcluirTipo() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca,descricaoExcluir, idBtnFiltrar)
                    .clicarCelula(idColunaExcluir,colunaBusca,descricaoExcluir,xpathTabela,xpathByClickExcluir)
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

    @Test
    public void testListaTipoInexistente() {
        try {
            menu.acessarTelaAtendimento();
            new Steps()
                    .filtrar(xpathBusca, descricaoInexistente, idBtnFiltrar)
                    .esperar(600)
                    .assertMSG(xpathMsgTabelaSemElemento, msgTabelaSemElemento);
            status = "OK";
        } catch (ComparisonFailure ex) {
            status = "NOK";
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "FAIL";
            error = ex.getMessage();
        }
    }
}
