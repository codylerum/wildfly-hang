package demo;

import com.google.common.util.concurrent.Uninterruptibles;

import java.time.Duration;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;

@RequestScoped
public class TestActions {

  private static final Logger log = Logger.getLogger("BackingBean");

  @Resource(lookup = "java:jboss/ee/concurrency/executor/serial")
  private ManagedExecutorService serialExecutor;

  @Inject
  private Event<SimpleEvent> event;

  public void fireAsyncEvent() {
    final String id = UUID.randomUUID().toString();
    log.info(String.format("Executing Asynchronous: %s", id));
    event.fireAsync(new SimpleEvent(id, EventStyle.ASYNC, Duration.ofSeconds(15)), NotificationOptions.ofExecutor(serialExecutor));
    Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
  }
}
