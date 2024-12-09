package innowise.internship.onlineshop.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.dozer.DozerBeanMapper;

@ApplicationScoped
public class DozerMapperProducer {

    @Produces
    @ApplicationScoped
    public DozerBeanMapper createMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        //custom mapping: mapper.setMappingFiles(List.of("dozer-mapping.xml"));
        return mapper;
    }
}

