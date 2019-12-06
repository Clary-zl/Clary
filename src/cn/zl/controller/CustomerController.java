package cn.zl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zl.pojo.BaseDict;
import cn.zl.pojo.Customer;
import cn.zl.pojo.QueryVo;
import cn.zl.service.BaseDictService;
import cn.zl.service.CustomerService;
import cn.zl.util.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService dictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("customerList")
	public String list(Model model,QueryVo queryVo){
		
		//查询条件
		List<BaseDict> fromType = dictService.getBaseDictsByCode("002");
		List<BaseDict> industryType = dictService.getBaseDictsByCode("001");
		List<BaseDict> levelType = dictService.getBaseDictsByCode("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		Page<Customer> page = customerService.getCustomerByQueryVo(queryVo);
		
		model.addAttribute("page", page);
		model.addAttribute("vo", queryVo);
		
		return "customer";
	}

	@RequestMapping("customerEdit")
	@ResponseBody
	public Customer edit(Integer id){
		Customer customer = customerService.selectById(id);
		return customer;
	}
	
	@RequestMapping(value = "updateCustomer")
	public String updateCustomer(Customer customer, Model model){
		customerService.updateCustomer(customer);
		return "redirect:customerList.action";
	}
	
	@RequestMapping("deleteCustomer")
	public String deleteCustomer(Long id, Model model){
		customerService.deleteCustomer(id);
		return "redirect:customerList.action";
	}
}