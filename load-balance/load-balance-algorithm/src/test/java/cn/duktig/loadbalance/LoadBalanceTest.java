package cn.duktig.loadbalance;

import cn.duktig.loadbalance.algorithm.*;
import cn.duktig.loadbalance.utils.LoadBalanceUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class LoadBalanceTest {

    /**
     * 测试 轮询
     */
    @Test
    public void testRoundRobin() {
        Map<String, Integer> routingMap = LoadBalanceUtil.imitateRouting(new RoundRobinLoadBalance(), 20000);
        // 统计路由结果
        LoadBalanceUtil.countRoutingMap(routingMap);
    }

    /**
     * 测试 随机
     */
    @Test
    public void testRandom() {
        Map<String, Integer> routingMap = LoadBalanceUtil.imitateRouting(new RandomLoadBalance(), 20000);
        // 统计路由结果
        LoadBalanceUtil.countRoutingMap(routingMap);
    }

    /**
     * 测试 加权轮询
     */
    @Test
    public void testWeightRoundRobin() {
        Map<String, Integer> routingMap = LoadBalanceUtil.imitateRouting(new WeightRoundRobinLoadBalance(), 20000);
        // 统计路由结果
        LoadBalanceUtil.countRoutingMap(routingMap);
    }

    /**
     * 测试 加权随机
     */
    @Test
    public void testWeightRandom() {
        Map<String, Integer> routingMap = LoadBalanceUtil.imitateRouting(new WeightRandomLoadBalance(), 20000);
        // 统计路由结果
        LoadBalanceUtil.countRoutingMap(routingMap);
    }

    /**
     * 测试 源地址Hash
     */
    @Test
    public void testHash() {
        Map<String, Integer> routingMap = LoadBalanceUtil.imitateRouting(new HashLoadBalance(), 20000);
        // 统计路由结果
        LoadBalanceUtil.countRoutingMap(routingMap);
    }


}
