package com.mobi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobi.model.Booking;
import com.mobi.model.Room;
import com.mobi.service.BookingService;
import com.mobi.service.RoomService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HttpServletRequest request ;
	
	@RequestMapping(value = "/bookings")
	public ModelAndView bookings() {
		int userid = (int) request.getSession().getAttribute("userid");
		ModelAndView mav = new ModelAndView("bookings");
		List<Booking> bookings = bookService.getAllById(userid);
		mav.addObject("bookings", bookings);
		return mav;
	}
	
	@RequestMapping(value = "/book")
	public ModelAndView test2() {
		int roomid=1;
		ModelAndView mav = new ModelAndView("book");
		Room room = roomService.getroom(roomid);
		mav.addObject("room", room);
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(
			@RequestParam String roomid,
			@RequestParam String reqrooms) {
		int userid = (int) request.getSession().getAttribute("userid");
		Room room = roomService.getroom(Integer.valueOf(roomid));
		int avlroom =room.getRooms();
		int remroom =0;
		int reqroom =Integer.valueOf(reqrooms);
		if(avlroom > reqroom){
			remroom = avlroom - reqroom;
			room.setRooms(remroom);
		}
		
		Booking book = new Booking();
		book.setUserid(userid);
		book.setRooms(reqroom);
		book.setBooks(room);
		book.setStatus(true);
		
		List<Booking> bookings = new ArrayList<>();
		bookings.add(book);
		
		room.setBookings(bookings);
		
		roomService.save(room);
		
		return "true";
	}

}
