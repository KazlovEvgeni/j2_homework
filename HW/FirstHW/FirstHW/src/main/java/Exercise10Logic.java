public class Exercise10Logic {

    public String getRequest(String name, String number, String email) {
        String result;
        if (name.isEmpty() || number.isEmpty() || email.isEmpty()) {
            result = "One or more field(s) are empty";
            return result;
        }
        result = "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Email: " + email;
        return result;
    }
}
