package config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface BSConfig extends Config {

    @Key("browserstack.id")
    @DefaultValue("idol_LmFU3s")
    String browserstackId();

    @Key("browserstack.key")
    @DefaultValue("Q4pekLModwXLJYxWEYa3")
    String browserstackKey();

    @Key("browserstack.device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String browserstackDevice();

    @Key("browserstack.os_version")
    @DefaultValue("12.0")
    String browserstackOsVersion();

    @Key("browserstack.app")
    @DefaultValue("bs://sample.app")
    String browserstackApp();

    @Key("browserstack.remote.url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String browserstackRemoteUrl();
}

