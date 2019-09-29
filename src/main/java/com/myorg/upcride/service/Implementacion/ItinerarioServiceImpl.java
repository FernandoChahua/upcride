package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Itinerario;
import com.myorg.upcride.repository.ItinerarioRepository;
import com.myorg.upcride.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItinerarioServiceImpl implements ItinerarioService {

    ItinerarioRepository itinerarioRepository;

    @Autowired
    public ItinerarioServiceImpl(ItinerarioRepository itinerarioRepository){
        this.itinerarioRepository = itinerarioRepository;
    }

    public Itinerario ingresarItinerario(Itinerario i) throws Exception{
        return itinerarioRepository.save(i);
    }

}
