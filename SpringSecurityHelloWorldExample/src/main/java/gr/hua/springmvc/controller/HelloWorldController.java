
package gr.hua.springmvc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.springmvc.controller.models.Appointment;
import gr.hua.springmvc.controller.models.AppointmentDao;
import gr.hua.springmvc.controller.models.Email;
import gr.hua.springmvc.controller.models.EmailDao;
import gr.hua.springmvc.controller.models.Event;
import gr.hua.springmvc.controller.models.EventDao;
import gr.hua.springmvc.controller.models.ReqAppoint;
import gr.hua.springmvc.controller.models.ReqAppointDao;
import gr.hua.springmvc.controller.models.Request;
import gr.hua.springmvc.controller.models.RequestDao;

@Controller
public class HelloWorldController {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-data.xml");

	AppointmentDao appointmentDao = ctx.getBean("AppointmentDao", AppointmentDao.class);
	EmailDao emailDao = ctx.getBean("EmailDao", EmailDao.class);
	EventDao eventDao = ctx.getBean("EventDao", EventDao.class);
	RequestDao requestDao = ctx.getBean("RequestDao", RequestDao.class);
	ReqAppointDao reqDao = ctx.getBean("ReqAppointDao", ReqAppointDao.class);

		
	 @RequestMapping("/helloworld")
	 public ModelAndView hello() {
	 
	  String helloWorldMessage = "Welcome Page";
	  return new ModelAndView("hello", "message", helloWorldMessage);
	 }
	 
	 @RequestMapping("/")
	 public ModelAndView redi() {
	 
	  
	  return new ModelAndView("redirect:/login");
	 }
	 
	 @RequestMapping("/logout")
	 public ModelAndView log() {
	 
	  
	  return new ModelAndView("logout");
	 }
	 
	 @RequestMapping("/admin")
	 public ModelAndView admin() {
	 
	  
	  return new ModelAndView("admin");
	 }
	 
	 @RequestMapping("/supermoderator")
	 public ModelAndView supermode() {
	 
	  
	  return new ModelAndView("super");
	 }
	 
	 @RequestMapping("/moderator")
	 public ModelAndView mode() {
	 
	  
	  return new ModelAndView("mode");
	 }
	 
	 @RequestMapping(value = "/addAppointment", method = RequestMethod.POST)
		public ModelAndView addAppointment(@ModelAttribute("newAppointment")Appointment appointment, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				
				if(appointment.getAmka()==0){
			 	appointmentDao.save(appointment);
				}else{
				appointmentDao.update(appointment);
				}
			 	request.setAttribute("newAppointment", appointment.getAmka());
				model = new ModelAndView("redirect:/AppointmentList");
			
			return model;
		}

		@RequestMapping("/edit/{amka}")
		public String editAppointmet(@PathVariable("amka") int amka, Model model) {
			model.addAttribute("newAppointment", appointmentDao.getByAmka(amka));
			return "appointment";
		}

		@RequestMapping("/remove/{amka}")
		public String removeAppoinment(@PathVariable("amka") int amka) {

			appointmentDao.deleteById(amka);
			return "redirect:/AppointmentList";
		}	 
	 
		@RequestMapping(value = "/Appointment", method = RequestMethod.GET)
		public String employee(Model model) {
			Appointment newAppointment = new Appointment();
			model.addAttribute("newAppointment", newAppointment);
			return "appointment";
		}
		
	   @RequestMapping(value = "/AppointmentList", method = RequestMethod.GET)
		public String admin(Model model) {
		
		model.addAttribute("appointment", new Appointment());
		List<Appointment> AppointList = appointmentDao.getAll();
		model.addAttribute("appointments", AppointList);
		
		return "appoint";
	}
	
	 @RequestMapping(value = "/emails", method = RequestMethod.GET)
		public String email(Model model) {
		
			model.addAttribute("eemail", new Email());
			List<Email> EmailList = emailDao.getAll();
			model.addAttribute("emails", EmailList);
		
			return "email";
		}
		
		@RequestMapping(value = "/Email", method = RequestMethod.GET)
		public String eml(Model model) {
			Email newEml = new Email();
			model.addAttribute("newEmail", newEml);
			return "eml";
		}
		
		@RequestMapping(value = "/addEmail", method = RequestMethod.POST)
		public ModelAndView addEmail(@ModelAttribute("newEmail") Email eml, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				
				emailDao.save(eml);
				
			 	request.setAttribute("newEmail", eml.getId());
				model = new ModelAndView("redirect:/emails");
			
			return model;
		}

		@RequestMapping("/Email/remove/{id}")
		public String removeEmail(@PathVariable("id") int id) {

			emailDao.deleteById(id);
			return "redirect:/emails";
		}
		
