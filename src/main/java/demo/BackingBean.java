package demo;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class BackingBean implements Serializable {

  private static final Logger log = Logger.getLogger("BackingBean");

  @Resource(lookup = "java:jboss/ee/concurrency/executor/serial")
  private ManagedExecutorService serialExecutor;

  @Inject
  private Event<SimpleEvent> event;

  public void executeAsync() {
    final String id = UUID.randomUUID().toString();
    log.info(String.format("Executing Asynchronous: %s", id));
    event.fireAsync(new SimpleEvent(id, Duration.ofSeconds(5)), NotificationOptions.ofExecutor(serialExecutor));
  }
}
