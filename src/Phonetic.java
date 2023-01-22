import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


// POJO
@XmlRootElement
public class Phonetic {
    @SerializedName(value = "text")
    @XmlElement(name = "xxx")
    private String txt;
    public String audio;
    public String sourceUrl;
    public License license;

    @Override
    public String toString() {
        return "Phonetic{" + "text=" + txt + ", audio=" + audio + ", sourceURL=" + sourceUrl + ", licenseName=" + license.name + ", licenseURL=" + license.url + '}';
    }

    public static class License {
        public String name;
        public String url;
    }

}