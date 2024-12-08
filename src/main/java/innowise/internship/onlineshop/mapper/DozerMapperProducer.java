package innowise.internship.onlineshop.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.dozer.DozerBeanMapper;

@ApplicationScoped
public class DozerMapperProducer {

    @Produces
    @ApplicationScoped
    public DozerBeanMapper createMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        // Optional: Add custom mapping configurations if needed
        // mapper.setMappingFiles(List.of("dozer-mapping.xml"));
        return mapper;
    }
}

