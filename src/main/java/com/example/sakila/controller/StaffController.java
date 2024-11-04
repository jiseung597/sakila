package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.mapper.StaffMapper;
import com.example.sakila.vo.Staff;
import com.example.sakila.vo.Store;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StaffController {
	@Autowired StaffMapper stafMapper;
	@Autowired storeMapper;
	@GetMapping("/on/addStaff")
	public String addStaff(Model model) {
		// model(storeList)
		List<Store> storeList = storeMapper.selectStoreList();
		model.addAttribute("storeList", storeList);
		
		// model(addressList) <- 검색후
		return "on/addStaff.jsp";
	}

	@PostMapping("/on/addStaff")
	public String addStaff(Staff staff) {
		// insert 호출
		return "redirect:/on/StaffList";
	}
	
	@GetMapping("/on/staffList")
	public String staffList(
		Model model			,	@RequestParam(defaultValue = "1") int currentPage) {
		// @model(staffList)
		return "on/staffList";
	}
	
	
	@GetMapping("/on/staffOne") {
		public String staffOne(HttpSession session, Model model) {
			int staffId = ((Staff)(session.getAttribute("loginStaff"))).getStaffId();
			Map<String, Object> staff = staffMapper.selectStaffONe(staffId);
			model.addAttribute("staff", staff);
			log.debug(staff.toString());
			return "on/staffOne";
		}
		
	}







}
