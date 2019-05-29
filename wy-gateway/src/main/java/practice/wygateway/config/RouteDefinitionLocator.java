package practice.wygateway.config;

import org.springframework.cloud.gateway.route.RouteDefinition;
import reactor.core.publisher.Flux;

/**
 * 配置
 *
 * @author wy
 * @create 2019-05-14 17:52
 */
public interface RouteDefinitionLocator {
        Flux<RouteDefinition> getRouteDefinitions();
}
