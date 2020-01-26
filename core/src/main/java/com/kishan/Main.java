package com.kishan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args){
        log.info("Hello Info");
//        Create Context
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator
                = context.getBean("numberGenerator",NumberGenerator.class);

//        Call Method Next to get a Random Number
        int number = numberGenerator.next();

//        logging
        log.info("number {}",number);


//        get the game beam from context
        Game game = context.getBean(Game.class);

//        call Reset Method
//        game.reset();


//        Close Context
        context.close();
    }
}
