package demo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;


@RunWith(Arquillian.class)
public class IntegrationTests {

  @Inject
  private TestActions testActions;

  @Test
  public void fireAsyncObserver() throws InterruptedException {
    testActions.fireAsyncEvent();
  }

  @Deployment
  public static WebArchive deployment() {
    try {
      final String buildTargetDirectory = System.getProperty("projectBuildDirectory", "target");
      System.out.printf("****************   START War Build from (%s)   ***************************%n", buildTargetDirectory);
      Path path = Paths.get(buildTargetDirectory, "demo.war");
      return
          ShrinkWrap.create(ZipImporter.class, "demo.war").importFrom(path.toFile()).as(WebArchive.class);
    } finally {
      System.out.println("*****************  End War Build  *****************");
    }
  }
}
