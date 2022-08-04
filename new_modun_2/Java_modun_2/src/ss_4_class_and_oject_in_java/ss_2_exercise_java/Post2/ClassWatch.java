package ss_4_class_and_oject_in_java.ss_2_exercise_java.Post2;

class StopWatch {
    private long startTime, endTime;

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long miliSecond = this.endTime - this.startTime;
        return miliSecond;
    }
}
