import org.junit.Test;

import static org.junit.Assert.*;

public class TestSMSRegister {
    @Test
    public void testCorrectRegister(){
        String regCheck = "register";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void testFirstLetterCapitalRegister(){
        String regCheck = "Register";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void testAllCapitalRegister(){
        String regCheck = "REGISTER";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void testDifferentCasesRegister(){
        String regCheck = "rEgiSteR";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void testIncorrectRegisterSpell(){
        String regCheck = "regsiter";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertFalse(result);
    }

    @Test
    public void testExtraChars(){
        String regCheck = "regi ster";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertFalse(result);
    }

    @Test
    public void testCheckWhiteSpaces(){
        String regCheck = "   register   ";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void testNoRegister(){
        String regCheck = "";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertFalse(result);
    }

}
