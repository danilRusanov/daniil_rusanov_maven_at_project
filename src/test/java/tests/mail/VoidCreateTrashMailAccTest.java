package tests.mail;

import org.junit.Assert;
import org.junit.Test;
import pages.mail.VoidCreateTrashMailAcc;

public class VoidCreateTrashMailAccTest {

    private VoidCreateTrashMailAcc trashMailTest;

    @Test
    public void createTrashMailAccFormTest() {

        trashMailTest = new VoidCreateTrashMailAcc();
        trashMailTest.createTrashMailAccForm("daniiilrusa19281", "Qwerty!1", "rusanovdan@gmail.com");
        trashMailTest.registerButton();
        Assert.assertTrue(trashMailTest.registerBlockIsPresent());

    }

}
