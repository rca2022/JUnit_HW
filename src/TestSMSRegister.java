import org.junit.Test;
import model.SMS;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestSMSRegister {
    @Test
    public void testMapThreeEntries(){
        SMS sms = new SMS();
        HashMap<String, String> entry1 = new HashMap<>();
        entry1.put("Register Check", "register");

        HashMap<String, String> entry2 = new HashMap<>();
        entry2.put("Register Check", "Register");

        HashMap<String, String> entry3 = new HashMap<>();
        entry3.put("Register Check", "ReGiStEr");

        HashMap<String, String> entry4 = new HashMap<>();
        entry4.put("Register Check", "Regsiter");

        HashMap<String, String> entry5 = new HashMap<>();
        entry5.put("Register Check", "Reg Ister");

        assertTrue(SMSCheck.checkRegister(entry1, sms));
        assertTrue(SMSCheck.checkRegister(entry2, sms));
        assertTrue(SMSCheck.checkRegister(entry3, sms));
        assertFalse(SMSCheck.checkRegister(entry4, sms));
        assertFalse(SMSCheck.checkRegister(entry5, sms));
    }

}
