package com.shine.bean;

import java.io.Serializable;
import java.util.List;

public class ShineMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 标题 */
	private String title;

	/** 地址 */
	private String url;

	/** 权限编码 */
	private String permCode;

	/** 图标 */
	private String icon;

	private List<ShineMenu> shineMenus;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermCode() {
		return this.permCode;
	}

	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<ShineMenu> getShineMenus() {
		return shineMenus;
	}

	public void setShineMenus(List<ShineMenu> shineMenus) {
		this.shineMenus = shineMenus;
	}


}
