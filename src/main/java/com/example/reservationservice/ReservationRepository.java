package com.example.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by tallesi001 on 11/07/17.
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
