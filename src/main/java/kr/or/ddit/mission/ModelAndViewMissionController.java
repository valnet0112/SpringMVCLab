package kr.or.ddit.mission;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * url : /mission/now.nhn
 * method : GET
 * model : 현재 시각, model명 : now
 * response content type : HTML / JSON
 *
 */
@Slf4j
@Controller
@RequestMapping("/mission")
public class ModelAndViewMissionController {
	@Inject
	private NowGeneratorService service;
	
	@GetMapping(value="/now.nhn", produces = MediaType.TEXT_HTML_VALUE)
	private String hander1(Model model) {
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now", now);
		return "mission/resultView";
	}
	
	@GetMapping(value="/now.nhn", produces = MediaType.APPLICATION_JSON_VALUE)
	private String hander2(Model model) {
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now", now);
		return "jsonView";
	}
}
