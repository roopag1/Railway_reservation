package org.ey.service;

import org.ey.dao.TicketDao;
import org.ey.dao.UserDao;
import org.ey.dto.Ticket;
import org.ey.dto.User;
import org.ey.helper.ResponseStructure;
import org.ey.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	UserDao userDao;
	@Autowired
	JwtUtil jwtUtil;

	public ResponseStructure<Ticket> bookTicket(Ticket ticket, String token) {
		// Verify token
		if (jwtUtil.validateToken(token)) {
			Long userId = jwtUtil.extractUserId(token);
			User user = userDao.findById(userId);
			ticket.setUser(user);
			Ticket savedTicket = ticketDao.save(ticket);
			ResponseStructure<Ticket> response = new ResponseStructure<>();
			response.setMessage("Ticket booked successfully");
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setData(savedTicket);
			return response;
		} else {
		}
	}

}
