package com.kodehive.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class TesSendKafka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		for (int i = 0; i < 10; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<>("test-topic",
					"Masuk Data ke " + i);
			producer.send(record);
		}

		producer.close();
	}

}
