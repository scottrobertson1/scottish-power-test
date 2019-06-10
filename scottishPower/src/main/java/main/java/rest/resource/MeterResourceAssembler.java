package main.java.rest.resource;

import main.java.rest.domain.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;


@Component
public class MeterResourceAssembler extends ResourceAssembler<Meter, MeterResource> {

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public MeterResource toResource(Meter meter) {

        MeterResource resource = new MeterResource(meter);

        final Link selfLink = entityLinks.linkToSingleResource(meter);

        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));

        return resource;
    }
}