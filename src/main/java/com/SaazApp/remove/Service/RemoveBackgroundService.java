package com.SaazApp.remove.Service;

import org.springframework.web.multipart.MultipartFile;


public interface RemoveBackgroundService {

    byte[] removeBackground(MultipartFile file);
}
