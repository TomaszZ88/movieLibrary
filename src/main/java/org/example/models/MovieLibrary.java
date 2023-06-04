package org.example.models;

import handlers.RandomDataHandler;
import handlers.UserInputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLibrary {

    private static List<Movies> moviesLibrary;

    public void fillMovieList() {
        moviesLibrary = new ArrayList<>();
        Director riddleyScot = new Director("Riddley", "Scot");
        Director r_Scott = new Director("Ridley", "Scott");
        Director g_Verbinski = new Director("Gore", "Verbinski");
        Director q_Tarantino = new Director("Quentin", "Tarantino");
        Director p_Jackson = new Director("Peter", "Jackson");

        Actor r_Crowe = new Actor("Russel", "Crow");
        Actor o_Reed = new Actor("Oliver", "Reed");
        Actor d_Jacob = new Actor("Derek", "Jaceob");
        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");
        moviesLibrary.add(new Movies("Gladiator", riddleyScot, List.of(r_Crowe, o_Reed, j_Deep)));
        moviesLibrary.add(new Movies("Pirates of the Caribbean", g_Verbinski, List.of(o_Reed, j_Deep)));
        moviesLibrary.add(new Movies("Pulp Fiction", q_Tarantino, List.of(j_Travolta, u_Thurman)));
        moviesLibrary.add(new Movies("Hobbit - An Unexpected Jorney", r_Scott, List.of(k_Knightley, d_Jacob)));
        moviesLibrary.add(new Movies("Poranek Kojota", p_Jackson, List.of(r_Crowe, o_Bloom)));
        moviesLibrary.add(new Movies("Transformers", q_Tarantino, List.of(r_Crowe, d_Jacob)));
        moviesLibrary.add(new Movies("Top Gun", r_Scott, List.of(r_Crowe, t_Cruze)));
        moviesLibrary.add(new Movies("Desperado", r_Scott, List.of(r_Crowe, o_Bloom)));
        moviesLibrary.add(new Movies("Mission Impossible", p_Jackson, List.of(r_Crowe, t_Cruze)));
        moviesLibrary.add(new Movies("Forest Gump", g_Verbinski, List.of(o_Reed, h_Keitel)));
    }

    public static List<Movies> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void getRandomMovieInformation() {
        System.out.println(moviesLibrary.get(RandomDataHandler.getRandomMovieIndex()));
    }

    public void printActorRelatedMovies() {
        Actor actor = UserInputHandler.getActorFromUser();
        var actorMovieList = getActorMovieList(actor);
        if (actorMovieList.isEmpty()) {
            System.out.println("ACtor did not play in any movie from the library");
        } else {
            System.out.println("Actor " + actor + " have played in following movies: ");

            for (String movie : actorMovieList) {
                System.out.println("\n" + movie);
            }
        }
    }

    private List<String> getActorMovieList(Actor actorToFind) {
        Predicate<Movies> moviesPredicate = movie -> movie.getListOfActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
        actor.getLastName().equals(actorToFind.getLastName()));
return moviesLibrary.stream()
        .filter(moviesPredicate)
        .map(Movies::getTitle)
        .collect(Collectors.toList());
    }
}
