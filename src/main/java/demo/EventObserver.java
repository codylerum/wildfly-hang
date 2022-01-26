package demo;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

@RequestScoped
public class EventObserver {

  private static final Logger log = Logger.getLogger("EventObserver");

  public void observe(@Observes SimpleEvent simpleEvent) throws InterruptedException {
    try {
      log.info(String.format("Observing Synchronously %s and sleeping for %s ms", simpleEvent.getId(), simpleEvent.getSleepDuration().toMillis()));
      Thread.sleep(simpleEvent.getSleepDuration().toMillis());
      log.info(String.format("Finished %s", simpleEvent.getId()));
    } catch (InterruptedException e) {
      log.info("InterruptedException was thrown");
      throw e;
    }
  }

  public void observeAsync(@ObservesAsync SimpleEvent simpleEvent) throws InterruptedException {
    try {
      log.info(String.format("Observing Asynchronously  %s and sleeping for %s ms", simpleEvent.getId(), simpleEvent.getSleepDuration().toMillis()));
      Thread.sleep(simpleEvent.getSleepDuration().toMillis());
      log.info(String.format("Finished %s", simpleEvent.getId()));
    } catch (InterruptedException e) {
      log.info("InterruptedException was thrown");
      throw e;
    }
  }
}
