package sample.Config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer
        extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(RedisSessionConfig.class);
    }
}