package com.jsnjfz.manage.config;

import com.jsnjfz.manage.config.properties.GunsProperties;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wang
 * @date 2024/2/3 17:28
 */
@Data
@Component
@ConfigurationProperties(prefix = SftpConfig.PREFIX)
public class SftpConfig {

    public static final String PREFIX = "sftp";

    private String host;
    private String username;
    private String password;
    private Integer port;
}
