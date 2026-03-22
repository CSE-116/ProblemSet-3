package problem;

public class Song extends Media {
    private int duration;
    private double playbackTime = 0.0;

    public Song(String title, int duration) {
        super(title);
        this.duration = duration;
    }

    @Override
    public void play() {
        this.isPlaying = true;
    }

    @Override
    public void pause() {
        this.isPlaying = false;
    }

    @Override
    public double getPlaybackTime() {
        return this.playbackTime;
    }

    // Note: This method is intentionally buggy. Write tests and use the debugger to find and fix the bugs
    public void advancePlaybacKTime(double seconds) {
        this.playbackTime += seconds;
    }

}
