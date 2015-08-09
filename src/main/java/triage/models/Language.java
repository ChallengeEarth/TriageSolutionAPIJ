package triage.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "languages")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Language {

    @Id
    private String isoCode;
    private String languageExample;
    private String languageIconUrl;

    public String getLanguageExample() {
        return languageExample;
    }

    public void setLanguageExample(String languageExample) {
        this.languageExample = languageExample;
    }

    public String getLanguageIconUrl() {
        return languageIconUrl;
    }

    public void setLanguageIconUrl(String languageIconUrl) {
        this.languageIconUrl = languageIconUrl;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Language() {
    }

    public Language(String isoCode, String languageExample, String languageIconUrl) {
        this.isoCode = isoCode;
        this.languageExample = languageExample;
        this.languageIconUrl = languageIconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (isoCode != null ? !isoCode.equals(language.isoCode) : language.isoCode != null) return false;
        if (languageExample != null ? !languageExample.equals(language.languageExample) : language.languageExample != null)
            return false;
        return !(languageIconUrl != null ? !languageIconUrl.equals(language.languageIconUrl) : language.languageIconUrl != null);

    }

    @Override
    public int hashCode() {
        int result = isoCode != null ? isoCode.hashCode() : 0;
        result = 31 * result + (languageExample != null ? languageExample.hashCode() : 0);
        result = 31 * result + (languageIconUrl != null ? languageIconUrl.hashCode() : 0);
        return result;
    }
}
