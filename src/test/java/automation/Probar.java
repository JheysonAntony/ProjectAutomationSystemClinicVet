package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;

public class Probar extends BaseTest {

    @Test
    public void sidebarButtonsTest() {

        driver.get("http://localhost:5173/");

        final var softAssert = new SoftAssert();

        //verifico si hay tres botones
        softAssert.assertEquals(driver.findElements(By.className("sidebar__btn")).size(), 3);
        softAssert.assertAll();
    }

    @Test
    public void resumenCardTest() {
        driver.get("http://localhost:5173/");

        final var softAssert = new SoftAssert();

        //verifico si hay tres card con esa clase
        softAssert.assertEquals(driver.findElements(By.className("resumen__card")).size(), 3);
        softAssert.assertAll();
    }

    @Test
    public void calendarChartTest() {
        driver.get("http://localhost:5173/");

        var secondButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(2)"));
        secondButton.click();

        final var softAssert = new SoftAssert();

        //verifico si hay dos inputs con esa clase
        Assert.assertEquals(driver.findElements(By.className("calendar__input--select")).size(), 2);
    }

    @Test
    public void calendarTdTest() {
        driver.get("http://localhost:5173/");

        var secondButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(2)"));
        secondButton.click();

        final var softAssert = new SoftAssert();

        //verifico si es visible
        softAssert.assertTrue(driver.findElement(By.className("calendar__table--today")).isDisplayed());
    }

    @Test
    public void calendarDivTest() {
        driver.get("http://localhost:5173/");

        var secondButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(2)"));
        secondButton.click();

        var todayClick = driver.findElement(By.xpath("//td[text()='4']"));
        todayClick.click();

        final var softAssert = new SoftAssert();

        //verifico si es visible
        softAssert.assertTrue(driver.findElement(By.className("calendar__table--today")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("calendar__appointment")).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void petButtonsTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var softAssert = new SoftAssert();

        //verifico si hay 4 botones (2 botones escondidos)
        softAssert.assertEquals(driver.findElements(By.className("btn")).size(), 4);
        softAssert.assertAll();
    }

    @Test
    public void petInputTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var softAssert = new SoftAssert();

        //verifico si hay tres botones
        softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        softAssert.assertAll();
    }

    @Test
    public void petSearchTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var inputSearch = By.className("pet__search--input");
        final var buttonSearch = By.xpath("//button[text()='Buscar']");

        driver.findElement(inputSearch).sendKeys("01");

        driver.findElement(buttonSearch).click();

        final var softAssert = new SoftAssert();

