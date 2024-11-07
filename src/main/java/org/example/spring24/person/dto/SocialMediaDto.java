package org.example.spring24.person.dto;

import org.example.spring24.person.valueobject.SocialPlatform;
import org.example.spring24.person.entity.SocialMedia;

public record SocialMediaDto(SocialPlatform platform) {
    public static SocialMediaDto from(SocialMedia socialMedia) {
        return new SocialMediaDto(socialMedia.getPlatform());
    }
}
