package demo;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@RequestScoped
public class SimpleEventActions {

  private static final Logger log = Logger.getLogger("SimpleEventActions");

  @Transactional
  public void execute(SimpleEvent simpleEvent) throws InterruptedException {
    try {
      log.info(String.format("Executing %s %s and sleeping for %s ms", simpleEvent.getStyle(), simpleEvent.getId(), simpleEvent.getSleepDuration().toMillis()));
      Thread.sleep(simpleEvent.getSleepDuration().toMillis());
      log.info(String.format("Finished %s", simpleEvent.getId()));
    } catch (InterruptedException e) {
      log.info("InterruptedException was thrown");
      throw e;
    }
  }
}
