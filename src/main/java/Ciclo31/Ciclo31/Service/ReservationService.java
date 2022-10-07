package Ciclo31.Ciclo31.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Model.Reservation;
import Ciclo31.Ciclo31.Repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation (int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getId()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux=reservationRepository.getReservation(r.getId());
            if (raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
}
