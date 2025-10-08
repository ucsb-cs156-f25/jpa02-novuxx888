package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("test-team", team.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Case 1: same object
    @Test
    public void equals_same_object_returns_true() {
        assertTrue(team.equals(team));
    }

    // Case 2: null and different class
    @Test
    public void equals_null_returns_false() {
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_different_class_returns_false() {
        assertFalse(team.equals("not-a-team"));
        assertFalse(team.equals(42));
    }

    // Case 3 matrix: name.equals && members.equals

    // T, T (same name, same members)
    @Test
    public void equals_same_name_same_members_returns_true() {
        Team a = new Team("alpha");
        Team b = new Team("alpha");
        // If you have addMember(String), use a.addMember(...). Otherwise use getMembers().add(...)
        a.getMembers().add("ann");
        a.getMembers().add("bob");
        b.getMembers().add("ann");
        b.getMembers().add("bob");

        assertTrue(a.equals(b));
        assertTrue(b.equals(a)); // symmetry
    }

    // T, F (same name, different members)
    @Test
    public void equals_same_name_different_members_returns_false() {
        Team a = new Team("alpha");
        Team b = new Team("alpha");

        a.getMembers().add("ann");
        a.getMembers().add("bob");

        b.getMembers().add("ann");
        b.getMembers().add("bob");
        b.getMembers().add("cara"); // extra member

        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
    }

    // F, ? (different name, same members) — short-circuits to false
    @Test
    public void equals_different_name_same_members_returns_false() {
        Team a = new Team("alpha");
        Team b = new Team("beta");

        a.getMembers().add("ann");
        a.getMembers().add("bob");

        b.getMembers().add("ann");
        b.getMembers().add("bob");

        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
    }

    // Optional: F, F (different name, different members)
    @Test
    public void equals_different_name_different_members_returns_false() {
        Team a = new Team("alpha");
        Team b = new Team("beta");

        a.getMembers().add("ann");
        a.getMembers().add("bob");

        b.getMembers().add("xavier");

        assertFalse(a.equals(b));
    }

    @Test
    public void hashCode_test(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
public void hashCode_different_names_or_members_produce_different_hashes() {
    Team t1 = new Team("alpha");
    t1.addMember("bob");

    Team t2 = new Team("beta");
    t2.addMember("bob");

    Team t3 = new Team("alpha");
    t3.addMember("charlie");

    // Different name should yield different hash even if members same
    assertNotEquals(t1.hashCode(), t2.hashCode());

    // Different members should yield different hash even if name same
    assertNotEquals(t1.hashCode(), t3.hashCode());
}

@Test
public void hashCode_works_with_empty_members_list() {
    Team t1 = new Team("solo");
    Team t2 = new Team("solo");

    // No members added, same name and same members list
    assertEquals(t1.hashCode(), t2.hashCode());
}
@Test
public void hashCode_consistent_for_equal_objects() {
    Team t1 = new Team("gamma");
    Team t2 = new Team("gamma");
    t1.addMember("alice");
    t2.addMember("alice");

    // They are equal by equals()
    assertTrue(t1.equals(t2));

    // And their hashCodes must be identical
    assertEquals(t1.hashCode(), t2.hashCode());

    // Also ensure calling hashCode() repeatedly gives same result
    int first = t1.hashCode();
    assertEquals(first, t1.hashCode());
    assertEquals(first, t1.hashCode());
}


}
