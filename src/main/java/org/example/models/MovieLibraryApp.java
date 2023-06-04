package org.example.models;

import handlers.MenuHandlers;
import handlers.UserInputHandler;

public class MovieLibraryApp {
    public static void main(String[] args) {

        //ladowanie biblioteki filmow
        MovieLibrary movieLibrary = new MovieLibrary();
        movieLibrary.fillMovieList();

        while (true) {
            MenuHandlers.print();
            switch (UserInputHandler.getMenuOptionFromUser()) {
                case DISPLAY_ALL_INFORMATION_ABOUT_RANDOM_MOVIE:
                    movieLibrary.getRandomMovieInformation();
                    break;
                case DISPLAY_ALL_MOVIES_FOR_SELECTED_ACTOR:
                    movieLibrary.printActorRelatedMovies();
                    break;
                case QUIT:
                    System.out.println("\n Thank you, Bye");
                    System.exit(1);
            }
        }


    }




}
