package demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class BackingBean implements Serializable {

    private static final Logger log = Logger.getLogger("BackingBean");

    private List<String> randomStrings = new ArrayList<>();

    @Inject
    private void init() {
        log.info("Starting Request");
        try {
            //Slow the load down a bit
            for (int i = 0; i < 1000; i++) {
                randomStrings.add(UUID.randomUUID().toString());
            }
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            log.info("Interruption Sleeping");
        }
    }

    public List<String> getRandomStrings() {
        return randomStrings;
    }
}
