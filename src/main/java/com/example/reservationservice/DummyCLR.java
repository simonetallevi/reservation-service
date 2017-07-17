package com.example.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by tallesi001 on 11/07/17.
 */
@Component
public class DummyCLR implements CommandLineRunner{
    private final ReservationRepository reservationRepository;

    @Autowired
    public DummyCLR(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Simone", "Franco", "Alberto")
                .forEach( n -> reservationRepository.save(new Reservation(n)));

        reservationRepository.findAll().forEach(System.out::println);
    }
}
