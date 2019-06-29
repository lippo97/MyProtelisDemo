package demo;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.protelis.lang.ProtelisLoader;
import org.protelis.lang.datatype.DeviceUID;
import org.protelis.vm.CodePath;
import org.protelis.vm.ProtelisProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.*;

public class HelloProtelis {

    private final static String protelisModuleName = "hello";
    private final static int N = 5;
    private final static List<Device> devices = new ArrayList<>();
    private final static MyNetwork network = new MyNetwork();

    public static void main(String[] args) {
        useJgrapht();
    }

    private static void useJgrapht() {
        // Initialize a graph
        Graph<Device, DefaultEdge> g = new DefaultUndirectedGraph<>(DefaultEdge.class);
        // Initialize some devices
        for (int i = 0; i < N; i++) {
            ProtelisProgram program = ProtelisLoader.parse(protelisModuleName);
            Device d = new Device(program, i);
            devices.add(d);
        }
        // Make the first one leader
        devices.get(0).getDeviceCapabilities().getExecutionEnvironment().put("leader", true);
        // Add the devices into the graph and link them as a ring network
        g.addVertex(devices.get(0));
        for (int i = 1; i < devices.size(); i++) {
            g.addVertex(devices.get(i));
            g.addEdge(devices.get(i - 1), devices.get(i));
        }
        g.addEdge(devices.get(devices.size()-1), devices.get(0));
        // Let the devices execute 3 timestoSend
        for (int i = 0; i < 3; i++) {
            devices.forEach(Device::runCycle);
            devices.forEach(d -> {
                // Retrieve uid and message to send
                DeviceUID uid = d.getDeviceCapabilities().getDeviceUID();
                Map<CodePath, Object> toSend = d.getDeviceCapabilities().accessNetworkManager().getToSend();
                // Retrieve current device neighbors and set their state
                Set<Device> neighbors = Graphs.neighborSetOf(g, d);
                neighbors.forEach(n -> n.getDeviceCapabilities().accessNetworkManager().setNeighborState(uid, toSend));
            });
        }
    }

    private static void useList() {
        // Create a device team
        for (int i = 0; i < N; i++) {
            // Load the protelis module
            ProtelisProgram program = ProtelisLoader.parse(protelisModuleName);
            Device d = new Device(program, i);
            devices.add(d);
            network.attach(d.getDeviceCapabilities());
        }
        // Set 0 as leader
        devices.get(0).getDeviceCapabilities().getExecutionEnvironment().put("leader", true);
        for (int i = 0; i < 3; i++) {
            devices.forEach(Device::runCycle);
            network.runCycle();
        }
    }
}
