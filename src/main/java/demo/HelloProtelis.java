package demo;

import org.protelis.lang.ProtelisLoader;
import org.protelis.vm.ProtelisProgram;

public class HelloProtelis {

    private final static String protelisModuleName = "myHello";

    public static void main(String[] args) {
        ProtelisProgram program = ProtelisLoader.parse(protelisModuleName);
        Device d = new Device(program);
        d.runCycle();
    }
}
