package pract_7.Facade;

public class TestMovieTheater {
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new VideoPlayer();
        AudioSystem audioSystem = new AudioSystem();
        Projector projector = new Projector();

        MovieTheater movieTheater = new MovieTheater(audioSystem, projector, videoPlayer);
        movieTheater.playMovie();
        movieTheater.stopMovie();
    }
}
