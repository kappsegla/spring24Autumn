package org.example.spring24.person.dto;

import org.example.spring24.person.valueobject.SocialPlatform;
import org.example.spring24.person.entity.SocialMediaEntity;

public record SocialMediaDto(SocialPlatform platform) {
    public static SocialMediaDto from(SocialMediaEntity socialMedia) {
        return new SocialMediaDto(socialMedia.getPlatform());
    }
}
