package kz.roxy.tsoed.restservice.server;

import kz.roxy.tsoed.restservice.domain.DocToTsoed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rs")
public class ControllerDocToTsoed {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerDocToTsoed.class);

    @RequestMapping(method = RequestMethod.POST, value = "/docToTsoed")
    public ResponseEntity<String> docToTsoed(@RequestBody DocToTsoed input) {
        // http://localhost:8080/rs/docToTsoed
        // {"correspondentList":[{"name":"Correspondent1"}, {"name":"Correspondent2"}], "name":"DocToTsoed1"}
        LOGGER.info("input = {}", input);
        return ResponseEntity.ok("ok");
    }
}
