package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface EmulatorConfig extends Config {

    @Key("emulator.app.package")
    @DefaultValue("org.wikipedia.alpha")
    String emulatorAppPackage();

    @Key("emulator.app.activity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String emulatorAppActivity();

    @Key("emulator.device.name")
    @DefaultValue("emulator-5554")
    String emulatorDeviceName();

    @Key("emulator.platform.version")
    @DefaultValue("11.0")
    String emulatorPlatformVersion();

    @Key("emulator.remote.url")
    @DefaultValue("http://localhost:4723/wd/hub")
    String emulatorRemoteUrl();

    @Key("emulator.app.path")
    @DefaultValue("src/test/resources/apps/app-alpha-universal-release.apk")
    String emulatorAppPath();
}

