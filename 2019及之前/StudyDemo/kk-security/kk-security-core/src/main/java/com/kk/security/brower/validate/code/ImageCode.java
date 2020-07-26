package com.kk.security.brower.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Data
public class ImageCode {

    private BufferedImage bufferedImage;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage bufferedImage, String code, int expireInt) {
        this.bufferedImage = bufferedImage;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireInt);
    }
}
