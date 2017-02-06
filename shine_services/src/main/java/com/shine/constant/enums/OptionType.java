package com.shine.constant.enums;

public enum OptionType {

    OP_INSERT(1, "����"),

    OP_EDIT(2, "����");

    private final int op;

    private final String desc;

    OptionType(int op, String desc) {
        this.op = op;
        this.desc = desc;
    }

    public int getOp() {
        return op;
    }

    public String getDesc() {
        return desc;
    }
}
