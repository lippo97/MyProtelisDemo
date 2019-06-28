package demo;

import org.protelis.lang.datatype.DeviceUID;
import org.protelis.lang.datatype.Field;
import org.protelis.vm.NetworkManager;
import org.protelis.vm.TimeAwareDevice;
import org.protelis.vm.impl.AbstractExecutionContext;
import org.protelis.vm.impl.SimpleExecutionEnvironment;

public class DeviceCapabilities extends AbstractExecutionContext {

    private MyDeviceUID uid;

    public DeviceCapabilities(final int uid) {
        super(new SimpleExecutionEnvironment(), new MyNetworkManager());
        this.uid = new MyDeviceUIDImpl(uid);
    }

    public void announce(String msg) {
        System.out.println(msg);
    }

    public void announce(int a) {
        System.out.println(a);
    }


    @Override
    protected AbstractExecutionContext instance() {
        return new DeviceCapabilities(this.uid.getUID());
    }

    @Override
    public DeviceUID getDeviceUID() {
        return uid;
    }

    @Override
    public Number getCurrentTime() {
        return System.currentTimeMillis();
    }

    @Override
    public double nextRandomDouble() {
        return Math.random();
    }
}
