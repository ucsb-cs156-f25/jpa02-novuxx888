package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Andrew X.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("novuxx888", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-15", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("GUNTASH SINGH G."),"Team should contain Guntash G.");
        assertTrue(t.getMembers().contains("ANDREW X."),"Team should contain Andrew X.");
        assertTrue(t.getMembers().contains("JAYDEN L."),"Team should contain Jayden L.");
        assertTrue(t.getMembers().contains("TIM VAN N."),"Team should contain Tim N.");
        assertTrue(t.getMembers().contains("KELVIN APOLLO F."),"Team should contain Kelvin F.");
        assertTrue(t.getMembers().contains("AKUL S."),"Team should contain Akul S.");
        
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
