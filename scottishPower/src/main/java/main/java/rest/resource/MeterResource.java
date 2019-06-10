package main.java.rest.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.java.rest.domain.Meter;
import org.springframework.hateoas.ResourceSupport;

public class MeterResource extends ResourceSupport {


    private final Long id;
    private final Long gas_id;
    private final Long elec_id;
    private final String elec_smart_read;
    private final String gas_smart_read;

    public MeterResource(Meter meter) {
        id = meter.getId();
        gas_id = meter.getGas_id();
        elec_id = meter.getElec_id();
        elec_smart_read = meter.getElec_smart_read();
        gas_smart_read = meter.getGas_smart_read();

    }
    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }
    public Long getGas_id() {
        return gas_id;
    }
    public Long getElec_id() {
        return elec_id;
    }
    public String getElec_smart_read() {
        return elec_smart_read;
    }
    public String getGas_smart_read() {
        return gas_smart_read;
    }
}
