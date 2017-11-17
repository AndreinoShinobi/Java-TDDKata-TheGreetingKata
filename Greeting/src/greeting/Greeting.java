package greeting;

import java.util.ArrayList;
import java.util.Arrays;

public class Greeting {

    public static final String defaultGreet = "Hello my friend.";


    public static String greet(Object text){

        if(text == null) return defaultGreet;

        if(text.getClass() == String.class)
            return singleGreeting((String)text);

        if(text.getClass().isArray())
            return multipleGreetings((String[])text);

        return "Wrong input. Cannot Greet :(";
    }

    private static String singleGreeting(String name) {

        if (isAllUpperCase(name))
            return buildBaseUpperCaseGreet(name);

        return buildBaseGreet(name);
    }

    private static String multipleGreetings(String[] names) {

        if (arrayHasDownCaseNamesOnly(names)) {
            return buildDownCaseNamesGreetings(names);
        }

        return buildUpperAndDownCaseNamesGreetings(names);
    }

    private static String buildBaseGreet(String nameString) {
        return "Hello " + nameString + ".";
    }

    private static String buildBaseUpperCaseGreet(String nameString) {
        return "HELLO " + nameString + "!";
    }

    private static String buildDownCaseNamesGreetings(String[] names){
        if (names.length == 2) {
            String namesList = String.join(" and ", names);
            return buildBaseGreet(namesList);
        }

        return buildMoreOfTwoGreet(names);
    }

    private static String buildUpperAndDownCaseNamesGreetings(String[] names) {
        ArrayList<String> downCaseNames = new ArrayList<>();
        ArrayList<String> upperCaseNames = new ArrayList<>();

        for (String name : names) {
            if (!isAllUpperCase(name)) {
                downCaseNames.add(name);
            } else {
                upperCaseNames.add(name);
            }
        }

        String[] downCaseNamesArray = new String[downCaseNames.size()];
        downCaseNames.toArray(downCaseNamesArray);
        String[] upperCaseNamesArray = new String[upperCaseNames.size()];
        upperCaseNames.toArray(upperCaseNamesArray);


        String downCaseGreetings = (downCaseNames.size()>1) ? buildMoreOfTwoGreet(downCaseNamesArray) : buildBaseGreet(downCaseNamesArray[0]);
        String upperCaseGreetings = (upperCaseNames.size()>1) ? buildMoreOfTwoGreetUpperCase(upperCaseNamesArray) : buildBaseUpperCaseGreet(upperCaseNamesArray[0]);

        return downCaseGreetings + " AND " + upperCaseGreetings;
    }

    private static String buildMoreOfTwoGreet(String[] names) {

        int lastElementIndex = names.length - 1;
        String commonSeparatedNames = String.join(", ", Arrays.copyOf(names, lastElementIndex));
        String lastName = names[lastElementIndex];
        return buildBaseGreet(commonSeparatedNames + " and " + lastName);
    }

    private static String buildMoreOfTwoGreetUpperCase(String[] names) {

        int lastElementIndex = names.length - 1;
        String commonSeparatedNames = String.join(", ", Arrays.copyOf(names, lastElementIndex));
        String lastName = names[lastElementIndex];
        return buildBaseUpperCaseGreet(commonSeparatedNames + " AND " + lastName);
    }

    private static boolean arrayHasDownCaseNamesOnly(String[] names) {
        for (String name : names) {
            if (isAllUpperCase(name))
                return false;
        }
        return true;
    }

    private static boolean isAllUpperCase(String text) {
        return (text.toUpperCase().equals(text));
    }
}