        //verifico si hay tres botones
        softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        softAssert.assertEquals(driver.findElements(By.className("pet__details--label")).size(), 8);
        softAssert.assertAll();
    }

    @Test
    public void petCreatTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        //final var inputSearch = By.className("pet__search--input");
        final var buttonCreate = By.xpath("//button[text()='Crear']");

        //driver.findElement(inputSearch).sendKeys("01");

        driver.findElement(buttonCreate).click();

        final var inputName = By.id("nombreMascota");
        final var inputDocument = By.id("numeroDocumento");
        final var inputSpecie = By.id("especie");
        final var inputGener = By.id("sexomacho");
        final var inputRaza = By.id("raza");
        final var inputDate = By.id("fechaNacimiento");
        final var inputPropietario = By.id("nombrePropietario");
        final var inputDocumentPropietario = By.id("documentoPropietario");
        final var buttonEnviar = By.xpath("//button[text()='Enviar']");

        driver.findElement(inputName).sendKeys("Mosca");
        driver.findElement(inputDocument).sendKeys("11");
        driver.findElement(inputSpecie).sendKeys("Perro");
        driver.findElement(inputGener).click();
        driver.findElement(inputRaza).sendKeys("Europeo");
        driver.findElement(inputDate).sendKeys("28052021");
        driver.findElement(inputPropietario).sendKeys("Jheyson");
        driver.findElement(inputDocumentPropietario).sendKeys("73106940");

        driver.findElement(buttonEnviar).click();

        final var messageOk = By.id("modalMessage");
        final var okElement = driver.findElement(messageOk);

        final var softAssert = new SoftAssert();

        softAssert.assertTrue(okElement.isDisplayed());
        //softAssert.assertEquals(okElement.getText(), "Mascota creada.");
        //softAssert.assertAll();

        //verifico si hay tres botones
        //softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        //softAssert.assertEquals(driver.findElements(By.className("pet__details--label")).size(), 8);
        //softAssert.assertAll();
    }

    @Test
    public void petEditTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var inputSearch = By.className("pet__search--input");
        //final var buttonCreate = By.xpath("//button[text()='Crear']");


        driver.findElement(inputSearch).sendKeys("10");

        final var buttonBuscar = By.xpath("//button[text()='Buscar']");
        //driver.findElement(buttonCreate).click();
        driver.findElement(buttonBuscar).click();

        final var buttonEditar = By.xpath("//button[text()='Editar']");

        driver.findElement(buttonEditar).click();

        final var inputName = By.id("nombreMascota");
        final var inputDocument = By.id("numeroDocumento");
        final var inputSpecie = By.id("especie");
        final var inputGener = By.id("sexomacho");
        final var inputRaza = By.id("raza");
        final var inputDate = By.id("fechaNacimiento");
        final var inputPropietario = By.id("nombrePropietario");
        final var inputDocumentPropietario = By.id("documentoPropietario");
        final var buttonEnviar = By.xpath("//button[text()='Enviar']");
        final var buttonGuardarCambios = By.xpath("(//button[@class='btn'])[3]");

        //driver.findElement(inputName).sendKeys("Mosca");
        //driver.findElement(inputDocument).sendKeys("09");
        driver.findElement(inputSpecie).sendKeys("Perruno");
        //driver.findElement(inputGener).click();
        //driver.findElement(inputRaza).sendKeys("Europeo");
        //driver.findElement(inputDate).sendKeys("28052021");
        //driver.findElement(inputPropietario).sendKeys("Jheyson");
        //driver.findElement(inputDocumentPropietario).sendKeys("73106940");

        driver.findElement(buttonGuardarCambios).click();

        final var messageOk = By.className("modal");
        final var okElement = driver.findElement(messageOk);

        final var softAssert = new SoftAssert();

        softAssert.assertTrue(okElement.isDisplayed());
        //softAssert.assertEquals(okElement.getText(), "Mascota creada.");
        //softAssert.assertAll();

        //verifico si hay tres botones
        //softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        //softAssert.assertEquals(driver.findElements(By.className("pet__details--label")).size(), 8);
        //softAssert.assertAll();
    }

    @Test
    public void petCreateHistoriaTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var inputSearch = By.className("pet__search--input");
        //final var buttonCreate = By.xpath("//button[text()='Crear']");


        driver.findElement(inputSearch).sendKeys("11");

        final var buttonBuscar = By.xpath("//button[text()='Buscar']");
        //driver.findElement(buttonCreate).click();
        driver.findElement(buttonBuscar).click();

        //final var buttonEditar = By.xpath("//button[text()='Editar']");

        //driver.findElement(buttonEditar).click();

        final var buttonCrearHist = By.xpath("//button[text()='Historia Clínica']");

        driver.findElement(buttonCrearHist).click();

        WebElement buttonNuevoRe = driver.findElements(By.cssSelector(".sidebar__btn")).get(3);

        (buttonNuevoRe).click();


        final var inputMotivo = By.id("motivo");
        final var inputDiagnostico = By.id("diagnostico");
        final var inputMedicamento = By.id("medicamento");
        final var inputGener = By.id("sexomacho");
        final var inputRaza = By.id("raza");
        final var inputDate = By.id("fechaNacimiento");
        final var inputPropietario = By.id("nombrePropietario");
        final var inputDocumentPropietario = By.id("documentoPropietario");
        final var buttonEnviar = By.xpath("//button[text()='Enviar']");
        final var buttonGuardarCambios = By.xpath("(//button[@class='btn'])[3]");

        driver.findElement(inputMotivo).sendKeys("Tiene fiebre");
        driver.findElement(inputDiagnostico).sendKeys("Esta mal");
        driver.findElement(inputMedicamento).sendKeys("Tomar pastillas");
        //driver.findElement(inputGener).click();
        //driver.findElement(inputRaza).sendKeys("Europeo");
        //driver.findElement(inputDate).sendKeys("28052021");
        //driver.findElement(inputPropietario).sendKeys("Jheyson");
        //driver.findElement(inputDocumentPropietario).sendKeys("73106940");

        //driver.findElement(buttonGuardarCambios).click();

        final var buttonRegis = By.xpath("(//button[@class='btn'])[4]");

        driver.findElement(buttonRegis).click();

        final var messageOk = By.className("modal");
        final var okElement = driver.findElement(messageOk);

        final var softAssert = new SoftAssert();

        softAssert.assertTrue(okElement.isDisplayed());
        //softAssert.assertEquals(okElement.getText(), "Mascota creada.");
        //softAssert.assertAll();

        //verifico si hay tres botones
        //softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        //softAssert.assertEquals(driver.findElements(By.className("pet__details--label")).size(), 8);
        //softAssert.assertAll();
    }

    @Test
    public void petDetailHistoriaTest() {

        driver.get("http://localhost:5173/");

        var threeButton = driver.findElement(By.cssSelector(".sidebar__btn:nth-of-type(3)"));
        threeButton.click();

        final var inputSearch = By.className("pet__search--input");
        //final var buttonCreate = By.xpath("//button[text()='Crear']");


        driver.findElement(inputSearch).sendKeys("06");

        final var buttonBuscar = By.xpath("//button[text()='Buscar']");
        //driver.findElement(buttonCreate).click();
        driver.findElement(buttonBuscar).click();

        //final var buttonEditar = By.xpath("//button[text()='Editar']");

        //driver.findElement(buttonEditar).click();

        final var buttonCrearHist = By.xpath("//button[text()='Historia Clínica']");

        driver.findElement(buttonCrearHist).click();

        //WebElement buttonNuevoRe = driver.findElements(By.cssSelector(".sidebar__btn")).get(3);

        //(buttonNuevoRe).click();

        final var verDetalle = By.className("historyclinic__item--show");

        driver.findElement(verDetalle).click();


        final var inputMotivo = By.id("motivo");
        final var inputDiagnostico = By.id("diagnostico");
        final var inputMedicamento = By.id("medicamento");
        final var inputGener = By.id("sexomacho");
        final var inputRaza = By.id("raza");
        final var inputDate = By.id("fechaNacimiento");
        final var inputPropietario = By.id("nombrePropietario");
        final var inputDocumentPropietario = By.id("documentoPropietario");
        final var buttonEnviar = By.xpath("//button[text()='Enviar']");
        final var buttonGuardarCambios = By.xpath("(//button[@class='btn'])[3]");

        //driver.findElement(inputMotivo).sendKeys("Tiene fiebre");
        //driver.findElement(inputDiagnostico).sendKeys("Esta mal");
        //driver.findElement(inputMedicamento).sendKeys("Tomar pastillas");
        //driver.findElement(inputGener).click();
        //driver.findElement(inputRaza).sendKeys("Europeo");
        //driver.findElement(inputDate).sendKeys("28052021");
        //driver.findElement(inputPropietario).sendKeys("Jheyson");
        //driver.findElement(inputDocumentPropietario).sendKeys("73106940");

        //driver.findElement(buttonGuardarCambios).click();

        //final var buttonRegis = By.xpath("(//button[@class='btn'])[4]");

        //driver.findElement(buttonRegis).click();

        final var messageOk = By.className("modal");
        final var okElement = driver.findElement(messageOk);

        WebElement elementoH3 = driver.findElement(By.xpath("//h3[text()='Detalle de registro clínico']"));

        final var softAssert = new SoftAssert();

        softAssert.assertTrue(elementoH3.isDisplayed(), "El elemento h3 'Detalle de registro clínico' no está visible en la página.");
        //softAssert.assertTrue(okElement.isDisplayed());
        //softAssert.assertEquals(okElement.getText(), "Mascota creada.");
        //softAssert.assertAll();

        //verifico si hay tres botones
        //softAssert.assertEquals(driver.findElements(By.className("pet__search--input")).size(), 1);
        //softAssert.assertEquals(driver.findElements(By.className("pet__details--label")).size(), 8);
        //softAssert.assertAll();
    }


}
