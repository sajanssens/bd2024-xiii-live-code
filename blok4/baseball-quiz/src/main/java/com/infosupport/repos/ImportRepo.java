package com.infosupport.repos;

import com.infosupport.domain.ImportDto;
import com.infosupport.util.importer.ImporterProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ImportRepo {

    @Inject
    private ImporterProducer importer;

    public void start(ImportDto dto) {
        importer.send(dto);
    }
}
