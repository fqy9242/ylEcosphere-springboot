package cn.qht2005.ylEcosphere.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "yl-ecosphere.jwt")
public class JwtProperties {
	// 秘钥
	private String secretKey;
	// 过期时间
	private Long ttlMillis;
}
