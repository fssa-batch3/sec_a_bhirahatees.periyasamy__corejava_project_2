package com.fssa.pupdesk.services;

import com.fssa.pupdesk.model.Ticket;
import com.fssa.pupdesk.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TestTicketService {

	// Test case for creating a ticket successfully
	@Test
	void testCreateTicketServicePass() {
		TicketService ticketService = new TicketService();
		try {
			assertTrue(ticketService.createTicketService(new Ticket("bhirahatees.periysamy@fssa.freshworks.com",
					"gowtham.sathyamoorthy@fssa.freshworks.com", "I have a find bugs in your code", "High", "Pending",
					"While Testing I find the bugs in your code")));
		} catch (ServiceException e) {
			System.out.println("Failed To Create Ticket");
			e.printStackTrace();
			fail();
		}
	}

	// Test case for creating a ticket with invalid data
	@Test
	void testCreateTicketServiceFail() {
		TicketService ticketService = new TicketService();
		assertThrows(ServiceException.class, () -> {
			ticketService.createTicketService(new Ticket("bhirahatees.periysamy@fssa.freshworks.com",
					"gowtham.sathyamoorthy@fssa.freshworks.com", "I have find bugs in your code", "Pending", "High",
					"While Testing I find the bugs in your code"));
		});
	}

	// Test case for listing tickets successfully
	@Test
	void testListTicketServicePass() {
		try {
			TicketService service = new TicketService();
			assertNotNull(new TicketService().listTicketService("bhirahatees.periysamy@fssa.freshworks.com"));
		} catch (ServiceException e) {
			fail();
		}
	}

	// Test case for listing tickets with invalid email
	@Test
	void testListTicketServiceFail() {
		TicketService service = new TicketService();
		assertThrows(ServiceException.class, () -> service.listTicketService("invalid.email@fssa.freshworks.com"));
	}

	// Test case for updating ticket status successfully
	@Test
	void testUpdateTicketServicePass() throws ServiceException {
		TicketService ticket = new TicketService();
		assertTrue(ticket.updateTicketStatusService("361B6C15AA9E8D",
				"Sorry for the issue Bhirahatees We'll fix that issue for you \n , Thank You For reporting to us"));
	}

	// Test case for updating ticket status with invalid ticket ID
	@Test
	void testUpdateTicketServiceFail() {
		TicketService ticket = new TicketService();
		assertThrows(ServiceException.class, () -> ticket.updateTicketStatusService("A9B01DC0D11#$%8", ""));
	}

	// Test case for getting tickets by status successfully
	@Test
	void testGetTicketServicePass() {
		TicketService service = new TicketService();
		try {
			assertNotNull(service.getTicketbyService("bhirahatees.periysamy@fssa.freshworks.com", "Pending"));
		} catch (ServiceException e) {
			fail();
		}
	}

	// Test case for getting tickets by status with invalid email
	@Test
	void testGetTicketServiceFail() {
		TicketService service = new TicketService();
		assertThrows(ServiceException.class, () -> {
			service.getTicketbyService("invalid.email@fssa.freshworks.com", "complete");
		});
	}

	// Test case for getting a ticket by ID successfully
	@Test
	void testGetTicketByIdServicePass() {
		try {
			assertNotNull(new TicketService().getTicketByIdService("361B6C15AA9E8D"));
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
	}

	// Test case for getting a ticket by invalid ID
	@Test
	void testGetTicketByIdServiceFail() {
		assertThrows(ServiceException.class, () -> new TicketService().getTicketByIdService("6C391430M0ADA6"));
	}
}
