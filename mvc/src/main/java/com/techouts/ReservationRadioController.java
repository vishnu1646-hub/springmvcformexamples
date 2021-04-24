package com.techouts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservationradio")
@Controller
public class ReservationRadioController {
	@RequestMapping("/bookingFormRadio")
	public String bookingFormRadio(Model model) {
		ReservationRadio radio = new ReservationRadio();
		model.addAttribute("reservationradio", radio);
		return "reservationradio-page";
	}

	@RequestMapping("/submitFormRadio")
	public String submitFormRadio(@ModelAttribute("reservationradio") ReservationRadio radio) {
		return "confirmationradio-page";
	}
}
