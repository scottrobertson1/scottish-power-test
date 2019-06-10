package main.java.rest.domain;



public class Meter implements Identifiable {

    private Long id;
    private Long gas_id;
    private Long elec_id;
    private String elec_smart_read;
    private String gas_smart_read;

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getGas_id() {
        return gas_id;
    }
    public void setGas_id(Long gas_id) {
        this.gas_id = gas_id;
    }

    public Long getElec_id() {
        return elec_id;
    }
    public void setElec_id(Long elec_id) {
        this.elec_id = elec_id;
    }

    public String getElec_smart_read() {
        return elec_smart_read;
    }
    public void setElec_smart_read(String elec_smart_read) {
        this.elec_smart_read= elec_smart_read ;
    }

    public String getGas_smart_read() {
        return gas_smart_read;
    }

    public void setGas_smart_read(String gas_smart_read) {
        this.gas_smart_read= gas_smart_read ;
    }
}