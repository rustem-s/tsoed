package kz.roxy.tsoed.rest.synergystub;

import kz.roxy.tsoed.rest.domain.DocToTsoed;
import kz.roxy.tsoed.rest.domain.synergy.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/synergystub")
public class ControllerSynergyStub {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerSynergyStub.class);

    @RequestMapping(method = RequestMethod.GET, value = "/form")
    public ResponseEntity<Form> getForm(@RequestParam String formId) {
        // http://localhost:8080/synergystub/form?formId=1
        // {"formId":"1"}
        LOGGER.info("input = {}", formId);
        Form form = new Form();

        form.setField1("field1value");
        form.setField2("filed2value");
        return new ResponseEntity<Form>(form, HttpStatus.OK);
    }
}
