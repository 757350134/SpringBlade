package org.springblade.core.log.kafka;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

/**
 * @Author: wxp
 * @Description:
 * @Date:Create：in 2020/12/31 10:45
 * @Modified By：
 */
@Configuration
@RefreshScope
public class KafkaConfig  implements InitializingBean {

	@Value("${topics}")
	private String topics;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("topics", topics);
	}
}
