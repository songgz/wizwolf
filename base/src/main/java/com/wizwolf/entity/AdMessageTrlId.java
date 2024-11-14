package com.wizwolf.entity;

import java.io.Serializable;
import java.util.Objects;

public class AdMessageTrlId implements Serializable {
    private Long messageId;
    private String language;

    public AdMessageTrlId() {}

    public AdMessageTrlId(Long adMessageId, String adLanguage) {
        this.messageId = adMessageId;
        this.language = adLanguage;
    }


    public boolean equals(Object o) {
        AdMessageTrlId obj = (AdMessageTrlId) o;
        return messageId == obj.messageId && language == obj.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, language);
    }
}
