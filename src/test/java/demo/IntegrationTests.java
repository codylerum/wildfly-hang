package demo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;


@RunWith(Arquillian.class)
public class IntegrationTests {


  @Test
  public void fireAsyncObserver(@Drone WebDriver driver) {
    driver.get("http://localhost:8080/demo");
    Assert.assertNotNull(driver.findElement(By.id("pageEnd")));
    driver.findElement(By.xpath("//button[@type='submit']/span[.='Execute Async']")).click();
    driver.close();
  }

  @Deployment(testable = false)
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
