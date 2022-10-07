package Ciclo31.Ciclo31.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ciclo31.Ciclo31.Model.Reservation;
import Ciclo31.Ciclo31.Repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return(List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation (int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save (Reservation r){
        return reservationCrudRepository.save(r);
    }

}
