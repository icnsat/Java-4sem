package sem_4.pract_7.facade;

public class MovieTheater {
    private AudioSystem audio;
    private Projector projector;
    private VideoPlayer video;

    public MovieTheater(AudioSystem audio, Projector projector, VideoPlayer video) {
        this.audio = audio;
        this.projector = projector;
        this.video = video;
    }

    public void playMovie(){
        System.out.println("Get ready to watch a movie!");
        video.turnOnVideoPlayer();
        projector.turnOnProjector();
        audio.turnOnAudio();
    }
    public void stopMovie(){
        System.out.println("\nMovie is stopped.");
        video.turnOffVideoPlayer();
        projector.turnOffProjector();
        audio.turnOffAudio();
    }
}
