package Ciclo31.Ciclo31.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Dummies.CountClient;
import Ciclo31.Ciclo31.Dummies.StatusAmount;
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

    public Reservation insertReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationByDates(String fUno, String fDos) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(fUno);
            b = parser.parse(fDos);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservationRepository.getReservationPeriod(a, b);
    }

    public StatusAmount getReservationsStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());

    }

    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }
}
