package your.company.project;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class HumanTest {
    @Test
    public void nameCanBeSet() {
        Human human = new Human();
        human.setName("Nova");

        assertThat(human.getName(), CoreMatchers.equalTo("Nova"));
    }
}
