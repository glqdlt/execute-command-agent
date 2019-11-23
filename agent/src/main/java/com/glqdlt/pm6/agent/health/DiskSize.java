package com.glqdlt.pm6.agent.health;

import lombok.ToString;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@ToString
public class DiskSize {
    private Long total;
    private Long free;
    private Long used;

    public DiskSize(Long total, Long free) {
        this.total = total;
        this.free = free;
        this.used = total - free;
    }

    public Long getTotal() {
        return total;
    }

    public Long getFree() {
        return free;
    }

    public Long getUsed() {
        return used;
    }
}
