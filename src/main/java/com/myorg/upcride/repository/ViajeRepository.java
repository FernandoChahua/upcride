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
    @Query("SELECT v FROM Viaje v WHERE v.horaPartida = ?1 and v.horaLlegada = ?2 AND v.puntoPartida = ?3 AND v.puntoDestino = ?4 AND v.entradaSalida= ?5 AND v.fecha = ?6")
    List<Viaje> listarPorTodosLosFiltros(Time horaPartida, Time horaLlegada, String puntoPartida, String puntoDestino, int entradaSalida, Date fecha) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.puntoPartida = ?1 AND v.puntoDestino = ?2")
    List<Viaje> listarPorPuntoPartidaYPuntoDestino(String puntoPartida,String puntoDestino) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.horaPartida = ?1 and v.horaLlegada = ?2")
    List<Viaje> listarPorHoraInicioYHoraFin(Time horaPartida, Time horaLlegada) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.horaLlegada = ?1")
    List<Viaje> listarPorHoraLlegada(Time horaLlegada) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.puntoPartida = ?1 AND v.puntoDestino = ?2 AND v.horaPartida = ?3 and v.horaLlegada = ?4")
    List<Viaje> listarPorPuntoPartidaYPuntoDestinoYHoraInicioYHoraFin(String puntoPartida,String puntoDestino, Time horaPartida, Time HoraLlegada) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.horaPartida = ?1 and v.horaLlegada = ?2 AND v.puntoPartida = ?3 AND v.puntoDestino = ?4 AND v.fecha = ?5")
    List<Viaje>listarPorPuntoPartidaYPuntoDestinoYHoraInicioYHoraFinYFecha( Time horaPartida, Time horaLlegada,String puntoPartida,String puntoDestino, Date fecha) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.entradaSalida= ?1")
    List<Viaje> listarPorEntradaOSalida(int entradaSalida) throws Exception;

    @Query("SELECT v FROM Viaje v WHERE v.fecha = ?1")
    List<Viaje> listarPorFecha(Date fecha) throws Exception;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /// Visualizar viajes por solicitud y pasajero
    @Query("SELECT v FROM Viaje v JOIN Solicitud s JOIN Usuario u WHERE s.id = ?1 AND u.id = ?2")
    List<Viaje> listarPorSolicitudyPorPasajero(int solicitudId, int pasajeroId) throws Exception;


    //Calcular cuantos pasajeros hay ya registrados en un viaje
    @Query("SELECT COUNT(s.pasajero.id) FROM Viaje v JOIN Solicitud s where v.id = ?1 group by v.id")
    int calcularNumerodePasajerosDelViaje(Integer viajeId) throws Exception;

    //Aumentar el numero de pasajeros de un viaje
    @Modifying
    @Query("UPDATE Viaje v SET v.numeroPasajeros = :numero WHERE v.id = :id")
    @Transactional
    int actualizarNumeroDePasajeros(@Param("numero") int numPasajeros, @Param("id") Integer id) throws Exception;


    //Visualizar la lista de los pasajeros cuyas solicitudes fueron aceptadas
    @Query("SELECT u FROM Usuario u JOIN Solicitud s ON u.id = s.pasajero.id JOIN Viaje v ON v.id = s.viaje.id WHERE v.id = ?1 AND s.confirmacionConductor = 'Aceptada'")
    List<Usuario> listarPasajerosDelViaje(Integer viajeId) throws Exception;


    //Visualizar todos los viajes que el conductor ha publicado
    @Query("SELECT v FROM Viaje v JOIN Usuario u ON u.id = v.conductor.id WHERE u.id = ?1")
    List<Viaje> listarViajesPorConductor(Integer conductorId) throws Exception;


    //Mostrar los viajes que esten pendientes
    @Query("SELECT s FROM Solicitud s WHERE s.viaje.id = ?1 AND s.confirmacionConductor = 'Pendiente' ")
    List<Solicitud> listarSolicitudesPendientesDelViaje(Integer viajeId) throws Exception;

    //Actualizar estado del viaje
    @Modifying
    @Query("UPDATE Viaje v SET v.estado = :estado WHERE v.id = :id")
    @Transactional
    int actualizarEstado(@Param("estado") String estado, @Param("id") Integer id) throws Exception;


    //Mostrar las solicitudes confirmadas por el conductor
    @Query("SELECT s FROM Solicitud s WHERE s.viaje.id = ?1 AND s.confirmacionConductor = 'Aceptada' ")
    List<Solicitud> listarSolicitudesConfrimadasDelViaje(Integer viajeId) throws Exception;
}
