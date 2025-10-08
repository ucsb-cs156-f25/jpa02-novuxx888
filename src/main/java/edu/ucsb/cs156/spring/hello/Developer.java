package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Andrew X.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        // TODO: Change this to your github id
        return "novuxx888";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("f25-15");
        team.addMember("Guntash G.");
        team.addMember("Jayden L.");
        team.addMember("Tim N.");
        team.addMember("Kelvin F.");
        team.addMember("Akul S.");
        team.addMember("Andrew X.");
        return team;
    }
}
