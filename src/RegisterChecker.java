public class RegisterChecker {

    public static boolean checkRegister(String smsMessage){
        boolean result = false;

        //trim() - this function removes white spaces before and after the message
        //example: " Register " -> "Register"
        smsMessage = smsMessage.trim();

        if(smsMessage.length()==8) {

            if (smsMessage.equalsIgnoreCase("Register")) {
                result = true;
            }
        }
        return result;
    }

}
