package com.shine.constant.enums;


import com.shine.constant.IEnum;

public enum UserType implements IEnum {
	MEMBER(0, "��ͨ�û�"), ADMIN(1, "����Ա"), ;

	private final int key;
	private final String desc;

	UserType(final int key, final String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public int key() {
		return this.key;
	}

	@Override
	public String desc() {
		return this.desc;
	}

}
