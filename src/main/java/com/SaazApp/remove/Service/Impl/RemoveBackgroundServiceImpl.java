package com.SaazApp.remove.Service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SaazApp.remove.Client.ClipdropClient;
import com.SaazApp.remove.Service.RemoveBackgroundService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemoveBackgroundServiceImpl implements RemoveBackgroundService{

    @Value("${clipdrop.apikey}")
    private String apikey;

    private final ClipdropClient clipdropClient;

    @Override
    public byte[] removeBackground(MultipartFile file) {
        return clipdropClient.removeBackground(file, apikey);
    }
    
}
