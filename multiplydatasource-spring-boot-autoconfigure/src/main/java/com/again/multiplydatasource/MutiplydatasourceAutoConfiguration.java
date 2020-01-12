package com.again.multiplydatasource;

import com.again.multiplydatasource.core.DataSourceRegistry;
import com.again.multiplydatasource.core.JTAConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * 多数据源自动装配引导
 * <p>
 * 需要关掉 两个数据源的自动装配功能
 *
 * @author again
 */
@Configuration
@Import({DataSourceRegistry.class, JTAConfig.class})
// 必须要再俩个配置类之前使用， 不然提示驱动找不到
@AutoConfigureBefore({DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class MutiplydatasourceAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MutiplydatasourceAutoConfiguration.class);

    @PostConstruct
    public void init() {

        logger.info("正在开始注册多数据源！");
    }

}
