package com.jsnjfz.manage.modular.system.service;

import java.io.InputStream;

/**
 * @author wang
 * @date 2024/2/3 17:24
 */
public interface FileUploadService {

    void upload(InputStream inputStream, String fileName);

    byte[] read(String fileName);

}
