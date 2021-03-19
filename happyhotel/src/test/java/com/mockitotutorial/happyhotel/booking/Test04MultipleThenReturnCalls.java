package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

class Test04MultipleThenReturnCalls {

	private BookingService bookingService;

	// dependencies //classes
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setUp() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

		System.out.println("List returned " + roomServiceMock.getAvailableRooms());
		System.out.println("Objects returned " + roomServiceMock.findAvailableRoomId(null));
		System.out.println("Primitive returned " + roomServiceMock.getRoomCount());

	}

	@Test
	void should_CountAvailablePlaces_When_CalledMultipleTimes() {
		// given
		when(this.roomServiceMock.getAvailableRooms())
			.thenReturn(Collections.singletonList(new Room("Room 1", 2)))
			.thenReturn(Collections.emptyList());
		int expectedFirstCall = 2;
		int expectedSecondCall = 0;
		
		// when
		int actualFirstCall = bookingService.getAvailablePlaceCount();
		int actualSecondCall = bookingService.getAvailablePlaceCount();
		// then
		assertAll(
				() -> assertEquals(expectedFirstCall, actualFirstCall),
				() -> assertEquals(expectedSecondCall, actualSecondCall)
				);
		
		
	}

}
