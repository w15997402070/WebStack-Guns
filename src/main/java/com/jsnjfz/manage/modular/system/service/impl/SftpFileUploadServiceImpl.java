package com.jsnjfz.manage.modular.system.service.impl;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jsnjfz.manage.config.SftpConfig;
import com.jsnjfz.manage.config.properties.GunsProperties;
import com.jsnjfz.manage.modular.system.service.FileUploadService;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wang
 * @date 2024/2/3 17:25
 */
@Service
@Slf4j
public class SftpFileUploadServiceImpl implements FileUploadService {

    @Autowired
    private SftpConfig sftpConfig;
    @Autowired
    private GunsProperties gunsProperties;

    @Override
    public void upload(InputStream inputStream,String fileName) {
        Session session = JschUtil.openSession(sftpConfig.getHost(), sftpConfig.getPort(),
                sftpConfig.getUsername(), sftpConfig.getPassword(), 10 * 1000);

        try {
            boolean connected = session.isConnected();
            if (!connected){
                session.connect();
            }
            session.openChannel("sftp");
        } catch (JSchException e) {
            e.printStackTrace();
        }

        Sftp sftp = JschUtil.createSftp(session);
//        Sftp sftp= JschUtil.createSftp(sftpConfig.getHost(), sftpConfig.getPort(),
//                sftpConfig.getUsername(), sftpConfig.getPassword());
        //进入远程目录
        sftp.cd(gunsProperties.getFileUploadPath());
        //上传本地文件
        sftp.upload(gunsProperties.getFileUploadPath(), fileName, inputStream);
        //关闭连接
        sftp.close();
    }

    @Override
    public byte [] read(String fileName) {
        Session session = JschUtil.openSession(sftpConfig.getHost(), sftpConfig.getPort(),
                sftpConfig.getUsername(), sftpConfig.getPassword(), 10 * 1000);

        try {
            boolean connected = session.isConnected();
            if (!connected){
                session.connect();
            }
            session.openChannel("sftp");
        } catch (JSchException e) {
            e.printStackTrace();
        }

        Sftp sftp = JschUtil.createSftp(session);
        //进入远程目录
        sftp.cd(gunsProperties.getFileUploadPath());
        // 下载文件
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        sftp.download(fileName, outputStream);
        //关闭连接
        sftp.close();
        return outputStream.toByteArray();
    }
}
