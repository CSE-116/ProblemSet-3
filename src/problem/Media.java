package problem;

public abstract class Media {

    // isPlaying and isFinished are protected which allows them to be directly accessed in the child classes of Media
    protected boolean isPlaying = false;
    protected boolean isFinished = false;

    // title is private and must be accessed using getTitle() even in the child classes of Media
    // title is final meaning its value cannot be changed after it is set in the constructor
    private final String title;

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void advancePlaybackTime(double seconds) {

    }

    public abstract void play();

    public abstract void pause();

    public abstract double getPlaybackTime();

}
