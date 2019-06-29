package demo;

import org.protelis.lang.datatype.DeviceUID;
import org.protelis.vm.CodePath;
import org.protelis.vm.ExecutionContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyNetwork {

    private List<DeviceCapabilities> devices;

    public MyNetwork() {
        devices = new ArrayList<>();
    }

    public void attach(DeviceCapabilities device) {
        devices.add(device);
    }

    public void detach(DeviceCapabilities device) {
        devices.remove(device);
    }

    public void runCycle() { }
}
