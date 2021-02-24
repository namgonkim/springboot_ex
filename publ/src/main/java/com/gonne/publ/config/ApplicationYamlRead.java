package com.gonne.publ.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zxcv9455@naver.com on 2021-02-24
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 * Description : 오픈 API 인증키를 YML파일로 관리하기 위해 Configuration으로 설정하고 주입
 */
@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class ApplicationYamlRead {

    private String serviceKey;
}

// application이 아닌 별도의 yml 파일로 관리하고자 한다면?
/*
// resources/forecast.yml
forecast:
        serviceKey: 123123

// config - ForecastYamlRead.java
@Configuration
@PropertySource(value = "classpath:forecast.yml", factory = "YamlPropertySourceFactory.class")
@ConfigurationProperties(prefix = "api")
public class ForecastYamlRead {

    private String serviceKey;

    //getter
    //setter
}

// Factory - YamlPropertySourceFactory.java
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        Properties propertiesFromYaml = loadYamlIntoProperties(resource);
        String sourceName = name != null ? name : resource.getResource().getFilename();
        return new PropertiesPropertySource(sourceName, propertiesFromYaml);
    }

    private Properties loadYamlIntoProperties(EncodedResource resource) throws FileNotFoundException {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();
            return factory.getObject();
        } catch (IllegalStateException e) {
            // for ignoreResourceNotFound
            Throwable cause = e.getCause();
            if (cause instanceof FileNotFoundException)
                throw (FileNotFoundException) e.getCause();
            throw e;
        }
    }
}
 */