package ca.gbc.comp3095.assignment3.services.serviceImpl;

import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.repositories.SupportMessageRepository;
import ca.gbc.comp3095.assignment3.services.SupportMessageService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SupportMessageServiceImpl implements SupportMessageService {

    private final SupportMessageRepository supportMessageRepository;

    public SupportMessageServiceImpl(SupportMessageRepository supportMessageRepository) {
        this.supportMessageRepository = supportMessageRepository;
    }

    @Override
    public Set<SupportMessage> findAll() {
        Set<SupportMessage> supportMessages = new HashSet<>();
        supportMessageRepository.findAll().forEach(supportMessages::add);
        return supportMessages;
    }

    @Override
    public SupportMessage findById(Long aLong) {
        return supportMessageRepository.findById(aLong).orElse(null);
    }

    @Override
    public SupportMessage save(SupportMessage object) {
        return supportMessageRepository.save(object);
    }

    @Override
    public void delete(SupportMessage object) {
        supportMessageRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        supportMessageRepository.deleteById(aLong);
    }
}
