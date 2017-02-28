/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xiang.modules.crm.entity.CrmContact;
import com.xiang.modules.crm.dao.CrmContactDao;
import com.xiang.modules.crm.entity.CrmContactPhone;
import com.xiang.modules.crm.dao.CrmContactPhoneDao;

/**
 * 联系人管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmContactService extends CrudService<CrmContactDao, CrmContact> {

	@Autowired
	private CrmContactPhoneDao crmContactPhoneDao;
	
	public CrmContact get(String id) {
		CrmContact crmContact = super.get(id);
		crmContact.setCrmContactPhoneList(crmContactPhoneDao.findList(new CrmContactPhone(crmContact)));
		return crmContact;
	}
	
	public List<CrmContact> findList(CrmContact crmContact) {
		return super.findList(crmContact);
	}
	
	public Page<CrmContact> findPage(Page<CrmContact> page, CrmContact crmContact) {
		return super.findPage(page, crmContact);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContact crmContact) {
		super.save(crmContact);
		for (CrmContactPhone crmContactPhone : crmContact.getCrmContactPhoneList()){
			if (crmContactPhone.getId() == null){
				continue;
			}
			if (CrmContactPhone.DEL_FLAG_NORMAL.equals(crmContactPhone.getDelFlag())){
				if (StringUtils.isBlank(crmContactPhone.getId())){
					crmContactPhone.setCrmContact(crmContact);
					crmContactPhone.preInsert();
					crmContactPhoneDao.insert(crmContactPhone);
				}else{
					crmContactPhone.preUpdate();
					crmContactPhoneDao.update(crmContactPhone);
				}
			}else{
				crmContactPhoneDao.delete(crmContactPhone);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContact crmContact) {
		super.delete(crmContact);
		crmContactPhoneDao.delete(new CrmContactPhone(crmContact));
	}
	
}