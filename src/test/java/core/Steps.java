package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static until.DriverFactory.getDriver;
import static until.Wait.getWait;

public class Steps {

    /*** TEXT FIELD ***/
    public Steps limpar(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement elementClear = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", elementClear);
        elementClear.clear();
        return this;

    }

    public Steps escrever(String xpath, String texto) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement elementText = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", elementText);
        elementText.sendKeys(texto);
        return this;
    }

    public Steps substituirValor(String xpath, String texto) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement elementText = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", elementText);
        elementText.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        elementText.sendKeys(texto);
        return this;
    }

    /*** BOTÃO ***/
    public Steps clicarBotao(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement botaoPagina = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        element.click();
        return this;
    }

    public Steps removerFocus(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement botaoPagina = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        element.sendKeys(Keys.TAB);
        return this;
    }

    public Steps clicarBotaoMenu(String xpath) {
        return clicarBotao(xpath);
    }

    public Steps clicarCombo(String xpath, String xpathSubmenu) {
        return clicarBotao(xpath)
                .clicarBotao(xpathSubmenu);
    }

    /*** TABELA ***/
    public Steps clicarCelula(int idColunaBotao, String colunaBusca, String valor, String xpathTabela, String xpathByClick, String xpathPagination) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTabela)));
        WebElement tabela = getDriver().findElement(By.xpath(xpathTabela));
        List<WebElement> pagination = getDriver().findElements(By.xpath(xpathPagination));
        esperar(200);

        int idColuna = obterIndiceColuna(colunaBusca, tabela);
        int idLinha = -1;
        /*** Se o id da coluna retornar -1 não precisa buscar a linha, visto que a coluna não existe. ***/
        if (idColuna > -1) {
            if (pagination.size() > 0) {
                for (int page = 0; page < pagination.size(); page++) {
                    if (idLinha == -1) {
                        getWait().until(ExpectedConditions.elementToBeClickable(pagination.get(page)));
                        pagination.get(page).click();
                        esperar(1000);
                    } else
                        break;
                    idLinha = obterIndiceLinha(valor, tabela, idColuna);
                }
            } else {
                idLinha = obterIndiceLinha(valor, tabela, idColuna);
            }
        }

        String xpath = xpathTabela + "//tr[" + idLinha + "]/td[" + idColunaBotao + "]" + xpathByClick;
        clicarBotao(xpath);
        return this;
    }

    private int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equalsIgnoreCase(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinhas = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equalsIgnoreCase(valor)) {
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

    public Steps verificarElementoTabela(String colunaBusca, String valor, String xpathTabela, String xpathPagination, boolean presente) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTabela)));
        WebElement tabela = getDriver().findElement(By.xpath(xpathTabela));
        List<WebElement> pagination = getDriver().findElements(By.xpath(xpathPagination));

        int idColuna = obterIndiceColuna(colunaBusca, tabela);
        int idLinha = -1;

        if (idColuna > -1) {
            if (pagination.size() > 0) {
                for (int page = 0; page < pagination.size(); page++) {
                    if (idLinha == -1) {
                        getWait().until(ExpectedConditions.elementToBeClickable(pagination.get(page)));
                        pagination.get(page).click();
                    } else
                        break;
                    idLinha = obterIndiceLinha(valor, tabela, idColuna);
                }
            } else {
                idLinha = obterIndiceLinha(valor, tabela, idColuna);
            }
        }

        String xpath = xpathTabela + "//tr[" + idLinha + "]/td[" + idColuna + "]";
        boolean find = getDriver().findElements(By.xpath(xpath)).size() <= 0;
        if (presente)
            Assert.assertFalse("Expected to find the " + valor + " element, but it was not found.", find);
        else
            Assert.assertFalse("Expected to not find the " + valor + " element, but it was found.", !find);
        return this;
    }

    public Steps verificarElementoTabela(String colunaBusca, String valor, String xpathTabela, String xpathPagination) throws InterruptedException {
        return verificarElementoTabela(colunaBusca, valor, xpathTabela, xpathPagination, true);
    }

    /*** Filtrar ***/
    public Steps filtrar(String xpathCampo, String valor) {
        return escrever(xpathCampo, valor)
                .removerFocus(xpathCampo);
    }

    public Steps esperar(int tempo) throws InterruptedException {
        Thread.sleep(tempo);
        return this;
    }

}
