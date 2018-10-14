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


    public void print(){
        String arquivo = testName.getMethodName();
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
        String formattedDate = df.format(date);

        File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String datesplit[] = formattedDate.split("-");
        String horas[] = datesplit[1].split("_");


        String path = "target\\screenshot\\"+className+"\\" + arquivo + "\\" + datesplit[0] + "\\" + status + "\\" + horas[0] + "h" + horas[1] + "m" + horas[2] + "s" + "\\";
        try {
            FileUtils.copyFile(screenshot, new File(path + arquivo + ".png"));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: *" + e.getMessage());
        }
        if (!status.equals("OK")) {
            try {
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path + "Error.log"), "utf-8"));
                writer.write(error);
                writer.close();
                System.out.println("Problemas na função " + arquivo + " da classe " + className);
            }catch (Exception ex) {
                System.out.println("Houveram problemas ao escrever o arquivo de log: " + ex.getMessage());
            }

        }
    }
}
