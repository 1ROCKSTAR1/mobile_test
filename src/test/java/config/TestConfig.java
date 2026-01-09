package config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface TestConfig extends Config {

    @Key("run.type")
    @DefaultValue("local")
    String runType();

    @Key("test.type")
    @DefaultValue("full")
    String testType();

    // BrowserStack параметры
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

    @Key("app")
    @DefaultValue("bs://sample.app")
    String app();

    // Локальные параметры
    @Key("app.package")
    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @Key("app.activity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @Key("device.name")
    @DefaultValue("emulator-5554")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("remote.url")
    @DefaultValue("http://localhost:4723/wd/hub")
    String remoteUrl();
}

