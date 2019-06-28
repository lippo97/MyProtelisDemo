package demo;

import org.protelis.vm.CodePath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyNetwork {

    private List<Device> devices;

    public MyNetwork() {
        devices = new ArrayList<>();
    }

    public void attach(Device device) {
        devices.add(device);
    }

    public void detach(Device device) {
        devices.remove(device);
    }

    public void runCycle() {

    }
}
