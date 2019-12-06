package cn.zl.dao;

import java.util.List;

import cn.zl.pojo.Customer;
import cn.zl.pojo.QueryVo;

public interface CustomerMapper {
	
	public Integer getCountByVo(QueryVo vo);

	public List<Customer> getCustomerByQueryVo(QueryVo vo);

	public Customer selectById(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Long id);
}