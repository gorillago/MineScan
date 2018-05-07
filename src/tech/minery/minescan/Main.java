package tech.minery.minescan;

import com.jcraft.jsch.JSch;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JSch jsch = new JSch();

        ArrayList<String> hosts = checkHosts("192.168.0");
        for (String host : hosts) {
            System.out.println(host);
        }
    }

    public static ArrayList<String> checkHosts(String subnet){
        int timeout=100;

        ArrayList<String> validHosts = new ArrayList<>();
        for (int i=1;i<255;i++){
            String host=subnet + "." + i;
            try {
                if (InetAddress.getByName(host).isReachable(timeout)){
                    System.out.println(host + " is reachable");
                    validHosts.add(host);
                }
                else {
                    System.out.println(host + " is not reachable");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return validHosts;
    }


}
