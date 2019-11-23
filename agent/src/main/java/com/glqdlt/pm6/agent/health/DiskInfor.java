package com.glqdlt.pm6.agent.health;

import lombok.ToString;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@ToString
public class DiskInfor {
    private String name;
    private DiskSize diskSize;

    public DiskInfor(String name, Long total, Long free) {
        this.name = name;
        this.diskSize = new DiskSize(total, free);
    }

    public String getName() {
        return name;
    }

    public DiskSize getDiskSize() {
        return diskSize;
    }
}
