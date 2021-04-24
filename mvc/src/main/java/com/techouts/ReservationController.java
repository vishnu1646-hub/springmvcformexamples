package com.techouts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class ReservationController {
	@RequestMapping("/bookingForm")
	public String bookingForm(Model model) {
		// create reservation object
		Reservation reservationReference = new Reservation();
		model.addAttribute("reservation", reservationReference);
		return "reservation-page";
	}

	@RequestMapping("/submitForm")
	// @ModelAttribute binds form data to the object
	public String submitForm(@ModelAttribute("reservation") Reservation reference) {
		return "confirmation-form";
	}
}
