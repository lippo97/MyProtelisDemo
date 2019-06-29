package demo;

import org.protelis.vm.ProtelisProgram;
import org.protelis.vm.ProtelisVM;

public class Device {

    private final ProtelisVM vm;
    private final DeviceCapabilities deviceCapabilities;

    public Device(ProtelisProgram program, int uid) {
        deviceCapabilities = new DeviceCapabilities(uid);
        this.vm = new ProtelisVM(program, deviceCapabilities);
    }

    public DeviceCapabilities getDeviceCapabilities() {
        return deviceCapabilities;
    }

    public void runCycle() {
        this.vm.runCycle();
    }
}
