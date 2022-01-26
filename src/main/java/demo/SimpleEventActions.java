package demo;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@RequestScoped
public class SimpleEventActions {

  private static final Logger log = Logger.getLogger("SimpleEventActions");

  @Transactional
  public void execute(SimpleEvent simpleEvent) {
    log.info(String.format("Executing %s %s and sleeping for %s ms", simpleEvent.getStyle(), simpleEvent.getId(), simpleEvent.getSleepDuration().toMillis()));
    Uninterruptibles.sleepUninterruptibly(simpleEvent.getSleepDuration());
    log.info(String.format("Finished %s", simpleEvent.getId()));
    log.info("InterruptedException was thrown");
  }
}
