package org.springblade.core.log.kafka;

/**
 * @Author: wxp
 * @Description:
 * @Date:Create：in 2020/12/30 8:48
 * @Modified By：
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	@RequestMapping("message/send")
	public String send(String msg){
		kafkaTemplate.send("demo", msg); //使用kafka模板发送信息
		return "success";
	}
}
