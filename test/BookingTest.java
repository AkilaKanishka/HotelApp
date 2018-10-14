/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.test;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author akilakanishka
 */
public class BookingTest {
    
    public BookingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addServiceCharge method, of class Booking.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
        
        Hotel hotel = new Hotel();
    	hotel.addRoom(RoomType.SINGLE, 101);
    	hotel.addRoom(RoomType.DOUBLE, 201);
    	hotel.addRoom(RoomType.TWIN_SHARE, 301);
        
        Guest guest = new Guest("Akila", "Keilor", 3);
	    CreditCard card = new CreditCard(CreditCardType.VISA, 2, 2);
		
    	Room room = hotel.findAvailableRoom(RoomType.TWIN_SHARE, new Date(2018, 11, 05), 1);
    	long confNo = hotel.book(room, guest, new Date(2018, 11, 05), 1, 2, card);
    	Booking booking = hotel.findBookingByConfirmationNumber(confNo);
    	hotel.checkin(confNo);
        double cost = 5.0;
        
        booking.addServiceCharge(ServiceType.ROOM_SERVICE, cost);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(booking.getCharges().get(0).getCost(), 5.0);
    }

}
