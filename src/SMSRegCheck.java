public class SMSRegCheck {

    public static boolean checkRegister(String regCheck){
        boolean result = false;

        //trim() - this function removes white spaces before and after the message
        //example: " Register " -> "Register"
        regCheck = regCheck.trim();

        if(regCheck.length()==8) {

            if (regCheck.equalsIgnoreCase("Register")) {
                result = true;
            }
        }
        return result;
    }

}
