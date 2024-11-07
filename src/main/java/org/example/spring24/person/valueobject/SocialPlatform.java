package org.example.spring24.person.valueobject;

public record SocialPlatform(String platformName) {

    public SocialPlatform {
        if (platformName == null || platformName.isEmpty())
            throw new IllegalArgumentException();
    }
}
