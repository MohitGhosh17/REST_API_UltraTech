package org.cole.example;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.cole.example.model.Record;
import org.cole.example.service.RecordService;
import org.springframework.stereotype.Component;

@Component
public class Endpoint extends RouteBuilder {

    private final RecordService recordService;

    public Endpoint(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .contextPath("/api") // matches camel.servlet.mapping.context-path
                .dataFormatProperty("prettyPrint", "true");

        rest("/rest")
                .post("/records")
                .type(Record.class)
                .outType(Record.class)
                .to("direct:createRecord");

        from("direct:createRecord")
                .bean(recordService, "createRecord")
                .marshal().json();
    }
}
