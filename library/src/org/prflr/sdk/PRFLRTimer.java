package org.prflr.sdk;

/**
 * Created by bas on 01.02.17.
 */

public class PRFLRTimer {
    private Long startTime;
    private String timerName;

    public PRFLRTimer(String timerName) {
        this.timerName = timerName;
        startTime = System.nanoTime();
    }

    public void end() {
        end(null);
    }

    public void end(String info) {
        Long now = System.nanoTime();
        Long precision = (long) Math.pow(10, 3);
        final String thread = Long.toString(Thread.currentThread().getId());

        final Double diffTime = (double) Math.round((double) (now - startTime) / 1000000 * precision) / precision;

        PRFLRSender prflrSender = PRFLRSender.getInstance();
        if (prflrSender != null) prflrSender.send(timerName, diffTime, thread, info);
    }
}
