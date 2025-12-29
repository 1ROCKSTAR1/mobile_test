package android;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${config}.properties"
})
public interface TestConfig extends Config {

    @Key("id")
    @DefaultValue("idol_LmFU3s")
    String id();

    @Key("key")
    @DefaultValue("Q4pekLModwXLJYxWEYa3")
    String key();
}
