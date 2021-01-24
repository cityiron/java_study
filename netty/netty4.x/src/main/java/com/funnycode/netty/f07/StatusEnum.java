package com.funnycode.netty.f07;

/**
 * @author tc
 * @date 2021/1/23
 */
public enum StatusEnum {
    C_S((byte)1),
    S_S((byte)2),
    C_F((byte)3),
    S_F((byte)4),
    C_O((byte)5),
    S_O((byte)56);

    private byte status;

    StatusEnum(byte status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static StatusEnum get(byte status) {
        for (StatusEnum value : values()) {
            if (value.status == status) {
                return value;
            }
        }

        throw new RuntimeException("unsupported status: " + status);
    }
}