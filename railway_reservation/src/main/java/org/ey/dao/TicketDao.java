package org.ey.dao;

import org.ey.dto.Ticket;
import org.ey.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	@Autowired
	TicketRepository repository;

	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	}