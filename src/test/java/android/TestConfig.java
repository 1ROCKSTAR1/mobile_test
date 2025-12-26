package android;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${config}.properties"
})
public interface TestConfig extends Config {

    @Key("id")
    String id();

    @Key("key")
    String key();
}
