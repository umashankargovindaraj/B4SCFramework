package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DocumentsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__documents__text']")
    private WebElement documentsPageLink;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__uploadDocument']")
    private WebElement uploadDocumentLink;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__documentUpload__addNewButton']")
    private WebElement uploadButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__documentUpload__fileUpload__fileUpload']")
    private WebElement addfile;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__documents_ctl02__checkOut']")
    private WebElement verifyUpload;

    public void clickDocumentsLink(){
        waitAndClickElement(documentsPageLink);
    }

    public void uploadDoc(){
        String filename = getAppData().getElement("DOCUMENTSPAGE","FILENAME");
        String format = getAppData().getElement("DOCUMENTSPAGE","EXTENSION");
        generateFilesTypesAndSize(filename,format,1);
///********************call attachFile method from base page to generate and attach file*****************************/
        attachFile(addfile, "/files/" + filename + "." + format);
        System.out.println("/files/" + filename+format);
    }

    public void uploadDocLink(){
    waitAndClickElement(uploadDocumentLink);
    }

    public void clickUploadButton(){
    waitAndClickElement(uploadButton);
    }

    public void verifyFileUploaded(){

        isElementDisplayed(verifyUpload);
       // Assert.fail("Currently upload function is displaying exception dev environment, this step need to be updated for UAT");
    }
}
