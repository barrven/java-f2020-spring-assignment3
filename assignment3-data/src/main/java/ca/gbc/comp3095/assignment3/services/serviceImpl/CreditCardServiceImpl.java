package ca.gbc.comp3095.assignment3.services.serviceImpl;

import ca.gbc.comp3095.assignment3.domain.CreditCard;
import ca.gbc.comp3095.assignment3.repositories.CreditCardRepository;
import ca.gbc.comp3095.assignment3.services.CreditCardService;

import java.util.HashSet;
import java.util.Set;

public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Set<CreditCard> findAll() {
        Set<CreditCard> cards = new HashSet<>();
        creditCardRepository.findAll().forEach(cards::add);
        return cards;
    }

    @Override
    public CreditCard findById(Long aLong) {
        return creditCardRepository.findById(aLong).orElse(null);
    }

    @Override
    public CreditCard save(CreditCard object) {
        return creditCardRepository.save(object);
    }

    @Override
    public void delete(CreditCard object) {
        creditCardRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        creditCardRepository.deleteById(aLong);
    }
}
