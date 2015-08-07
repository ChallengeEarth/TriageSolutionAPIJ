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
}
