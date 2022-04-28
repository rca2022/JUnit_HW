public class SMSRegCheck {

    public static boolean checkRegister(String regCheck){
        boolean result = false;

        if(regCheck.length()==8) {

            if (regCheck.equalsIgnoreCase("Register")) {
                result = true;
            }
        }
        return result;
    }

}
