package de.unwichtich.versionizer;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RetrievalService {
    
   public String getVersionHTML(String service, List<String> sites) {
       if (sites != null && !sites.isEmpty()) {
           return buildHTML();
       } else {
           return null;
       }
       
   }
   
   private String buildHTML() {
       StringBuilder builder = new StringBuilder();
       
       builder.append("<html>");
       
       builder.append("</html>");
       
       return builder.toString();
   }
}
