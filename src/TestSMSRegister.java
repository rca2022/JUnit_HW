import org.junit.Test;

import static org.junit.Assert.*;

public class TestSMSRegister {
    @Test
    public void correctRegister(){
        String regCheck = "register";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void differentCasesRegister(){
        String regCheck = "Register";
        String regCheck2 = "REGISTER";
        String regCheck3 = "rEgiSteR";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertTrue(result);
    }

    @Test
    public void incorrectRegisterSpell(){
        String regCheck = "regsiter";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertFalse(result);
    }

    @Test
    public void extraChars(){
        String regCheck = "regi ster";
        boolean result = SMSRegCheck.checkRegister(regCheck);

        assertNotNull(regCheck);
        assertFalse(result);
    }


}
