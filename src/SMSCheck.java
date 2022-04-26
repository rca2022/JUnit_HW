import model.SMS;

import java.util.HashMap;

public class SMSCheck {

    public static boolean checkRegister(HashMap<String, String> smsMap, SMS sms){
        boolean result = false;
        String regCheck = smsMap.get("Register Check");
        if(regCheck.length()==8) {
            if (regCheck.equalsIgnoreCase("Register")) {
                result = true;
            }
        }

        return result;
    }

}
