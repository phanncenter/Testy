package com.sdl.selenium.web.button;

import com.sdl.bootstrap.button.RunExe;
import com.sdl.bootstrap.button.Upload;
import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadFile extends WebLocator implements Upload {
    private static final Logger LOGGER = Logger.getLogger(UploadFile.class);

    public UploadFile() {
        setClassName("UploadFile");
    }

    /**
     * @param container parent
     */
    public UploadFile(WebLocator container) {
        this();
        setContainer(container);
    }

    @Override
    public boolean upload(String... filePath) {
        browse(this);
        return RunExe.getInstance().upload(filePath);
    }

    private void browse(WebLocator el) {
        WebDriver driver = WebDriverConfig.getDriver();
        driver.switchTo().window(driver.getWindowHandle());
        el.focus();
        Actions builder = new Actions(driver);
        builder.moveToElement(el.currentElement).build().perform();
        builder.click().build().perform();
        driver.switchTo().defaultContent();
    }
}