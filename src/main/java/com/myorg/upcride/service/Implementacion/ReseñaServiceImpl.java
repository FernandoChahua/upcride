package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Reseña;
import com.myorg.upcride.model.Viaje;
import com.myorg.upcride.repository.ReseñaRepository;
import com.myorg.upcride.repository.ViajeRepository;
import com.myorg.upcride.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReseñaServiceImpl implements ReseñaService {

    ReseñaRepository reseñaRepository;
    ViajeRepository viajeRepository;
    @Autowired
    public ReseñaServiceImpl(ReseñaRepository reseñaRepository, ViajeRepository viajeRepository){
        this.reseñaRepository = reseñaRepository;
        this.viajeRepository = viajeRepository;
    }

    @Override
    public Reseña publicarReseña(Reseña r) throws Exception{
        return reseñaRepository.save(r);
    }


    @Override
    public List<Reseña> listarReseñasPorConductor (Integer conductorId){
        return reseñaRepository.listarReseñasPorConductor(conductorId);
    }

    @Override
    public Reseña publicarReseñaPorViaje(Reseña r, Integer viajeId ) throws Exception{
        Viaje v = viajeRepository.findById(viajeId).get();
        r.setViaje(v);
        return reseñaRepository.save(r);

    }
}
