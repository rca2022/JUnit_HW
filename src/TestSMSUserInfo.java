import org.junit.Test;
import static org.junit.Assert.*;

public class TestSMSUserInfo {

    @Test
    public void testValidInfo(){
        String smsMessage = "Jan Dela Cruz, 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals("You are now registered!", result);
        assertNotEquals(
                "Your SMS message is invalid. " +
                "Please follow the message format.",
                result
        );
    }

    @Test
    public void testValidInfoWithSpaces(){
        String smsMessage = "    Jan Dela Cruz   ,   1997-10-11  ,    San Juan City   ";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals("You are now registered!", result);
        assertNotEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
    }

    @Test
    public void testValidInfoAllCaps(){
        String smsMessage = " JUAN DELA CRUZ, 1997-10-11, SAN JUAN CITY";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals("You are now registered!", result);
        assertNotEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
    }

    @Test
    public void testNoCommaFormat(){
        String smsMessage = "Juan Dela Cruz 1997-10-11 San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals(
                "Your SMS message is invalid. " +
                "Please follow the message format.",
                result
        );
        assertNotEquals("You are now registered!", result);
    }

    @Test
    public void testOneCommaFormat(){
        String smsMessage = "Juan Dela Cruz, 1997-10-11 San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
        assertNotEquals("You are now registered!", result);
    }

    @Test
    public void testExtraCommaFormat(){
        String smsMessage = "Juan, Dela Cruz, 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
        assertNotEquals("You are now registered!", result);
    }

    @Test
    public void testSeparatedByDashFormat(){
        String smsMessage = "Jan Dela Cruz - 1997-10-11 - San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
        assertNotEquals("You are now registered!", result);
    }

    @Test
    public void testFullNameWithNumbers(){
        String smsMessage = "Jan2 D31a Cru2, 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your full name without numbers and special characters.",
                result
        );
    }

    @Test
    public void testFullNameWithSpecialChars(){
        String smsMessage = "J@n del@ Cru$, 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your full name without numbers and special characters.",
                result
        );
    }

    @Test
    public void testFullNameWithoutSpace(){
        String smsMessage = "JanDelaCruz, 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your full name without numbers and special characters.",
                result
        );
    }

    @Test
    public void testNoFullName(){
        String smsMessage = " , 1997-10-11, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your full name without numbers and special characters.",
                result
        );
    }

    @Test
    public void testWrongDateFormat(){
        String smsMessage = "Jan Dela Cruz, 10-11-1997, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testDateWithLetters(){
        String smsMessage = "Jan Dela Cruz, 1997-May-10, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testDateWithSpecialChars(){
        String smsMessage = "Jan Dela Cruz, 1997/02/10, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    //Note: LocalDate class considers 1997-02-30 as 1997-02-28
    @Test
    public void testImpossibleDate(){
        String smsMessage = "Jan Dela Cruz, 1997-02-30, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertEquals("You are now registered!", result);
        assertNotEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testSingleDigitMonth(){
        String smsMessage = "Jan Dela Cruz, 1997-2-10, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testSingleDigitDay(){
        String smsMessage = "Jan Dela Cruz, 1997-02-4, San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testNoBirthdate(){
        String smsMessage = "Jan Dela Cruz, , San Juan City";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the date format (yyyy-MM-dd).",
                result
        );
    }

    @Test
    public void testAddressWithNumbers(){
        String smsMessage = "Jan Dela Cruz, 1997-10-11, S4n Ju4n C1ty";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your city address without numbers and special characters.",
                result
        );
    }

    @Test
    public void testAddressWithSpecialChars(){
        String smsMessage = "Jan Dela Cruz, 1997-10-11, S@n Ju@n Ci+y";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your city address without numbers and special characters.",
                result
        );
    }

    @Test
    public void testNoAddress(){
        String smsMessage = "Jan Dela Cruz, 1997-10-11, ";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your city address without numbers and special characters.",
                result
        );
    }

    @Test
    public void testInvalidInfo(){
        String smsMessage = "J@n2_D31a_Cruz, 10/11/1997, S@nJu@n C1+y";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please enter your full name without numbers and special characters. " +
                        "Please follow the date format (yyyy-MM-dd). " +
                        "Please enter your city address without numbers and special characters.",
                result
        );
    }

    @Test
    public void testBlankMessage(){
        String smsMessage = "";
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNotNull(result);
        assertNotEquals("You are now registered!", result);
        assertEquals(
                "Your SMS message is invalid. " +
                        "Please follow the message format.",
                result
        );
    }

    @Test
    public void testNullMessage(){
        String smsMessage = null;
        String result = UserInfoChecker.checkUserInfo(smsMessage);

        assertNull(result);
    }


}
