package de.unwichtich.versionizer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VersionizerApplication {
    
    @Autowired
    private RetrievalService retriever;

    public static void main(String[] args) {
        SpringApplication.run(VersionizerApplication.class, args);
    }

    @GetMapping("/")
    public String base() {
        return String.format("In progress...");
    }
    
    @GetMapping("/versions")
    public String versions(@RequestParam(value = "service", defaultValue = "messenger") String service) {
        
        List sites = new ArrayList<String>();
        
        if (retriever.getVersionHTML(service, sites) != null) {
            return retriever.getVersionHTML(service, sites);
        } else {
            return String.format("Currently no information for %s!", service);
        }
        
    }
}
