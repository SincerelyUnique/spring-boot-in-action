package readinglist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon")  //注入带amazon前缀的属性
public class AmazonProperties {

  private String associateId;
  
  public void setAssociateId(String associateId) {  //associateId的setter方法
    this.associateId = associateId;
  }
  
  public String getAssociateId() {
    return associateId;
  }
  
}
