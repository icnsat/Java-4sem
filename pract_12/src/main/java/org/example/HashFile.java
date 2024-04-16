package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashFile {

    private String sourceFileName;
    private String targetFileName;

    public HashFile(String sourceFileName, String targetFileName) {
        this.sourceFileName = sourceFileName;
        this.targetFileName = targetFileName;
    }

    @PostConstruct
    public void hashFile() {
        System.out.println("\nPostConstruct working\n");
        try {
            File sourceFile = new File(sourceFileName);
            if (!sourceFile.exists()) {
                File targetFile = new File(targetFileName);
                try (FileOutputStream fos = new FileOutputStream(targetFile)) {
                    fos.write("null".getBytes());
                }
                return;
            }

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            try (FileInputStream fis = new FileInputStream(sourceFile)) {
                byte[] buffer = new byte[8192];
                int length;
                while ((length = fis.read(buffer)) != -1) {
                    md.update(buffer, 0, length);
                }
            }

            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            File targetFile = new File(targetFileName);
            try (FileOutputStream fos = new FileOutputStream(targetFile)) {
                fos.write(sb.toString().getBytes());
            }

            sourceFile.delete();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("\nPreDestroy working\n");
        File sourceFile = new File(sourceFileName);
        if (sourceFile.exists()) {
            sourceFile.delete();
        }
    }
}