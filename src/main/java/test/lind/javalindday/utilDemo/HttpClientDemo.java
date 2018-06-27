package test.lind.javalindday.utilDemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpClientDemo {
  private static String httpClient(String url, HttpMethod method, MultiValueMap<String, String> params) {
    RestTemplate client = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
    ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
    return response.getBody();
  }

  public static void test() {
    System.out.println(httpClient("http://www.baidu.com", HttpMethod.GET, null));
  }
}
