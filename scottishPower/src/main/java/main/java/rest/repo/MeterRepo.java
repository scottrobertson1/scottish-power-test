package main.java.rest.repo;


import main.java.rest.domain.Meter;
import org.springframework.stereotype.Repository;

@Repository
public class MeterRepo extends InMemoryRepo<Meter> {

    protected void updateIfExists(Meter original, Meter updated) {
        original.setElec_id(updated.getElec_id());
        original.setGas_id(updated.getGas_id());
        original.setElec_smart_read(updated.getElec_smart_read());
        original.setGas_smart_read(updated.getElec_smart_read());
    }
}