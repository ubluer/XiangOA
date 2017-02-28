/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 文件管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class SysFile extends DataEntity<SysFile> {
	
	private static final long serialVersionUID = 1L;
	private String filename;		// 附件名称
	private String extension;		// 附件后缀
	private String filepath;		// 附件地址
	private String type;		// 附件类型
	
	public SysFile() {
		super();
	}

	public SysFile(String id){
		super(id);
	}

	@Length(min=0, max=200, message="附件名称长度必须介于 0 和 200 之间")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Length(min=0, max=64, message="附件后缀长度必须介于 0 和 64 之间")
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Length(min=0, max=200, message="附件地址长度必须介于 0 和 200 之间")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Length(min=0, max=20, message="附件类型长度必须介于 0 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}