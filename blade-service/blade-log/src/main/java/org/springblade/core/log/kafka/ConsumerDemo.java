package org.springblade.core.log.kafka;

/**
 * @Author: wxp
 * @Description:
 * @Date:Create：in 2020/12/30 8:48
 * @Modified By：
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConsumerDemo {
	/**
	 * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
	 * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
	 */


	@KafkaListener(topics = "#{'${topics}'.split(',')}")
	public void listen (ConsumerRecord<?, ?> record){
		System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
	}
}
