package demo;

import java.time.Duration;

public class SimpleEvent {

  private final String id;
  private final Duration sleepDuration;
  private EventStyle style;

  public SimpleEvent(String id, EventStyle style, Duration sleepDuration) {
    this.id = id;
    this.sleepDuration = sleepDuration;
    this.style = style;
  }

  public String getId() {
    return id;
  }

  public Duration getSleepDuration() {
    return sleepDuration;
  }

  public EventStyle getStyle() {
    return style;
  }
}
