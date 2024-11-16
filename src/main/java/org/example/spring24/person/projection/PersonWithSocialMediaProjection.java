package org.example.spring24.person.projection;

import org.example.spring24.person.valueobject.SocialPlatform;

import java.util.Set;

public interface PersonWithSocialMediaProjection {
    String getFullName(); // Maps to `getFullName()` in PersonEntity
    Set<SocialMediaProjection> getSocialMedias(); // Maps to the socialMedias relationship

    interface SocialMediaProjection {
        SocialPlatform getPlatform(); // Maps to the platform in SocialMediaEntity
    }
}
