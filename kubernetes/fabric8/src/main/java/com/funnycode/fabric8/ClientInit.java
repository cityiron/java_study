package com.funnycode.fabric8;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author tc
 * @date 2021/1/18
 */
public class ClientInit {

    public static void main(String[] args) {
        Config config = Config.fromKubeconfig(null, null, "/Users/tc/.kube/config.sandbox");
        KubernetesClient client = new DefaultKubernetesClient(config);
        // # env | grep HOSTNAME
        // HOSTNAME=unifacegd-0
        Pod pod = client.pods().withName("TieCheng").get();
    }

}
