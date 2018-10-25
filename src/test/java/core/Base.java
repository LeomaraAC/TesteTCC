package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import until.DriverFactory;
import until.Propriedades;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Base {
    private Login loginPage = new Login();



    @Rule
    public TestName testName = new TestName();
    protected String className = this.getClass().getName();
    protected String status = "";
    protected String error = "";
    private String stackTrace = "";

    @Before
    public void inicializa () {
        loginPage.logar();
    }

    @After
    public void finaliza(){
        print();
        loginPage.logout();

        if (Propriedades.FecharBrowser)
            DriverFactory.killDriver();
    }


    private String getPath(String arquivo) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
        String formattedDate = df.format(date);

        String datesplit[] = formattedDate.split("-");
        String horas[] = datesplit[1].split("_");


        return "target\\screenshot\\"+className+"\\" + arquivo + "\\" + datesplit[0] + "\\" + status + "\\" + horas[0] + "h" + horas[1] + "m" + horas[2] + "s" + "\\";
    }

    protected void print(){
        String arquivo = testName.getMethodName();
        String path = getPath(arquivo);
        File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(path + arquivo + ".png"));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: *" + e.getMessage());
        }
        if (!status.equals("OK")) {
            try {
                Writer logError = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path + "Error.log"), "utf-8"));
                logError.write(error);
                logError.close();

                Writer logStackTrace = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path + "logStackTrace.log"), "utf-8"));
                logStackTrace.write(stackTrace);
                logStackTrace.close();

                System.out.println("Problemas na função " + arquivo + " da classe " + className);
            }catch (Exception ex) {
                System.out.println("Houveram problemas ao escrever o arquivo de log: " + ex.getMessage());
            }

        }
    }
}
