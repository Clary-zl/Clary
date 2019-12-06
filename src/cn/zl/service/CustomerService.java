package cn.zl.service;

import cn.zl.pojo.Customer;
import cn.zl.pojo.QueryVo;
import cn.zl.util.Page;

public interface CustomerService {

	public Page<Customer> getCustomerByQueryVo(QueryVo queryVo);

	public Customer selectById(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Long id);
}