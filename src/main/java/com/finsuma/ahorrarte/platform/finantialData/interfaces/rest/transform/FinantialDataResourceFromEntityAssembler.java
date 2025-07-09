package com.finsuma.ahorrarte.platform.finantialData.interfaces.rest.transform;

import com.finsuma.ahorrarte.platform.finantialData.domain.model.FinantialData;
import com.finsuma.ahorrarte.platform.finantialData.interfaces.rest.resources.FinantialDataResource;
import org.springframework.stereotype.Component;

@Component
public class FinantialDataResourceFromEntityAssembler {

    public FinantialDataResource toResource(FinantialData entity) {
        FinantialDataResource resource = new FinantialDataResource();
        resource.setIdDatoFinanciero(entity.getIdDatoFinanciero());
        resource.setIdUsuario(entity.getIdUsuario());
        resource.setTipoDato(entity.getTipoDato());
        resource.setMonto(entity.getMonto());
        resource.setFecha(entity.getFecha());
        resource.setDescripcion(entity.getDescripcion());
        return resource;
    }
}
