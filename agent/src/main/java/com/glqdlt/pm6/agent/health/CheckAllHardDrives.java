package com.glqdlt.pm6.agent.health;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Component
public class CheckAllHardDrives {
    public List<DiskInfor> getAlLDriveSpace() {
        return Stream.of(File.listRoots())
                .map(x -> new DiskInfor(x.getPath(), x.getTotalSpace(), x.getFreeSpace()))
                .collect(Collectors.toList());
    }
}
