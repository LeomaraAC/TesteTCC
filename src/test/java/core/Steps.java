package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;
import static until.DriverFactory.getDriver;
import static until.Wait.getWait;

import java.util.List;

public class Steps {

    /*** TEXT FIELD ***/
    public Steps limpar(By by) {
        WebElement element = getDriver().findElement(by);
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement botaoPagina = getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        element.clear();
        return this;

    }
    public Steps escrever(By by, String texto) {
        WebElement element = getDriver().findElement(by);
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement botaoPagina = getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        element.sendKeys(texto);
        return this;
    }

    public Steps escrever(String id_campo, String texto) {
        return escrever(By.id(id_campo), texto);
    }

    /*** BOTÃO ***/
    public Steps clicarBotao(By by) {
        WebElement element = getDriver().findElement(by);
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement botaoPagina = getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        element.click();
        return this;
    }
    public Steps clicarBotao(String id) {
        return clicarBotao(By.id(id));
    }

    /*** BOTÃO MENU ***/
    public Steps clicarBotaoMenu(String xpath){
        return clicarBotao(By.xpath(xpath));
    }

    /*** CAMBO BOX ***/
    public Steps clicarCombo(String xpath, String xpathSubmenu) {
        return clicarBotao(By.xpath(xpath))
                .clicarBotao(By.xpath(xpathSubmenu));
    }

    /*** TABELA ***/
    public Steps clicarCelula(int idColunaBotao, String colunaBusca, String valor, String xpathTabela, String xpathByClick) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTabela)));
        WebElement tabela = getDriver().findElement(By.xpath(xpathTabela));

        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        int idLinha = obterIndiceLinha(valor,tabela,idColuna);

        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));

        return this;
    }

    private int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinhas = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinhas = i + 1;
                break;
            }
        }
        return idLinhas;
    }

    /*** Asserts ***/
    public Steps assertMSG(String xpath, String mensagem) {
        WebElement mensagemSucesso = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(mensagemSucesso));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", mensagemSucesso);
        String verificarMensagemSucesso = mensagemSucesso.getText();
        assertEquals(mensagem, verificarMensagemSucesso);
        return this;
    }

}
