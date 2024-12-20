package org.example.spring24.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person", schema = "mydatabase")
@ToString
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 255)
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ColumnDefault("0")
    @Column(name = "programmer")
    private Boolean programmer;

    @ManyToMany
    @JoinTable(name = "person_language",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<LanguageEntity> languages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<SocialMediaEntity> socialMedias = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Boolean programmer) {
        this.programmer = programmer;
    }

    public Set<LanguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<LanguageEntity> languages) {
        this.languages = languages;
    }

    public Set<SocialMediaEntity> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(Set<SocialMediaEntity> socialMedia) {
        this.socialMedias = socialMedia;
    }


    public void addSocialMedia(SocialMediaEntity socialMedia) {
        this.socialMedias.add(socialMedia);
        socialMedia.setPerson(this);
    }

    public void addLanguage(LanguageEntity language) {
        this.languages.add(language);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PersonEntity person = (PersonEntity) o;
        return getId() != null && Objects.equals(getId(), person.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
