package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");   
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    @Test
    public void hashCode_is_equal_for_equal_objects(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team();
        int result = t.hashCode();

        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }
    
    @Test
    public void equal_same_object_true() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equal_diff_class_false() {
        assertEquals(false, team.equals("not team"));
    }

    @Test
    public void equal_same_name_same_ppl_true() {
        Team t2 = new Team("test-team");
        assertEquals(true, team.equals(t2));
    }

    @Test
    public void equal_same_name_diff_ppl_false() {
        Team t2 = new Team("test-team");
        t2.addMember("sb xtra");
        assertEquals(false, team.equals(t2));
    }

    @Test
    public void equal_diff_name_same_ppl_false() {
        Team t2 = new Team("other-team");
        assertEquals(false, team.equals(t2));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
