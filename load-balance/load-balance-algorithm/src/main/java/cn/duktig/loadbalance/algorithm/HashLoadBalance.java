package cn.duktig.loadbalance.algorithm;

import cn.duktig.loadbalance.LoadBalance;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description: 源地址Hash 路由算法
 *
 * @author RenShiWei
 * Date: 2021/9/13 16:54
 **/
public class HashLoadBalance implements LoadBalance {

    /**
     * 获取Ip地址
     *
     * @return IP地址
     */
    public String getIp() {
        try {
            InetAddress ip4 = Inet4Address.getLocalHost();
            return ip4.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 路由
     *
     * @param serverMap 服务列表
     * @return 选择到的一个服务
     */
    @Override
    public String route(Map<String, Integer> serverMap) {
        // 复制遍历用的集合，防止操作中集合有变更
        List<String> serverList = new ArrayList<>(serverMap.size());
        serverList.addAll(serverMap.keySet());
        // 哈希计算请求的服务器
        int index = this.getIp().hashCode() % serverList.size();
        return serverList.get(Math.abs(index));
    }

}

