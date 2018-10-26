package error;

import core.Login;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static until.DriverFactory.getDriver;
import static until.DriverFactory.killDriver;
import static until.Propriedades.FecharBrowser;

public class SimpleOnFailed extends TestWatcher {
    private String error = "";
    private String stackTrace = "";
    private String testName = "";
    private String className = "";
    private Boolean fail = false;

    @Override
    protected void failed(Throwable e, Description description) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        stackTrace = sw.toString();
        error = e.getMessage();
        testName = description.getMethodName();
        className = description.getClassName();
        fail = true;
        print();
    }

    public String getPath(String arquivo) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
        String formattedDate = df.format(date);

        String datesplit[] = formattedDate.split("-");
        String horas[] = datesplit[1].split("_");

        return "target\\screenshot\\" + className + "\\" + arquivo + "\\" + datesplit[0] + "\\" + horas[0] + "h" + horas[1] + "m" + horas[2] + "s" + "\\";
    }

    protected void print() {
        String arquivo = testName;
        String path = getPath(arquivo);
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(path + arquivo + ".png"));
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

        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar os arquivos para a pasta: *" + e.getMessage());
        }
    }

    @Override
    protected void finished(Description description) {
        Login loginPage = new Login();
        if (fail) {
            loginPage.logout();
            if (FecharBrowser)
                killDriver();
        }
    }
}
