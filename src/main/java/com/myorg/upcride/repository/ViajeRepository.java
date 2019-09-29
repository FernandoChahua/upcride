package com.myorg.upcride.repository;

import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    //////////////////////Todos los filtros de viaje (al menos por ahora)////////////////////////////////////////////////////////////////////////////////////////////



    /// Visualizar viajes por solicitud y pasajero
    @Query("SELECT v FROM Viaje v JOIN Solicitud s JOIN Usuario u WHERE s.id = ?1 AND u.id = ?2")
    List<Viaje> listarPorSolicitudyPorPasajero(int solicitudId, int pasajeroId) ;


    //Calcular cuantos pasajeros hay ya registrados en un viaje
    @Query("SELECT COUNT(s.pasajero.id) FROM Viaje v JOIN Solicitud s where v.id = ?1 group by v.id")
    int calcularNumerodePasajerosDelViaje(Integer viajeId) ;

    //Aumentar el numero de pasajeros de un viaje
    @Modifying
    @Query("UPDATE Viaje v SET v.numeroPasajeros = :numero WHERE v.id = :id")
    @Transactional
    int actualizarNumeroPasajeros(@Param("numero") int numPasajeros, @Param("id") Integer id) ;


    //Visualizar la lista de los pasajeros cuyas solicitudes fueron aceptadas
    @Query("SELECT u FROM Usuario u JOIN Solicitud s ON u.id = s.pasajero.id JOIN Viaje v ON v.id = s.viaje.id WHERE v.id = ?1 AND s.confirmacionConductor = 'Aceptada'")
    List<Usuario> listarPasajerosDelViaje(Integer viajeId) ;


    //Visualizar todos los viajes que el conductor ha publicado
    @Query("SELECT v FROM Viaje v JOIN Usuario u ON u.id = v.conductor.id WHERE u.id = ?1")
    List<Viaje> listarViajesPorConductor(Integer conductorId);


    //Mostrar los viajes que esten pendientes
    @Query("SELECT s FROM Solicitud s WHERE s.viaje.id = ?1 AND s.confirmacionConductor = 'Pendiente' ")
    List<Solicitud> listarSolicitudesPendientesDelViaje(Integer viajeId);

    //Actualizar estado del viaje
    @Modifying
    @Query("UPDATE Viaje v SET v.estado = :estado WHERE v.id = :id")
    @Transactional
    int actualizarEstado(@Param("estado") String estado, @Param("id") Integer id) ;


    //Mostrar las solicitudes confirmadas por el conductor
    @Query("SELECT s FROM Solicitud s WHERE s.viaje.id = ?1 AND s.confirmacionConductor = 'Aceptada' ")
    List<Solicitud> listarSolicitudesConfrimadasDelViaje(Integer viajeId);
}
