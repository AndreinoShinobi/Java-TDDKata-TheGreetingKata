package greeting;


import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class GreetingTest{

    @Test
    public void baseGreet() {
        assertEquals("Hello, Bob.",Greeting.greet("Bob"));
    }

    @Test
    public void shouldReturnDefaultGreetWhenNameIsNull() {
        assertEquals("Hello, my friend.",Greeting.greet((String)null));
    }

    @Test
    public void shouldShoutWOnAllUpperCaseName() {
        assertEquals("HELLO, BOB!", Greeting.greet("BOB"));
    }

    @Test
    public void shouldGreetMultipleFriends() {
        assertEquals("Hello, Jane and Mary.", Greeting.greet(new String[]{"Jane", "Mary"}));
    }

}