		@RequestMapping(value = "/events", method = RequestMethod.GET)
		public String evt(Model model) {
		
			model.addAttribute("event", new Event());
			List<Event> EventList = eventDao.getAll();
			model.addAttribute("events", EventList);
		
			return "event";
		}
		
		@RequestMapping(value = "/Event", method = RequestMethod.GET)
		public String event(Model model) {
			Event newEvent = new Event();
			model.addAttribute("newEvent", newEvent);
			return "evt";
		}
		
		@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
		public ModelAndView addEvent(@ModelAttribute("newEvent") Event evt, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				if(evt.getId()== 0){
				eventDao.save(evt);
				}else{
				eventDao.update(evt);
				}
			 	
			 	request.setAttribute("newEvent", evt.getId());
				model = new ModelAndView("redirect:/events");
			
			return model;
		}
		
		@RequestMapping("/Event/edit/{id}")
		public String editEvent(@PathVariable("id") int id, Model model) {
			model.addAttribute("newEvent", eventDao.getById(id));
			return "evt";
		}

		@RequestMapping("/Event/remove/{id}")
		public String removeEvent(@PathVariable("id") int id) {

			eventDao.deleteById(id);
			return "redirect:/events";
		}
		
		
		@RequestMapping(value = "/req_appointment", method = RequestMethod.GET)
		public String appoint(Model model) {
		
			model.addAttribute("appoint", new ReqAppoint());
			List<ReqAppoint> reqList = reqDao.getAll();
			model.addAttribute("appoints", reqList);
		
			return "req_app";
		}
		
		@RequestMapping(value = "/ReqAppointment", method = RequestMethod.GET)
		public String app(Model model) {
			ReqAppoint newreq = new ReqAppoint();
			model.addAttribute("newApp", newreq);
			return "app";
		}
		
		@RequestMapping(value = "/addAppoint", method = RequestMethod.POST)
		public ModelAndView addApp(@ModelAttribute("newApp") ReqAppoint req, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				
				
				reqDao.update(req);
				
			 	request.setAttribute("newApp", req.getAmka());
				model = new ModelAndView("redirect:/req_appointment");
			
			return model;
		}
		/*
		@RequestMapping(value = "/setAppoint", method = RequestMethod.POST)
		public ModelAndView setApp(@ModelAttribute("newAppoint") ReqAppoint req, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				
				
				reqDao.set(req);
				
			 	request.setAttribute("newAppoint", req.getAmka());
				model = new ModelAndView("redirect:/req_appointment");
			
			return model;
		}
		*/
		@RequestMapping("/Appointment/remove/{id}")
		public String removeApp(@PathVariable("id") int id) {

			reqDao.deleteById(id);
			return "redirect:/req_appointment";
		}
		
		@RequestMapping("/Appointment/edit/{id}")
		public String editApp(@PathVariable("id") int id, Model model) {
			model.addAttribute("newApp", reqDao.getByAmka(id));
			return "app";
		}
		/*

		@RequestMapping("/Appointment/set/{id}")
		public String saveApp(@PathVariable("id") int id, Model model) {
			model.addAttribute("newApppoint", reqDao.getByAmka(id));
			return "setapp";
		}
	 		*/
		
		@RequestMapping(value = "/req_user", method = RequestMethod.GET)
		public String req_user(Model model) {
		
			model.addAttribute("request", new Request());
			List<Request> RequestList = requestDao.getAll();
			model.addAttribute("requests", RequestList);
		
			return "req_user";
		}
		
		@RequestMapping(value = "/Request", method = RequestMethod.GET)
		public String requser(Model model) {
			Request newRequest = new Request();
			model.addAttribute("newRequest", newRequest);
			return "request";
		}
		
		@RequestMapping(value = "/addRequest", method = RequestMethod.POST)
		public ModelAndView addRequest(@ModelAttribute("newRequest") Request req, BindingResult result, HttpServletRequest request) throws SQLException {
			
			ModelAndView model = new ModelAndView();
				//checkDao.getter()
				if(req.getId()==0){
				requestDao.save(req);
			 		
			 	}else{
			 	requestDao.update(req);	
			 	}

			 	/// if its 0 auto inc from db
			 	request.setAttribute("newAppointment", req.getAmka());
				model = new ModelAndView("redirect:/req_user");
			
			return model;
		}
		
		@RequestMapping("/Request/edit/{amka}")
		public String editRequest(@PathVariable("amka") int amka, Model model) {
			model.addAttribute("newRequest", requestDao.getByAmka(amka));
			return "request";
		}

		@RequestMapping("/Request/remove/{amka}")
		public String removeRequest(@PathVariable("amka") int amka) {

			requestDao.deleteByAmka(amka);
			return "redirect:/req_user";
		}

}


