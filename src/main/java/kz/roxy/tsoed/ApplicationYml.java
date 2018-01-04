package kz.roxy.tsoed;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ApplicationYml {
    private Synergy synergy;

    private String authCode;

    public static class Synergy {
        private String baseUrl;
        private String createDocUrl;
        private String asformsDataUrl;
        private String asformsDataSaveUrl;

        public String getAsformsDataSaveUrl() {
            return asformsDataSaveUrl;
        }

        public void setAsformsDataSaveUrl(String asformsDataSave) {
            this.asformsDataSaveUrl = asformsDataSave;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public String getCreateDocUrl() {
            return createDocUrl;
        }

        public void setCreateDocUrl(String createDocUrl) {
            this.createDocUrl = createDocUrl;
        }

        public String getAsformsDataUrl() {
            return asformsDataUrl;
        }

        public void setAsformsDataUrl(String asformsDataUrl) {
            this.asformsDataUrl = asformsDataUrl;
        }
    }

    public Synergy getSynergy() {
        return synergy;
    }

    public void setSynergy(Synergy synergy) {
        this.synergy = synergy;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }


}
