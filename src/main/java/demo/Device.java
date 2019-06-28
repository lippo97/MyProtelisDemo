package demo;

import org.protelis.vm.ProtelisProgram;
import org.protelis.vm.ProtelisVM;

public class Device {

    private final ProtelisVM vm;
    private final DeviceCapabilities deviceCapabilities = new DeviceCapabilities(8); //TODO: Magic number

    public Device(ProtelisProgram program) {
        this.vm = new ProtelisVM(program, deviceCapabilities);
    }

    public DeviceCapabilities getDeviceCapabilities() {
        return deviceCapabilities;
    }

    public void runCycle() {
        this.vm.runCycle();
    }
}
