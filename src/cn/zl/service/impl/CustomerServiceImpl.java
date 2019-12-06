package cn.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zl.dao.CustomerMapper;
import cn.zl.pojo.Customer;
import cn.zl.pojo.QueryVo;
import cn.zl.service.CustomerService;
import cn.zl.util.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> getCustomerByQueryVo(QueryVo vo) {
		
		vo.setStart((vo.getPage()-1)*vo.getRows());
		List<Customer> list = customerMapper.getCustomerByQueryVo(vo);
		Integer total = customerMapper.getCountByVo(vo);
		Page<Customer> page = new Page<Customer>(total, vo.getPage(), vo.getRows(),list);
		return page;
	}
	
	@Override
	public Customer selectById(Integer id) {
		return customerMapper.selectById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomer(id);
	}
}