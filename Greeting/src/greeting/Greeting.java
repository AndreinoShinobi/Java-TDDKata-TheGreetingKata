package greeting;

public class Greeting {

    public static final String defaultGreet = "Hello, my friend.";

    public static String greet(String name){
        if(name==null)
            return defaultGreet;

        if(name.toUpperCase().equals(name))
            return "HELLO, " + name + "!";

        return buildBaseGreet(name);
    }

    public static String greet(String[] names){
        String namesList = String.join(" and ",names);
        return buildBaseGreet(namesList);
    }

    private static String buildBaseGreet(String nameString){
        return "Hello, " + nameString + ".";
    }
}
