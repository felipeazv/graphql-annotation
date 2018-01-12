package com.feazesa.graphql;

import com.feazesa.graphql.handler.UserHandler;

import ratpack.server.RatpackServer;

public class Application {
    public static void main(String[] args) throws Exception {
        new Application();
    }

    private Application() throws Exception {
        final RatpackServer server = RatpackServer.of(s -> s.handlers(chain -> chain.post("users", new UserHandler())));
        server.start();
    }
}
