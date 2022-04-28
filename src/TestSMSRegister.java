import org.junit.Test;

import static org.junit.Assert.*;

public class TestSMSRegister {
    @Test
    public void testCorrectRegister(){
        String smsMessage = "register";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertTrue(result);
    }

    @Test
    public void testFirstLetterCapitalRegister(){
        String smsMessage = "Register";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertTrue(result);
    }

    @Test
    public void testAllCapitalRegister(){
        String smsMessage = "REGISTER";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertTrue(result);
    }

    @Test
    public void testDifferentCasesRegister(){
        String smsMessage = "rEgiSteR";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertTrue(result);
    }

    @Test
    public void testIncorrectRegisterSpell(){
        String smsMessage = "regsiter";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertFalse(result);
    }

    @Test
    public void testExtraChars(){
        String smsMessage = "regi ster";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertFalse(result);
    }

    @Test
    public void testCheckWhiteSpaces(){
        String smsMessage = "   register   ";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertTrue(result);
    }

    @Test
    public void testNoRegister(){
        String smsMessage = "";
        boolean result = RegisterChecker.checkRegister(smsMessage);

        assertNotNull(smsMessage);
        assertFalse(result);
    }

}
