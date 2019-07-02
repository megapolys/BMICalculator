import com.google.inject.Guice;
import com.google.inject.Injector;
import data.service.BmiRecordService;
import data.guice.BmiModule;
import data.service.impl.BmiRecordServiceImpl;

public class Main {
    public static void main(String[] args) {
//        Injector injector = Guice.createInjector(new CopyModule());
//        SimpleTest service = injector.getInstance(SimpleTest.class);
//
//        service.doSomething();

        Injector injector = Guice.createInjector(new BmiModule());
        BmiRecordService service = injector.getInstance(BmiRecordService.class);
        BmiRecordService service1 = injector.getInstance(BmiRecordService.class);

        System.out.println(service);
        System.out.println(service1);
    }
}
