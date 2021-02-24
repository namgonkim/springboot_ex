package com.gonne.publ.apiTest;

import com.gonne.publ.config.ApplicationYamlRead;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by zxcv9455@naver.com on 2021-02-24
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */
@SpringBootTest
public class ApplicationYamlReadTest {

    @Autowired
    ApplicationYamlRead applicationYamlRead;

    @Test
    public void yml_서비스키읽기() {
        // given
        String key = "K3v1XbBvSzQvSryBAMMNyY0iXUqxfG5ZaaqjRHGLqPFbTNEbJnzFv5SWtKfRVsYKNw6DZYuBkardcak%2F2PNDqQ%3D%3D";

        // when
        String serviceKey = applicationYamlRead.getServiceKey();

        // then
        assertThat(serviceKey).isEqualTo(key);

    }
}
