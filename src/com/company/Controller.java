package com.company;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 22.06.2021.
 * Time: 19:21.
 */
public class Controller {

    private static final int filmsCount = 11;
    private final Random rating = new Random();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        List<Movie> filmList = new ArrayList<>();

        for (int i = 0; i < filmsCount; i++) {
            if (i % 2 == 0) {
                System.out.print("Insert cartoon title: ");
                filmList.add(new Cartoon(sc.nextLine(), rating.nextInt(11)));
            } else {
                System.out.print("Insert movie title: ");
                filmList.add(new Movie(sc.nextLine(), rating.nextInt(11)));
            }
        }
        Movie highestRatingMovie = null;
        for (Movie movie : filmList) {
            System.out.println("Title: " + movie.getTitle() + ", rating: " + movie.getRating());
            if (!(movie instanceof Cartoon) &&
                    (highestRatingMovie == null || movie.getRating() > highestRatingMovie.getRating())) {
                highestRatingMovie = movie;
            }
        }
        if (highestRatingMovie == null) {
            System.out.println();
            System.out.println("Something went wrong. There is not highest rating movie");
        } else {
            System.out.println();
            System.out.println("The Highest Rating Movie name is " + highestRatingMovie.getTitle() +
                    ", rating=" + highestRatingMovie.getRating());
        }
    }
}
