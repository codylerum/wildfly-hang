package demo;

import java.time.Duration;

public class SimpleEvent {

  private final String id;
  private final Duration sleepDuration;

  public SimpleEvent(String id, Duration sleepDuration) {
    this.id = id;
    this.sleepDuration = sleepDuration;
  }

  public String getId() {
    return id;
  }

  public Duration getSleepDuration() {
    return sleepDuration;
  }
}
