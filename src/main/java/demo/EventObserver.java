package demo;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

@RequestScoped
public class EventObserver {

  private static final Logger log = Logger.getLogger("EventObserver");

  @Inject
  private SimpleEventActions simpleEventActions;

  public void observe(@Observes SimpleEvent simpleEvent){
    simpleEventActions.execute(simpleEvent);
  }

  public void observeAsync(@ObservesAsync SimpleEvent simpleEvent)  {
    simpleEventActions.execute(simpleEvent);
  }
}
