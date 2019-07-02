package data.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import data.service.BmiRecordFactory;
import data.service.BmiRecordService;
import data.service.impl.BmiRecordFactoryImpl;
import data.service.impl.BmiRecordServiceImpl;

public class BmiModule extends AbstractModule {

    @Override
    protected void configure() {
        System.out.println("Bmi module processing...");
        bind(BmiRecordFactory.class).to(BmiRecordFactoryImpl.class).in(Scopes.SINGLETON);
        bind(BmiRecordService.class).to(BmiRecordServiceImpl.class).in(Scopes.SINGLETON);
    }
}
