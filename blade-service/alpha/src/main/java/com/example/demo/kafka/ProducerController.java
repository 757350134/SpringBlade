package com.example.demo.kafka;

/**
 * @Author: wxp
 * @Description:
 * @Date:Create：in 2020/12/30 8:48
 * @Modified By：
 */

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProducerController {
	@Value("${topics:bade}")
	private String topics;

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	@PostMapping ("message/send")
	public String send(String topic,String msg){
		kafkaTemplate.send(topic, msg); //使用kafka模板发送信息
		return "success";
	}

	@GetMapping ("message/getTopics")
	public String gTopics(){
		return topics;
	}

}
