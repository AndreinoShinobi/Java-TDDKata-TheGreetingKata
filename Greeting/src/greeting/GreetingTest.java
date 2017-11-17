package greeting;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GreetingTest {

    @Test
    public void baseGreet() {
        assertEquals("Hello Bob.", Greeting.greet("Bob"));
    }

    @Test
    public void shouldReturnDefaultGreetWhenNameIsNull() {
        assertEquals("Hello my friend.", Greeting.greet( null));
    }

    @Test
    public void shouldShoutWOnAllUpperCaseName() {
        assertEquals("HELLO BOB!", Greeting.greet("BOB"));
    }

    @Test
    public void shouldGreetTwoFriends() {
        assertEquals("Hello Jane and Mary.", Greeting.greet(new String[]{"Jane", "Mary"}));
    }

    @Test
    public void shouldGreetMultipleFriends() {
        assertEquals("Hello Dave, Jane, Max and Mary.", Greeting.greet(new String[]{"Dave", "Jane", "Max", "Mary"}));
    }

    @Test
    public void shouldGreetBothShoutAndQuiet() {
        assertEquals("Hello Dave, Max and Mary. AND HELLO JANE!", Greeting.greet(new String[]{"Dave", "JANE", "Max", "Mary"}));
        assertEquals("Hello Dave and Mary. AND HELLO JANE AND MAX!", Greeting.greet(new String[]{"Dave", "JANE", "MAX", "Mary"}));
        assertEquals("Hello Dave. AND HELLO JANE, MAX AND MARY!", Greeting.greet(new String[]{"Dave", "JANE", "MAX", "MARY"}));
    }
}