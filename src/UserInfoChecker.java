import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserInfoChecker {

    public static String checkUserInfo(String smsMessage){
        String[] fields;
        String result = "Your input is invalid.";

        try {
            fields = smsMessage.split(",");

        } catch (NullPointerException exception){
            return null;
        }

        if (fields.length == 3){
            String fullName = fields[0].trim();
            String birthDate = fields[1].trim();
            String address = fields[2].trim();

            if (checkFullName(fullName)
                    && checkBirthDate(birthDate)
                    && checkAddress(address)){

                result = "You are now registered!";

            } else {
                if (!checkFullName(fullName)){
                    result += " Please enter your full name without numbers and special characters.";
                }

                if (!checkBirthDate(birthDate)){
                    result += " Please follow the date format (yyyy-MM-dd).";
                }

                if (!checkAddress(address)){
                    result += " Please enter your city address without numbers and special characters.";
                }
            }

        } else {
            result += " Please follow the message format.";
        }

        return result;
    }

    private static boolean checkFullName(String fullName) {
        return fullName.contains(" ")
                && !fullName.matches(".*[0-9].*")
                && !hasSpecialChars(fullName);
    }

    private static boolean checkAddress(String address) {
        return !address.matches(".*[0-9].*")
                && !hasSpecialChars(address);
    }

    private static boolean checkBirthDate(String birthDate) {
        return isParsable(birthDate)
                && !birthDate.matches("[a-zA-Z]")
                && !hasSpecialChars(birthDate);
    }

    private static boolean isParsable(String birthDate) {
        try {
            LocalDate.parse(
                    birthDate,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

        } catch (DateTimeParseException exception){
            return false;
        }

        return true;
    }

    private static boolean hasSpecialChars(String stringInput) {
        String specialCharactersString = "!@#$%&*()'+/:;<=>?[]^_`{|}";
        for (int i = 0; i < stringInput.length(); i++){
            char charInString = stringInput.charAt(i);

            if (specialCharactersString
                    .contains(Character.toString(charInString))){
                return true;
            }
        }
        return false;
    }

}
