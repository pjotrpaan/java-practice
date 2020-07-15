package ee.paan.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
	@RequestMapping("/list")
	public String listItems (Model m) {
		return "list-items";
	}
}
