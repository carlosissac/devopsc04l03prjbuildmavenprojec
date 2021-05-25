package maven.project.devopsc04l03prjbuildmavenproject.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenWeatherMapController {

  private final String SITE_IS_UP = "Site is up!";
  private final String SITE_IS_DOWN = "Site is down!";
  private final String INCORRECT_URL = "URL is incorrect";

  @GetMapping("/check")
  //public String getOpenWeatherMapStatusMessage(@RequestParam String url) {
    public String getOpenWeatherMapStatusMessage() {
    //String url = "https://github.com/234poiu5p2oiu43p5o2iup3";
    String url = "https://pitchfork.com";
    //String url = "https://goggggle.com";
    String returnMessage = "";
    try {
      URL urlObj = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      System.out.println(conn.getResponseCode());
      int respCodeCat = conn.getResponseCode() / 100;
     // System.out.println(respCodeCat);
      if ((respCodeCat == 2) || (respCodeCat == 3)) {
        //System.out.println(SITE_IS_UP);
        returnMessage = SITE_IS_UP;
      } else {
        //System.out.println(SITE_IS_DOWN);
        returnMessage = SITE_IS_DOWN;
      }

    } catch (MalformedURLException e) {
      returnMessage = INCORRECT_URL;
    } catch (IOException e) {
      returnMessage = SITE_IS_DOWN;
    }
    return returnMessage;
  }

}
