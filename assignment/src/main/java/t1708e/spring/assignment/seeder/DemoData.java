package t1708e.spring.assignment.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import t1708e.spring.assignment.entity.Clazz;
import t1708e.spring.assignment.repository.ClazzRepository;

@Component
public class DemoData {

    private final ClazzRepository clazzRepository;

    public DemoData(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        if(clazzRepository.findAll().size() <= 0){
            clazzRepository.save(new Clazz("T1708E"));
            clazzRepository.save(new Clazz("T1709E"));
            clazzRepository.save(new Clazz("T1708M"));
            clazzRepository.save(new Clazz("T1807A"));
            clazzRepository.save(new Clazz("T1711B"));
        }
    }
}