package quest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model){
		return "home";}

	@GetMapping("/accueil")
	public String index(){
		return "index";}

//	@GetMapping("/what")
//	public String what(){
//		return "forward:/accueil";}
	
}
