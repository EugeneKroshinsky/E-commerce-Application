package innowise.internship.onlineshop.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.dozer.DozerBeanMapper;

import java.util.List;

@ApplicationScoped
public class DozerMapperProducer {

    @Produces
    @ApplicationScoped
    public DozerBeanMapper createMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(List.of("dozer_custom_convertor.xml"));
        return mapper;
    }
}

